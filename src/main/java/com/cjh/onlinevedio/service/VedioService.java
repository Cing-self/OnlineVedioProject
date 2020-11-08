package com.cjh.onlinevedio.service;

import com.cjh.onlinevedio.domain.Vedio;

import java.util.List;

public interface VedioService {

    List<Vedio> getCourseVedio(int cId);
}
