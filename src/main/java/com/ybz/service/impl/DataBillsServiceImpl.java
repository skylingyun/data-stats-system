package com.ybz.service.impl;

import com.ybz.entity.NodeBills;
import com.ybz.exception.CustomRuntimeException;
import com.ybz.service.IDataBillsService;
import com.ybz.service.IDataOcsApplyService;
import com.ybz.service.IDataOcsExpenseService;
import com.ybz.service.IDataOcsLoanService;
import com.ybz.utils.*;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.tenant.sdk.TenantCenter;
import net.sf.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by Guoru on 2017/8/10.
 */
@Service
public class DataBillsServiceImpl implements IDataBillsService {
    @Resource(name = "dataOcsApplyServiceImpl")
    IDataOcsApplyService dataNodeBusinessTripService;

    @Resource(name = "dataOcsExpenseServiceImpl")
    IDataOcsExpenseService dataNodeExpenseService;

    @Resource(name = "dataOcsLoanServiceImpl")
    IDataOcsLoanService dataNodeLoanBillService;

    private static LoggerHelper logger = new LoggerHelper(DataBillsServiceImpl.class);

    public List<List<NodeBills>> getDataBillsPage(String beginTime, String endTime, int offset, int limit) throws Exception{
        try {
            List<List<NodeBills>> noteBillsList = new LinkedList<List<NodeBills>>();
            List<String> dataBasesList = DataBaseUtils.queryDataBasesListFromExcel(offset, limit);
            for (int i = 0; i < dataBasesList.size(); i++) {
                if (dataBasesList.get(i).length() != 8) {
                    continue;
                }
                InvocationInfoProxy.setTenantid(dataBasesList.get(i));
                List<NodeBills> nodeBillsList = queryBillsByTenantId(beginTime, endTime, dataBasesList.get(i));
                noteBillsList.add(nodeBillsList);
            }
            return noteBillsList;
        } catch (Exception e) {
            logger.error("查询单据统计信息失败", e.getMessage());
            throw new CustomRuntimeException("查询单据统计信息失败");
        }
    }

    private List<NodeBills> queryBillsByTenantId(String beginTime, String endTime, String tenantId) {
        InvocationInfoProxy.setTenantid(tenantId);
        NodeBills nodeBills = new NodeBills();
        List<NodeBills> list = new LinkedList<NodeBills>();
        int businessTripCount = dataNodeBusinessTripService.countByExample(beginTime, endTime);
        Double businessTripMoney = dataNodeBusinessTripService.queryMoneyByDate(beginTime, endTime);
        int expenseCount = dataNodeExpenseService.countByExample(beginTime, endTime);
        Double expenseMoney = dataNodeExpenseService.queryMoneyByDate(beginTime, endTime);
        int loanBillCount = dataNodeLoanBillService.countByExample(beginTime, endTime);
        Double loanBillMoney = dataNodeLoanBillService.queryMoneyByDate(beginTime, endTime);
        double result = ArithUtils.add(businessTripMoney, expenseMoney);
        double totalMoney = ArithUtils.add(loanBillMoney, result);
        nodeBills.setTenantId(tenantId);
        nodeBills.setTenantName(TenantUserUtil.queryTenantNameByTenantId(tenantId));
        nodeBills.setBusinessTripCount(businessTripCount);
        nodeBills.setBusinessTripMoney(businessTripMoney);
        nodeBills.setExpenseCount(expenseCount);
        nodeBills.setExpenseMoney(expenseMoney);
        nodeBills.setLoanBillCount(loanBillCount);
        nodeBills.setLoanBillMoney(loanBillMoney);
        nodeBills.setTotalCount(businessTripCount + expenseCount + loanBillCount);
        nodeBills.setTotalMoney(totalMoney);
        nodeBills.setTime(beginTime);
        nodeBills.setEndDate(endTime);
        list.add(nodeBills);
        return list;
    }

    @Override
    public List<Map<String, String>> getBillsToExcel(int offset, int limit) throws Exception {
        List<List<String>> resultList = getExportedBills(offset, limit);
        List<Map<String, String>> fieldMapList = new ArrayList<Map<String, String>>();
        Map<String, String> fieldMap = null;
        if (resultList != null && resultList.size() > 0) {
            for (List<String> billFieldList : resultList) {
                fieldMap = new HashMap<String, String>();
                fieldMap.put("tenantFullname", billFieldList.get(0));
                fieldMap.put("tenantName", billFieldList.get(1));
                fieldMap.put("isOpen", billFieldList.get(2));
                fieldMap.put("tenantId", billFieldList.get(3));
                fieldMap.put("total1", billFieldList.get(4));
                fieldMap.put("total2", billFieldList.get(5));
                fieldMap.put("total3", billFieldList.get(6));
                fieldMap.put("total4", billFieldList.get(7));
                fieldMap.put("total5", billFieldList.get(8));
                fieldMap.put("increment", billFieldList.get(9));
                fieldMapList.add(fieldMap);
            }
        }
        return fieldMapList;
    }

