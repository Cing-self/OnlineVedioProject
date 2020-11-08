package com.cjh.onlinevedio.service.impl;

import com.cjh.onlinevedio.dao.ToolTypeDao;
import com.cjh.onlinevedio.domain.ToolType;
import com.cjh.onlinevedio.service.ToolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolTypeServiceImpl implements ToolTypeService {
    @Autowired
    private ToolTypeDao toolTypeDao;

    @Override
    public List<ToolType> getToolTypeAll() {
        return toolTypeDao.findToolTypeAll();
    }
}
