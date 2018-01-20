package com.ybz.service;

import com.ybz.entity.NodeNotes;

import java.util.List;

/**
 * 所有记事接口
 *
 * @author zhangybt
 * @create 2017年08月09日 19:30
 **/
public interface IDataNotesService {

    List<List<NodeNotes>> getDataNotesPage(String beginTime, String endTime, int offset, int limit) throws Exception;

    List<List<NodeNotes>> queryFiveDaysNotes(String tenantId);

}
