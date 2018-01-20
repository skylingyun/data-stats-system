package com.ybz.utils;

import org.apache.log4j.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * 日志打印帮助工具类，增加抛出日志的行号，多参数打印功能
 * @author congdayong
 * 上午11:16:07
 */
public class LoggerHelper {
	
	private Logger logger;
	
	public LoggerHelper(Class<?> classzz) {
		this.logger = Logger.getLogger(classzz);
	}
	
	public void debug(Object... logstr){
		StringBuffer logBuffer = new StringBuffer();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		logBuffer.append("(").append(lineNumber).append(") ");
		for(Object obj : logstr){
			if(obj instanceof Exception) {
				Exception e = (Exception)obj;
				logBuffer.append(E2S.exception2String(e));
			}
			else if(obj instanceof String){
				logBuffer.append(obj);
			}
			else{
				logBuffer.append(obj);
			}
//			logBuffer.append(",");
		}
//		logBuffer.deleteCharAt(logBuffer.lastIndexOf(","));
		logger.debug(logBuffer.toString());
	}
	
	public void info(Object... logstr){
		StringBuffer logBuffer = new StringBuffer();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		logBuffer.append("(").append(lineNumber).append(") ");
		for(Object obj : logstr){
			if(obj instanceof Exception) {
				Exception e = (Exception)obj;
				logBuffer.append(E2S.exception2String(e));
			}
			else if(obj instanceof String){
				logBuffer.append(obj);
			}
			else{
				logBuffer.append(obj);
			}
//			logBuffer.append(",");
		}
//		logBuffer.deleteCharAt(logBuffer.lastIndexOf(","));
		logger.info(logBuffer.toString());
	}
	
	public void error(Object... logstr){
		StringBuffer logBuffer = new StringBuffer();
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		logBuffer.append("(").append(lineNumber).append(") ");
		for(Object obj : logstr){
			if(obj instanceof Exception) {
				Exception e = (Exception)obj;
				logBuffer.append(E2S.exception2String(e));
			}
			else if(obj instanceof String){
				logBuffer.append(obj);
			}
			else{
				logBuffer.append(obj);
			}
//			logBuffer.append(",");
		}
//		logBuffer.deleteCharAt(logBuffer.lastIndexOf(","));
		logger.error(logBuffer.toString());
	}
}
