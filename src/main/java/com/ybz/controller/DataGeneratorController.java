package com.ybz.controller;

import com.alibaba.fastjson.JSON;
import com.ybz.service.IDataGeneratorService;
import com.ybz.utils.DataResult;
import com.ybz.utils.PageUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author zhangybt
 * @create 2017年09月16日 15:29
 **/
@RestController
@RequestMapping("/generator")
public class DataGeneratorController {
    
    @Resource(name = "dataGeneratorServiceImpl")
    private IDataGeneratorService dataGeneratorService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    public DataResult list(@RequestBody Map<String,String> params){
        Map<String, Object> map = new HashMap<String,Object>();
//        map.put("tableName", tableName);
//        map.put("offset", (page - 1) * limit);
//        map.put("limit", limit);

        //查询列表数据
        List<Map<String, Object>> list = dataGeneratorService.queryList(map);
        int total = dataGeneratorService.queryTotal(map);

        int limit = 0;
        int page = 0;
        PageUtils pageUtil = new PageUtils(list, total, limit, page);

        return DataResult.ok().put("page", pageUtil);
    }

    /**
     * 生成代码
     */
    @RequestMapping("/code")
    public void code(String tables, HttpServletResponse response) throws IOException {
        String[] tableNames = new String[]{};
        tableNames = JSON.parseArray(tables).toArray(tableNames);

        byte[] data = dataGeneratorService.generatorCode(tableNames);

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"data.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
