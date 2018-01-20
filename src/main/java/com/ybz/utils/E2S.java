package com.ybz.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常字符串转换工具类
 * @author congdayong
 * 上午11:17:07
 */
public class E2S {
	/**
	 * 异常转换为字符串方法
	 * @param ex
	 * @return
	 */
	public static String exception2String(Exception ex){
		String exceptionMessage = "";
		if (ex != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			try {
				ex.printStackTrace(pw);
				exceptionMessage = sw.toString();
			} finally {
				try {
					sw.close();
					pw.close();	
				} catch (Exception e) {
				}
			}
		}
		return exceptionMessage;
	}
}
