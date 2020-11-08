package com.cjh.onlinevedio.dao;

import com.cjh.onlinevedio.domain.ToolType;

import java.util.List;

public interface ToolTypeDao {

    public List<ToolType> findToolTypeAll();

    public int insertToolType(ToolType toolType);
}
