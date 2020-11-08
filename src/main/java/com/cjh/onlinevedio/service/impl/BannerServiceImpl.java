package com.cjh.onlinevedio.service.impl;

import com.cjh.onlinevedio.dao.BannerDao;
import com.cjh.onlinevedio.domain.Banner;
import com.cjh.onlinevedio.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerDao bannerDao;
    @Override
    public List<Banner> getIndexBanner() {
        return bannerDao.findBannerAll();
    }
}
