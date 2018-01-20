package com.ybz.utils;

import com.ybz.exception.CustomRuntimeException;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Guoru on 201/9/15.
 */
public class ExportExcel {
    private static LoggerHelper logger = new LoggerHelper(ExportExcel.class);
    private XSSFWorkbook wb = null;

    private XSSFSheet sheet = null;

    /**
     * @param wb
     * @param sheet
     */
    public ExportExcel(XSSFWorkbook wb, XSSFSheet sheet) {
        super();
        this.wb = wb;
        this.sheet = sheet;
    }

    /**
     * @return the sheet
     */
    public XSSFSheet getSheet() {
        return sheet;
    }

    /**
     * @param sheet the sheet to set
     */
    public void setSheet(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    /**
     * @return the wb
     */
    public XSSFWorkbook getWb() {
        return wb;
    }

    /**
     * @param wb the wb to set
     */
    public void setWb(XSSFWorkbook wb) {
        this.wb = wb;
    }

    /**
     * 创建通用EXCEL头部
     *
     * @param headString 头部显示的字符
     * @param colSum     该报表的列数
     */
    public void createNormalHead(String headString, int colSum) {

        XSSFRow row = sheet.createRow(0);

        // 设置第一行
        XSSFCell cell = row.createCell(0);
        row.setHeight((short) 400);

        // 定义单元格为字符串类型
        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
        cell.setCellValue(new XSSFRichTextString(headString));

        // 指定合并区域
        sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) colSum));

        XSSFCellStyle cellStyle = wb.createCellStyle();

        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
        cellStyle.setWrapText(true);// 指定单元格自动换行

        // 设置单元格字体
        XSSFFont font = wb.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 300);
        cellStyle.setFont(font);

        cell.setCellStyle(cellStyle);
    }

    /**
     * 创建通用报表第二行
     *
     * @param params 统计条件数组
     * @param colSum 需要合并到的列索引
     */
    public void createNormalTwoRow(String[] params, int colSum) {
        XSSFRow row1 = sheet.createRow(1);
        row1.setHeight((short) 300);

        XSSFCell cell2 = row1.createCell(0);

        cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
        cell2.setCellValue(new XSSFRichTextString("统计时间：" + params[0] + "至"
                + params[1]));

        // 指定合并区域
        sheet.addMergedRegion(new CellRangeAddress(1, (short) 0, 1, (short) colSum));

        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
        cellStyle.setWrapText(true);// 指定单元格自动换行

        // 设置单元格字体
        XSSFFont font = wb.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 250);
        cellStyle.setFont(font);

        cell2.setCellStyle(cellStyle);

    }

    /**
     * 设置报表标题
     *
     * @param columHeader 标题字符串数组
     */
    public void createColumHeader(List<String> columHeader) {

        // 设置列头
        XSSFRow row2 = sheet.createRow(2);

        // 指定行高
        row2.setHeight((short) 600);

        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
        cellStyle.setWrapText(true);// 指定单元格自动换行

        // 单元格字体
        XSSFFont font = wb.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 250);
        cellStyle.setFont(font);

        /*
         * cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单无格的边框为粗体
         * cellStyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
         * cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
         * cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
         * cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
         * cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
         * cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
         * cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
         */

        // 设置单元格背景色
        cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

        XSSFCell cell3 = null;

        for (int i = 0; i < columHeader.size(); i++) {
            cell3 = row2.createCell(i);
            cell3.setCellType(XSSFCell.CELL_TYPE_STRING);
            cell3.setCellStyle(cellStyle);
            cell3.setCellValue(new XSSFRichTextString(columHeader.get(i)));
            sheet.autoSizeColumn(i);
        }

    }

    /**
     * 创建内容单元格
     *
     * @param wb    HSSFWorkbook
     * @param row   HSSFRow
     * @param col   short型的列索引
     * @param align 对齐方式
     * @param val   列值
     */
    public void cteateCell(XSSFWorkbook wb, XSSFRow row, int col, short align,
                           String val) {
        XSSFCell cell = row.createCell(col);
        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
        cell.setCellValue(new XSSFRichTextString(val));
        XSSFCellStyle cellstyle = wb.createCellStyle();
        cellstyle.setAlignment(align);
        cell.setCellStyle(cellstyle);
        sheet.autoSizeColumn(col);
    }

    /**
     * 创建合计行
     *
     * @param colSum    需要合并到的列索引
     * @param cellValue
     */
    public void createLastSumRow(int colSum, String[] cellValue) {

        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
        cellStyle.setWrapText(true);// 指定单元格自动换行

        // 单元格字体
        XSSFFont font = wb.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 250);
        cellStyle.setFont(font);

        XSSFRow lastRow = sheet.createRow((short) (sheet.getLastRowNum() + 1));
        XSSFCell sumCell = lastRow.createCell(0);

        sumCell.setCellValue(new XSSFRichTextString("合计"));
        sumCell.setCellStyle(cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(sheet.getLastRowNum(), (short) 0,
                sheet.getLastRowNum(), (short) colSum));// 指定合并区域

        for (int i = 2; i < (cellValue.length + 2); i++) {
            sumCell = lastRow.createCell(i);
            sumCell.setCellStyle(cellStyle);
            sumCell.setCellValue(new XSSFRichTextString(cellValue[i - 2]));

        }

    }

    /**
     * 输入EXCEL文件
     *
     * @param fileName 文件名
     */
    public void outputExcel(String fileName) {
        FileOutputStream fos = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            wb.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            logger.error("找不到文件", e.getMessage());
            throw new CustomRuntimeException("找不到文件");
        } catch (IOException e) {
            logger.error("文件操作异常", e.getMessage());
            throw new CustomRuntimeException("文件操作异常");
        }
    }
}
