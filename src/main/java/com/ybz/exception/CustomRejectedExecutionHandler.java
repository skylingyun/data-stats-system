package com.ybz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 提交任务被拒绝时，进入拒绝机制，我们实现拒绝方法，把任务重新用阻塞提交方法put提交，实现阻塞提交任务功能，
 * 解决不设置队列长度会OOM，设置队列长度，会有任务得不到处理
 * @author jiangleid@yonyou.com
 *
 */
public class CustomRejectedExecutionHandler implements RejectedExecutionHandler{
	
	protected Logger logger = LoggerFactory.getLogger(CustomRejectedExecutionHandler.class);

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		  try {  
              // 核心改造点，由blockingqueue的offer改成put阻塞方法  
              executor.getQueue().put(r);  
          } catch (InterruptedException e) {  
              e.printStackTrace();  
              logger.error(e.toString());
          }  
	}

}
