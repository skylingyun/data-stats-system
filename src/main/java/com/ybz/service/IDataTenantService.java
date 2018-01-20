package com.ybz.service;

import com.ybz.entity.Tenant;
import com.ybz.entity.TenantUserRelation;
import com.ybz.entity.User;
import com.ybz.utils.DataResult;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;


/**
 * 用户和租户的接口
 *
 * @author zhangybt
 * @create 2017年08月02日 13:35
 **/
public interface IDataTenantService {

    /**
     *
     * @param userMobile
     * @return
     * @throws Exception
     */
    List<Object> getTenantListByUserMobile(String userMobile) throws Exception;

    /**
     * 根据下拉列表选择的租户名称查询租户信息
     * @param tenantName
     * @return
     */
    List<Tenant> getTenantInfoByTenantName(String tenantName) throws Exception;

    DataResult getUserByPhone(String tenantId, String userMobile);

    List<User> queryUserListByValid(Map<String, String> map);

    int countByValid(Map<String, String> map);

    /**
     * 同步租户用户关系
     *
     * @param tenantId
     * @param offset
     * @param limit
     * @return
     */
    int updateTenantUserRelation(String tenantId, int offset, int limit) throws Exception;

    int count();

    List<TenantUserRelation> queryTenantUserRelation(String tenantId, int offset, int limit) throws Exception;

    /**
     * 查询租户列表
     * @param offset
     * @param limit
     * @return
     * @throws Exception
     */
    List<Tenant> queryTenantInfoList(int offset, int limit) throws Exception;

    /**
     * 删除单个用户与租户的关系
     * @param userMobile
     * @param tenantId
     * @return
     */
    JSONObject deleteSingleRelation(String userMobile, String tenantId) throws Exception;

    /**
     * 批量删除用户租户关系
     * @param tenantId
     * @param phone
     * @return
     * @throws Exception
     */
    List<String> deleteRelationBatch(String tenantId, String[] phone) throws Exception;

    /**
     * 为单个用户添加租户关系
     * @param userMobile
     * @param tenantId
     * @return
     * @throws Exception
     */
    JSONObject addRelationshipForUser(String userMobile, String tenantId) throws Exception;

    /**
     * 添加新的租户ID
     * @param tenantId
     * @throws Exception
     */
    void addNewTenant(String tenantId) throws Exception;

    /**
     * 获取所有的租户ID列表
     * @return
     * @throws Exception
     */
    List<Map<String,String>> getDataBasesList() throws Exception;

    /**
     * 删除该租户的关系
     * @param tenantId
     * @return
     * @throws Exception
     */
    List<String> deleteRelationshipForTenant(String tenantId) throws Exception;


    List<User> queryUserMobileByCreateTime();


    List<Tenant> getTenants(int offset, int limit) throws Exception;

    /**
     * 添加新的租户ID
     * @throws Exception
     */
    void addActiveUser(Map<String,String> params) throws Exception;

    void checkTenantIdExist() throws Exception;

}
