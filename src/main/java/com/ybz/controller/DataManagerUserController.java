package com.ybz.controller;

import com.ybz.entity.ManagerUser;
import com.ybz.service.IDataManagerUserService;
import com.ybz.service.IDataUserRoleService;
import com.ybz.utils.DataResult;
import com.ybz.utils.PageUtils;
import com.ybz.utils.ShiroUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author zhangybt
 * @create 2017年09月16日 16:38
 **/
@RestController
@RequestMapping("/manager")
public class DataManagerUserController extends AbstractController{

    @Resource(name = "dataManagerUserServiceImpl")
    private IDataManagerUserService dataManagerUserService;

    @Resource(name = "dataUserRoleServiceImpl")
    private IDataUserRoleService dataUserRoleService;

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public DataResult list(String username, Integer page, Integer limit){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("offset", (page - 1) * limit);
        map.put("limit", limit);

        //查询列表数据
        List<ManagerUser> userList = dataManagerUserService.queryList(map);
        int total = dataManagerUserService.queryTotal(map);

        PageUtils pageUtil = new PageUtils(userList, total, limit, page);

        return DataResult.ok().put("page", pageUtil);
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info")
    public DataResult info(){
        return DataResult.ok().put("user", getUser());
    }

    /**
     * 修改登录用户密码
     */
    @RequestMapping("/password")
    public DataResult password(String password, String newPassword){
        if(StringUtils.isBlank(newPassword)){
            return DataResult.error("新密码不为能空");
        }

        //sha256加密
        password = new Sha256Hash(password).toHex();
        //sha256加密
        newPassword = new Sha256Hash(newPassword).toHex();

        //更新密码
        int count = dataManagerUserService.updatePassword(getUserId(), password, newPassword);
        if(count == 0){
            return DataResult.error("原密码不正确");
        }

        //退出
        ShiroUtils.logout();

        return DataResult.ok();
    }

    /**
     * 用户信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public DataResult info(@PathVariable("userId") Long userId){
        ManagerUser user = dataManagerUserService.queryObject(userId);

        //获取用户所属的角色列表
        List<Long> roleIdList = dataUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);

        return DataResult.ok().put("user", user);
    }

    /**
     * 保存用户
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:save")
    public DataResult save(@RequestBody ManagerUser user){
        if(StringUtils.isBlank(user.getUsername())){
            return DataResult.error("用户名不能为空");
        }
        if(StringUtils.isBlank(user.getPassword())){
            return DataResult.error("密码不能为空");
        }

        dataManagerUserService.save(user);

        return DataResult.ok();
    }

    /**
     * 修改用户
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public DataResult update(@RequestBody ManagerUser user){
        if(StringUtils.isBlank(user.getUsername())){
            return DataResult.error("用户名不能为空");
        }

        dataManagerUserService.update(user);

        return DataResult.ok();
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public DataResult delete(@RequestBody Long[] userIds){
        if(ArrayUtils.contains(userIds, 1L)){
            return DataResult.error("系统管理员不能删除");
        }

        if(ArrayUtils.contains(userIds, getUserId())){
            return DataResult.error("当前用户不能删除");
        }

        dataManagerUserService.deleteBatch(userIds);

        return DataResult.ok();
    }
    

}
