package com.ybz.utils;

import com.yonyou.iuap.tenant.sdk.TenantCenter;
import com.yonyou.iuap.tenant.sdk.UserCenter;
import net.sf.json.JSONObject;
import org.opensaml.xml.signature.J;
import org.springframework.util.StringUtils;

/**
 * 获取用户信息工具类
 *
 * @author zhangybt
 * @create 2017年08月02日 10:28
 **/
public class TenantUserUtil {

    public static final String systemId = "ssc_baozhang";
    public static final String password = "yonyou@123";
    public static final Integer userType = 000;

    public static String getTenantUserIdByPhone(String phone) {
        try {
            String userInfo = UserCenter.getUserByLoginName(phone);
            if (!StringUtils.isEmpty(userInfo)) {
                JSONObject info = JSONObject.fromObject(userInfo);
                if (info.has("status") && "1".equals(info.getString("status"))) {
                    JSONObject userObj = info.getJSONObject("user");
                    return (String) userObj.get("userId");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String queryTenantNameByTenantId(String tenantId){
        try {
            JSONObject tenantInfo = JSONObject.fromObject(TenantCenter.getTenantById(tenantId));
            if(tenantInfo.containsKey("tenant")){
                JSONObject tenant = JSONObject.fromObject(tenantInfo.get("tenant"));
                return tenant.optString("tenantName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
