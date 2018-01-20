package com.ybz.service.impl;

import com.ybz.dao.DataGeneratorMapper;
import com.ybz.service.IDataGeneratorService;
import com.ybz.utils.generator.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器实现类
 *
 * @author zhangybt
 * @create 2017年09月16日 15:31
 **/
@Service
public class DataGeneratorServiceImpl implements IDataGeneratorService {

    @Autowired
    private DataGeneratorMapper dataGeneratorDao;

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return dataGeneratorDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return dataGeneratorDao.queryTotal(map);
    }

    @Override
    public Map<String, String> queryTable(String tableName) {
        return dataGeneratorDao.queryTable(tableName);
    }

    @Override
    public List<Map<String, String>> queryColumns(String tableName) {
        return dataGeneratorDao.queryColumns(tableName);
    }

    @Override
    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for(String tableName : tableNames){
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
