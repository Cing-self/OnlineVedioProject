package com.cjh.onlinevedio.dao;

import com.cjh.onlinevedio.domain.Vedio;

import java.util.List;
import java.util.Map;

public interface VedioDao {

    public int insertVedio(Vedio vedio);

    public List<Vedio> findVedioByCondition(Map<String, Object> map);
}
