package com.cjh.onlinevedio.service;

import com.cjh.onlinevedio.domain.Type;

import java.util.List;

public interface TypeService {

    int insertType(Type type);

    List<Type> getTypeAll();
}
