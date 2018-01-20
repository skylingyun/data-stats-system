package com.ybz.shiro;

import com.ybz.entity.ManagerUser;
import com.ybz.entity.Menu;
import com.ybz.service.IDataManagerUserService;
import com.ybz.service.IDataMenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.*;


/**
 * 认证
 * 
 * @author zhangybt
 * @email zhangybt@yonyou.com
 * @date 2017年8月1日 上午11:17:49
 */
public class UserRealm extends AuthorizingRealm {
    @Resource(name = "dataManagerUserServiceImpl")
    private IDataManagerUserService dataManagerUserService;
    @Resource(name = "dataMenuServiceImpl")
    private IDataMenuService dataMenuService;
    
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ManagerUser user = (ManagerUser)principals.getPrimaryPrincipal();
		Long userId = user.getUserId();

		List<String> permsList = null;

//		//系统管理员，拥有最高权限
		if(userId == 1){
			List<Menu> menuList = dataMenuService.queryList(new HashMap<String, Object>());
			permsList = new ArrayList<String>(menuList.size());
			for(Menu menu : menuList){
				permsList.add(menu.getPerms());
			}
		}else{
			permsList = dataManagerUserService.queryAllPerms(userId);
		}

//		//用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for(String perms : permsList){
			if(StringUtils.isBlank(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(null);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        
        //查询用户信息
        ManagerUser user = dataManagerUserService.queryByUserName(username);

        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        //密码错误
        if(!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        //账号锁定
        if(user.getStatus() == 0){
        	throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(null, password, getName());
        return info;
	}

}
