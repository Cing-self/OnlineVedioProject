package com.cjh.onlinevedio.service;

import com.cjh.onlinevedio.domain.Tool;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ToolService {

    PageInfo<Tool> getToolList(int ttId);
    PageInfo<Tool> getNewToolList();
}
