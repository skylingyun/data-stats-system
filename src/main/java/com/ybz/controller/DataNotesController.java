package com.ybz.controller;

import com.ybz.entity.NodeNotes;
import com.ybz.service.IDataNotesService;
import com.ybz.utils.DataBaseUtils;
import com.ybz.utils.DataResult;
import com.ybz.utils.PageUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 所有记事接口
 *
 * @author zhangybt
 * @create 2017年08月09日 19:27
 **/
@RestController
@RequestMapping("/notes")
public class DataNotesController {

    @Resource(name = "dataNotesServiceImpl")
    private IDataNotesService notesService;

    @RequestMapping(value = "/getNotesList", method = RequestMethod.POST)
    public DataResult getNotesCount(@RequestBody Map<String, String> map) throws Exception{
        List<List<NodeNotes>> list = notesService.getDataNotesPage(map.get("beginTime"), map.get("endTime"), Integer.parseInt(map.get("activePage")), Integer.parseInt(map.get("totalPage")));
        int count = DataBaseUtils.queryDataBasesCountFromExcel();
        if(list != null && list.size() > 0){
            PageUtils pageUtils = new PageUtils(list, count, Integer.parseInt(map.get("totalPage")), Integer.parseInt(map.get("activePage")));
            return DataResult.ok().put("data", pageUtils);
        }
        return DataResult.error(-1, "记事查询失败");
    }

    @RequestMapping(value = "/queryFiveDaysNotes", method = RequestMethod.POST)
    public DataResult queryFiveDaysNotes(@RequestBody Map<String, String> map) {
        List<List<NodeNotes>> list = notesService.queryFiveDaysNotes(map.get("tenantId"));
        return DataResult.ok().put("data", list);
    }

}