    @Override
    public List<List<NodeBills>> getBillsListDetail(String tenantId) throws Exception{
        String beginTime = "";
        String endTime = "";
        List<List<NodeBills>> list = new ArrayList<List<NodeBills>>();
        List<NodeBills> nodeBillses = null;
        for (int i = 5; i > 0; i--){
            beginTime = DateUtils.format(DateUtils.getDateBefore(new Date(), i));
            endTime = DateUtils.format(DateUtils.getDateBefore(new Date(), i-1));
            nodeBillses = queryBillsByTenantId(beginTime, endTime, tenantId);
            list.add(nodeBillses);
        }
        return list;
    }

    public List<List<String>> getExportedBills(int offset, int limit) throws Exception {
        String beginTime = "";
        String endTime = "";
        NodeBills nodeBills = null;
        List<List<String>> resultList = new ArrayList<List<String>>();
        List<String> dataBasesList = DataBaseUtils.queryDataBasesListFromExcel(offset, limit);
        for (int i = 0; i < dataBasesList.size(); i++) {
            if (dataBasesList.get(i).length() != 8) {
                continue;
            }
            List<NodeBills> nodeBillsList = new ArrayList<NodeBills>();
            List<NodeBills> tempList = null;
            List<String> statsInfo = new ArrayList<String>();
            //查询该租户五个阶段的统计信息，4天为一个阶段
            timeList = new ArrayList<String>();
            for (int j = 0; j <= 16; j += 4) {
                endTime = DateUtils.format(DateUtils.getDateBefore(new Date(), j));
                beginTime = DateUtils.format(DateUtils.getDateBefore(new Date(), j + 4));
                tempList = queryBillsByTenantId(beginTime, endTime, dataBasesList.get(i));//根据租户ID查该租户下的单据信息
                if (tempList != null && tempList.size() > 0) {
                    nodeBills = tempList.get(0);
                    nodeBillsList.add(nodeBills);
                    timeList.add(endTime);
                }
            }
            //根据租户ID查询该租户的具体信息
            JSONObject tenantInfoJson = JSONObject.fromObject(TenantCenter.getTenantById(dataBasesList.get(i)));
            if (tenantInfoJson.size() == 0) {
                logger.error("用户中心无此租户");
                continue;
            }
            //设置该租户的显示项，加入到statsInfo中
            if (tenantInfoJson.containsKey("status") && "1".equals(tenantInfoJson.optString("status"))) {
                if (tenantInfoJson.optJSONObject("tenant") == null) {
                    logger.error("用户中心无此租户");
                    continue;
                }
                JSONObject tenantInfo = tenantInfoJson.optJSONObject("tenant");
                statsInfo.add(tenantInfo.optString("tenantFullname"));
                statsInfo.add(tenantInfo.optString("tenantName"));
                statsInfo.add("Y");
                statsInfo.add(tenantInfo.optString("tenantId"));
            }
            int rowValue = 0;
            int increment = 0;
            if (nodeBillsList != null && nodeBillsList.size() > 0) {
                for (int m = nodeBillsList.size() - 1; m >= 0; m--) {
                    rowValue += nodeBillsList.get(m).getTotalCount();
                    statsInfo.add(String.valueOf(rowValue));
                    increment = nodeBillsList.get(m).getTotalCount();
                }
            }
            statsInfo.add(String.valueOf(increment));
            resultList.add(statsInfo);
        }
        return resultList;
    }

    private List<String> timeList = new ArrayList<String>();

    public void exportBillsToExcel() throws Exception {
        try {
            List<List<String>> list = getExportedBills(1, DataBaseUtils.queryDataBasesCountFromExcel());
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet();
            ExportExcel exportExcel = new ExportExcel(wb, sheet);
            List<String> columHeader = new ArrayList<String>();
            columHeader.add("企业名称");
            columHeader.add("销售机构");
            columHeader.add("是否开通租户");
            columHeader.add("租户");
            for (int i = timeList.size() - 1; i >= 0; i--) {
                columHeader.add(timeList.get(i) + "单据合计");
            }
            columHeader.add("单据增量");
            exportExcel.createNormalHead("集团友报账单据情况统计", columHeader.size());
            exportExcel.createColumHeader(columHeader);

            //创建单元格
            for (int i = 0, rowCount = 5; i < list.size() && rowCount <= list.size() + 5; i++, rowCount++) {
                List<String> tenantStats = list.get(i);
                XSSFRow row = sheet.createRow((short) (rowCount));
                for (int j = 0; j < tenantStats.size(); j++) {
                    exportExcel.cteateCell(wb, row, (short) j, HSSFCellStyle.ALIGN_LEFT, tenantStats.get(j));
                }

            }
            Properties props = null;
            props = Resources.getResourceAsProperties("sdk.properties");
            String filePath = props.getProperty("export.excel.path");
            exportExcel.outputExcel(filePath);
            wb.close();
        } catch (IOException e) {
            logger.error("文件导出异常", e.getMessage());
            throw new CustomRuntimeException("文件导出异常");
        }
    }

    @Override
    public int getDataBillsCount() throws Exception{
        return DataBaseUtils.queryDataBasesCountFromExcel();
    }
}
