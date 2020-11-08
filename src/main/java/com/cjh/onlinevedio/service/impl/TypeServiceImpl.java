package com.cjh.onlinevedio.service.impl;

import com.cjh.onlinevedio.dao.TypeDao;
import com.cjh.onlinevedio.domain.Type;
import com.cjh.onlinevedio.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;
    @Override
    public int insertType(Type type) {
        return typeDao.insertType(type);
    }

    @Override
    public List<Type> getTypeAll() {

        return typeDao.findTypeAll();
    }
}
