package com.ybz.service;

import com.ybz.entity.NodeBills;
import com.ybz.exception.CustomRuntimeException;

import java.util.List;
import java.util.Map;

/**
 * 所有单据接口
 * Created by Guoru on 2017/8/10.
 */
public interface IDataBillsService {
    /**
     * 查询单据统计信息
     * @param beginTime 查询开始日期
     * @param endTime 查询结束日期
     * @param offset 当前页
     * @param limit 每页总数
     * @return
     */
    List<List<NodeBills>> getDataBillsPage(String beginTime, String endTime, int offset, int limit) throws Exception;

    /**
     * 查询某租户近五天单据信息
     * @param tenantId
     * @return
     */
    List<List<NodeBills>> getBillsListDetail(String tenantId) throws Exception;

    /**
     * 导出单据统计报表接口
     * @throws CustomRuntimeException
     */
    void exportBillsToExcel() throws Exception;

    /**
     * 获取单据统计报表信息
     * @param offset
     * @param limit
     * @return
     * @throws Exception
     */
    List<Map<String, String>> getBillsToExcel(int offset, int limit) throws Exception;

    /**
     * 获取总数量，用于分页
     * @return
     */
    int getDataBillsCount() throws Exception;
}
