package com.ybz.service.impl;

import com.ybz.dao.MenuMapper;
import com.ybz.entity.Menu;
import com.ybz.service.IDataMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 菜单实现类
 *
 * @author zhangybt
 * @create 2017年09月16日 16:47
 **/
@Service
public class DataMenuServiceImpl implements IDataMenuService {

    @Autowired
    private MenuMapper menuMapperDao;
    @Override
    public List<Menu> queryList(Map<String, Object> map) {
        return menuMapperDao.queryList(map);
    }
}
