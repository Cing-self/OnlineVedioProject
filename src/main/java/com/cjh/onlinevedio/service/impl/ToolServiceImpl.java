package com.cjh.onlinevedio.service.impl;

import com.cjh.onlinevedio.dao.ToolDao;
import com.cjh.onlinevedio.domain.Tool;
import com.cjh.onlinevedio.service.ToolService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    private ToolDao toolDao;

    @Override
    public PageInfo<Tool> getToolList(int ttId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ttId", ttId);
        List<Tool> toolList = toolDao.findToolByCondition(map);
        return new PageInfo<>(toolList, 4);
    }

    @Override
    public PageInfo<Tool> getNewToolList() {
        List<Tool> toolList = toolDao.findToolAll();
        return new PageInfo<>(toolList, 4);
    }
}
