package com.cjh.onlinevedio.dao;

import com.cjh.onlinevedio.domain.Banner;

import java.util.List;

public interface BannerDao {

    public abstract int insertBanner(Banner banner);

    List<Banner> findBannerAll();
}
