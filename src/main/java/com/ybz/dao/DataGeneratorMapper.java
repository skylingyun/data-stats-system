package com.ybz.dao;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器DAO
 *
 * @author zhangybt
 * @create 2017年09月16日 15:29
 **/
public interface DataGeneratorMapper {
    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
