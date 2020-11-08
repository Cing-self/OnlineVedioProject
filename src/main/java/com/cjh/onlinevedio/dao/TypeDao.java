package com.cjh.onlinevedio.dao;

import com.cjh.onlinevedio.domain.Type;

import java.util.List;
import java.util.Map;

public interface TypeDao {

    //插入一条数据
    int insertType(Type type);

    //查询所有课程类型
    List<Type> findTypeAll();
}
