package com.ybz.thread;

import com.ybz.exception.CustomRuntimeException;
import com.ybz.service.IDataTenantService;
import com.ybz.utils.LoggerHelper;

/**
 * 租户信息线程
 *
 * @author zhangybt
 * @create 2017年10月31日 16:20
 **/
public class DataTenantThread implements Runnable {

    private static LoggerHelper logger = new LoggerHelper(DataTenantThread.class);

    private Integer offset;

    private Integer limit;

    private IDataTenantService dataTenantService;

    public DataTenantThread(Integer offset, Integer limit, IDataTenantService dataTenantService) {
        this.offset = offset;
        this.limit = limit;
        this.dataTenantService = dataTenantService;
    }

    @Override
    public void run() {
        try {
            dataTenantService.getTenants(offset,limit);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new CustomRuntimeException(e.getMessage());
        }
    }
}
