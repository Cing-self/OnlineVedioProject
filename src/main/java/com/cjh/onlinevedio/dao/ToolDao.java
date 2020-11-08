package com.cjh.onlinevedio.dao;

import com.cjh.onlinevedio.domain.Tool;

import java.util.List;
import java.util.Map;

public interface ToolDao {

    List<Tool> findToolByCondition(Map<String, Object> map);

    List<Tool> findToolAll();

    public int insertTool(Tool tool);
}
