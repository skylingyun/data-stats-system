package com.ybz.utils;

import com.ybz.exception.CustomRuntimeException;
import org.apache.ibatis.io.Resources;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.velocity.tools.config.Data;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * 获取所有的数据库名称
 *
 * @author zhangybt
 * @create 2017年08月09日 15:09
 **/
public class DataBaseUtils {
    private static LoggerHelper logger = new LoggerHelper(DataBaseUtils.class);

    /**
     * 获取数据库名称(List<Map<String,String>)
     * @return
     * @throws Exception
     */
    public static List<Map<String,String>> getDataBasesList() throws Exception {
        int key = 0;
        List<Map<String,String>> mapList = new ArrayList<Map<String, String>>();
        try {
            List<String> list = DataBaseUtils.queryDataBasesListFromExcel(1, queryDataBasesCountFromExcel());
            for (int i = 0; i < list.size(); i++) {
                Map<String,String> map = new HashMap<String, String>();
                map.put(String.valueOf(key++),list.get(i));
                mapList.add(map);
            }
        } catch (Exception e) {
            logger.error("获取租户ID列表失败", e.getMessage());
            throw new CustomRuntimeException("获取租户ID列表失败");
        }
        return mapList;
    }
    /**
     * 获取数据库名称(List<String>)
     * @return
     * @throws Exception
     */
    public static List<String> queryDataBasesList() throws Exception {
        Connection conn = null;
        Statement stmt = null;
        Properties props = Resources.getResourceAsProperties("db.properties");
        String url = props.getProperty("jdbc.url");
        String driver = props.getProperty("jdbc.driver");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
        stmt.execute("show databases");
        ResultSet rs = stmt.getResultSet();
        List<String> list = new ArrayList<String>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    /**
     * 从Excel表中获取有效的数据库名称
     * @return
     */
    public static List<String> queryDataBasesListFromExcel(int offset, int limit) throws Exception{
        try {
            Properties props = null;
            props = Resources.getResourceAsProperties("sdk.properties");
            String filePath = props.getProperty("databases.excel.path");
            XSSFWorkbook xssfWorkbook = getExcelWorkbook(filePath);
            List<String> rowList = getRowList(xssfWorkbook, offset, limit);
            return rowList;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("无法读取properties文件", e.getMessage());
            throw new CustomRuntimeException("无法读取properties文件");
        }
    }

    public static int queryDataBasesCountFromExcel() throws Exception{
        try {
            Properties props = Resources.getResourceAsProperties("sdk.properties");
            String filePath = props.getProperty("databases.excel.path");
            XSSFWorkbook xssfWorkbook = getExcelWorkbook(filePath);
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            int rowSize = sheet.getLastRowNum() + 1;
            return rowSize;
        } catch (IOException e) {
            logger.error("无法读取properties文件", e.getMessage());
            throw new CustomRuntimeException("无法读取properties文件");
        }
    }

    /**
     * 获取Excel工作簿
     * @param filePath
     * @return
     */
    public static XSSFWorkbook getExcelWorkbook(String filePath) throws Exception{
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new RuntimeException("文件不存在");
            }
            InputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            in.close();
            workbook.close();
            return workbook;
        } catch (FileNotFoundException e) {
            logger.error("找不到文件", e.getMessage());
            throw new CustomRuntimeException("找不到文件");
        } catch (IOException e) {
            logger.error("工作簿读取失败", e.getMessage());
            throw new CustomRuntimeException("工作簿读取失败");
        }
    }

    //获取每行的第一列数据
    public static List<String> getRowList(XSSFWorkbook xssfWorkbook, int offset, int limit){
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        int rowSize = sheet.getLastRowNum() + 1;
        List<String> rowList = new ArrayList<String>();
        int start = (offset - 1) * 20;
        int end = start + limit - 1;
        for (int i = start; i <= (end <= rowSize ? end : rowSize); i++){
            Row row = sheet.getRow(i);
            if (row == null) {//略过空行
                continue;
            }
            Cell cell = row.getCell(0);
            String value = null;
            if (cell != null){
                value = cell.toString();
                rowList.add(value);
            }
        }
        return rowList;
    }
}
