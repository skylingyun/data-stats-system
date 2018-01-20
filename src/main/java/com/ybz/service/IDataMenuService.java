package com.ybz.service;

import com.ybz.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * 菜单
 *
 * @author zhangybt
 * @create 2017年09月16日 16:46
 **/
public interface IDataMenuService {

    List<Menu> queryList(Map<String, Object> map);
}
