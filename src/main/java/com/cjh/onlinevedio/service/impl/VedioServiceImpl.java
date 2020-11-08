package com.cjh.onlinevedio.service.impl;

import com.cjh.onlinevedio.dao.VedioDao;
import com.cjh.onlinevedio.domain.Vedio;
import com.cjh.onlinevedio.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VedioServiceImpl implements VedioService {
    @Autowired
    private VedioDao vedioDao;
    @Override
    public List<Vedio> getCourseVedio(int cId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cId", cId);
        map.put("vFlag", 1);

        return vedioDao.findVedioByCondition(map);
    }
}
