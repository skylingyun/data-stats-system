package com.ybz.controller;

import com.ybz.entity.Tenant;
import com.ybz.service.IDataUserService;
import com.ybz.utils.*;
import org.apache.http.HttpResponse;
import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by zhangybt on 2018/1/3.
 */
@RestController
@RequestMapping("/dataTenant")
public class DataUserController {

    @Autowired
    private IDataUserService dataUserService;

    @RequestMapping(value = "/getDataTenantInfo", method = RequestMethod.POST)
    public DataResult getDataTenantInfo(@RequestBody Map<String, String> params) throws Exception {
        Date startDate = DateUtils.format(params.get("beginTime"));
        Date endDate = DateUtils.format(params.get("endTime"));
        List<Tenant> tenantList = dataUserService.selectTenantDetail(startDate, endDate);
        int count = DataBaseUtils.queryDataBasesCountFromExcel();
        PageUtils pageUtils = new PageUtils(tenantList, count, 20, 1);
        return DataResult.ok().put("data", pageUtils);
    }

    @RequestMapping(value = "/getDataBaseList", method = RequestMethod.POST)
    public DataResult getDataBaseList() throws Exception {
        List<String> list = dataUserService.getDataBaseList();
        PageUtils pageUtils = new PageUtils(list, 1000, 20, 1);
        return DataResult.ok().put("data", pageUtils);
    }

    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    public DataResult exportExcel(@RequestBody Map<String, String> params, HttpServletResponse response) throws Exception {
        Date startDate = DateUtils.format(params.get("beginTime"));
        Date endDate = DateUtils.format(params.get("endTime"));
        String sheetName = "租户和单据统计表";
        String titleName = "租户和单据统计列表";
        List<String> headList = new ArrayList<String>();
        headList.add("租户ID");
        headList.add("开通用户总人数");
        headList.add("报销人总数(有效)");
        headList.add("报销人总数");
        headList.add("报销单总数");
        headList.add("单据总数量(有效)");
        headList.add("单据总数量");
        headList.add("单据总金额");
        headList.add("记账记账总数");
        headList.add("第三方记账总数");
        headList.add("已审批单据总数量");
        List<String> fileName = new ArrayList<String>();
        fileName.add("tenantId");
        List dataSet = dataUserService.selectTenantDetail(startDate, endDate);
        String pattern = "yyyy-MM-dd";
        new ExportExcelUtils().exportExcelResponse(sheetName, titleName, headList.toArray(new String[0]), dataSet,response, pattern);
        return DataResult.ok().put("data","success");
    }


}
