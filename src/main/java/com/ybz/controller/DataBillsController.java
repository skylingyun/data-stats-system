package com.ybz.controller;

import com.ybz.entity.NodeBills;
import com.ybz.exception.CustomException;
import com.ybz.exception.CustomRuntimeException;
import com.ybz.service.IDataBillsService;
import com.ybz.utils.*;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.tenant.sdk.TenantCenter;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.soap.Node;
import java.util.*;

/**
 * 所有单据的接口
 * Created by Guoru on 2017/8/10.
 */
@RestController
@RequestMapping("/bills")
public class DataBillsController {
    @Resource(name = "dataBillsServiceImpl")
    private IDataBillsService dataBillsService;
    private static LoggerHelper logger = new LoggerHelper(DataBillsController.class);

    /**
     * 获取单据统计信息接口
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/getBillsList", method = RequestMethod.POST)
    public DataResult getBillsCount(@RequestBody Map<String, String> map) {
        try {
            String beginTime = map.get("beginTime");
            String endTime = map.get("endTime");
            List<List<NodeBills>> list = dataBillsService.getDataBillsPage(beginTime, endTime, Integer.parseInt(map.get("activePage")), Integer.parseInt(map.get("totalPage")));
            int count = dataBillsService.getDataBillsCount();
            return DataResult.ok().put("data", new PageUtils(list, count, Integer.parseInt(map.get("totalPage")), Integer.parseInt(map.get("activePage"))));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 获取某一租户近五天的单据统计信息
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/getBillsListDetail", method = RequestMethod.POST)
    public DataResult getBillsListDetail(@RequestBody Map<String, String> map) {
        try {
            String tenantId = map.get("tenantId");
            List<List<NodeBills>> list = dataBillsService.getBillsListDetail(tenantId);
            return DataResult.ok().put("data", list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 导出单据统计报表接口
     *
     * @return
     */
    @RequestMapping(value = "/exportBillsToExcel", method = RequestMethod.POST)
    public DataResult exportBillsToExcel() {
        try {
            dataBillsService.exportBillsToExcel();
            return DataResult.ok().put("data", "导出成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 获取单据统计报表信息
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/getBillsToExcel", method = RequestMethod.POST)
    public DataResult getBillsToExcel(@RequestBody Map<String, String> map) {
        try {
            int count = dataBillsService.getDataBillsCount();
            List<Map<String, String>> resultList = dataBillsService.getBillsToExcel(Integer.parseInt(map.get("activePage")), Integer.parseInt(map.get("totalPage")));
            return DataResult.ok().put("data", new PageUtils(resultList, count, Integer.parseInt(map.get("totalPage")), Integer.parseInt(map.get("activePage"))));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }
}
