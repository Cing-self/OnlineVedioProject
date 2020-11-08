package com.cjh.onlinevedio.domain;/*
 * Welcome to use the TableGo Tools.
 * 
 * http://www.tablego.cn
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author: bianj
 * Email: tablego@qq.com
 * Version: 6.8.0
 */
import java.util.Date;

/**
 * course
 * 
 * @author bianj
 * @version 1.0.0 2020-10-31
 */
public class Course implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 8466444105228418106L;

    /** cId */
    private Integer cId;

    /** cTitle */
    private String cTitle;

    /** cImageUrl */
    private String cImageUrl;

    /** cIntro */
    private String cIntro;

    /** cIntroUrl */
    private String cIntroUrl;

    /** cViews */
    private Integer cViews;

    /** cFlag */
    private Integer cFlag;

    /** tId */
    private Integer tId;

    /** cVip */
    private Integer cVip;

    /** cWareUrl */
    private String cWareUrl;

    /** cCreatetime */
    private Date cCreatetime;

    /**
     * 获取cId
     * 
     * @return cId
     */
    public Integer getCId() {
        return this.cId;
    }

    /**
     * 设置cId
     * 
     * @param cId
     */
    public void setCId(Integer cId) {
        this.cId = cId;
    }

    /**
     * 获取cTitle
     * 
     * @return cTitle
     */
    public String getCTitle() {
        return this.cTitle;
    }

    /**
     * 设置cTitle
     * 
     * @param cTitle
     */
    public void setCTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    /**
     * 获取cImageUrl
     * 
     * @return cImageUrl
     */
    public String getCImageUrl() {
        return this.cImageUrl;
    }

    /**
     * 设置cImageUrl
     * 
     * @param cImageUrl
     */
    public void setCImageUrl(String cImageUrl) {
        this.cImageUrl = cImageUrl;
    }

    /**
     * 获取cIntro
     * 
     * @return cIntro
     */
    public String getCIntro() {
        return this.cIntro;
    }

    /**
     * 设置cIntro
     * 
     * @param cIntro
     */
    public void setCIntro(String cIntro) {
        this.cIntro = cIntro;
    }

    /**
     * 获取cIntroUrl
     * 
     * @return cIntroUrl
     */
    public String getCIntroUrl() {
        return this.cIntroUrl;
    }

    /**
     * 设置cIntroUrl
     * 
     * @param cIntroUrl
     */
    public void setCIntroUrl(String cIntroUrl) {
        this.cIntroUrl = cIntroUrl;
    }

    /**
     * 获取cViews
     * 
     * @return cViews
     */
    public Integer getCViews() {
        return this.cViews;
    }

    /**
     * 设置cViews
     * 
     * @param cViews
     */
    public void setCViews(Integer cViews) {
        this.cViews = cViews;
    }

    /**
     * 获取cFlag
     * 
     * @return cFlag
     */
    public Integer getCFlag() {
        return this.cFlag;
    }

    /**
     * 设置cFlag
     * 
     * @param cFlag
     */
    public void setCFlag(Integer cFlag) {
        this.cFlag = cFlag;
    }

    /**
     * 获取tId
     * 
     * @return tId
     */
    public Integer getTId() {
        return this.tId;
    }

    /**
     * 设置tId
     * 
     * @param tId
     */
    public void setTId(Integer tId) {
        this.tId = tId;
    }

    /**
     * 获取cVip
     * 
     * @return cVip
     */
    public Integer getCVip() {
        return this.cVip;
    }

    /**
     * 设置cVip
     * 
     * @param cVip
     */
    public void setCVip(Integer cVip) {
        this.cVip = cVip;
    }

    /**
     * 获取cWareUrl
     * 
     * @return cWareUrl
     */
    public String getCWareUrl() {
        return this.cWareUrl;
    }

    /**
     * 设置cWareUrl
     * 
     * @param cWareUrl
     */
    public void setCWareUrl(String cWareUrl) {
        this.cWareUrl = cWareUrl;
    }

    /**
     * 获取cCreatetime
     * 
     * @return cCreatetime
     */
    public Date getCCreatetime() {
        return this.cCreatetime;
    }

    /**
     * 设置cCreatetime
     * 
     * @param cCreatetime
     */
    public void setCCreatetime(Date cCreatetime) {
        this.cCreatetime = cCreatetime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", cTitle='" + cTitle + '\'' +
                ", cImageUrl='" + cImageUrl + '\'' +
                ", cIntro='" + cIntro + '\'' +
                ", cIntroUrl='" + cIntroUrl + '\'' +
                ", cViews=" + cViews +
                ", cFlag=" + cFlag +
                ", tId=" + tId +
                ", cVip=" + cVip +
                ", cWareUrl='" + cWareUrl + '\'' +
                ", cCreatetime=" + cCreatetime +
                '}';
    }
}