package com.ybz.service;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器Service
 *
 * @author zhangybt
 * @create 2017年09月16日 15:30
 **/
public interface IDataGeneratorService {
    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

    /**
     * 生成代码
     */
    byte[] generatorCode(String[] tableNames);
}
