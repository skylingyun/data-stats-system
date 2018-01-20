package com.ybz.thread;

import com.ybz.exception.CustomRejectedExecutionHandler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CustomThreadPoolExecutor
 * @author jiangleid@yonyou.com
 *
 */
public class ThreadPoolExecutorFactory {
        
    
	 /**  
     * 线程池初始化方法  
     * corePoolSize 核心线程池大小----4  
     * maximumPoolSize 最大线程池大小----9  
     * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit  
     * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES  
     * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(10)====10容量的阻塞队列  
     * threadFactory 新建线程工厂
     * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,  
     * 即当提交第20个任务时(假设前面线程都没有执行完,),任务会交给RejectedExecutionHandler来处理  
     */    
	
	/**
	 * 只有一个线程，所以串行。保证池里面的线程执行完成顺序
	 */
    private static ThreadPoolExecutor serialPoolExecutor = new ThreadPoolExecutor(1,1,30,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(200),new CustomRejectedExecutionHandler());  
    
    /**
     * 多个线程并行，不保证池里面的线程执行完成顺序
     */
    private static ThreadPoolExecutor parallelPoolExecutor =  new ThreadPoolExecutor(4,9,30,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(200),new CustomRejectedExecutionHandler());
    
 
        
    public void destory() {    
        if(serialPoolExecutor != null) {    
        	serialPoolExecutor.shutdownNow();    
        }    
        if(parallelPoolExecutor != null) {    
        	parallelPoolExecutor.shutdownNow();    
        }    
    }    
    
    /**
     * 获取串行线程池执行器
     * @return
     */
	public static final ThreadPoolExecutor getSerialPoolExecutor() {
		return serialPoolExecutor;
	}


	/**
	 * 获取并行线程池执行器
	 * @return
	 */
	public static final ThreadPoolExecutor getParallelPoolExecutor() {
		return parallelPoolExecutor;
	}

    
}  