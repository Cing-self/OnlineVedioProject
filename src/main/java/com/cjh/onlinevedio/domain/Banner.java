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
/**
 * banner
 * 
 * @author bianj
 * @version 1.0.0 2020-10-31
 */
public class Banner implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 7955724075483050421L;

    /** bId */
    private Integer bId;

    /** bImgUrl */
    private String bImgUrl;

    /** bFlag */
    private Integer bFlag;

    /** bType */
    private String bType;

    /** bTargetUrl */
    private String bTargetUrl;

    /**
     * 获取bId
     * 
     * @return bId
     */
    public Integer getBId() {
        return this.bId;
    }

    /**
     * 设置bId
     * 
     * @param bId
     */
    public void setBId(Integer bId) {
        this.bId = bId;
    }

    /**
     * 获取bImgUrl
     * 
     * @return bImgUrl
     */
    public String getBImgUrl() {
        return this.bImgUrl;
    }

    /**
     * 设置bImgUrl
     * 
     * @param bImgUrl
     */
    public void setBImgUrl(String bImgUrl) {
        this.bImgUrl = bImgUrl;
    }

    /**
     * 获取bFlag
     * 
     * @return bFlag
     */
    public Integer getBFlag() {
        return this.bFlag;
    }

    /**
     * 设置bFlag
     * 
     * @param bFlag
     */
    public void setBFlag(Integer bFlag) {
        this.bFlag = bFlag;
    }

    /**
     * 获取bType
     * 
     * @return bType
     */
    public String getBType() {
        return this.bType;
    }

    /**
     * 设置bType
     * 
     * @param bType
     */
    public void setBType(String bType) {
        this.bType = bType;
    }

    /**
     * 获取bTargetUrl
     * 
     * @return bTargetUrl
     */
    public String getBTargetUrl() {
        return this.bTargetUrl;
    }

    /**
     * 设置bTargetUrl
     * 
     * @param bTargetUrl
     */
    public void setBTargetUrl(String bTargetUrl) {
        this.bTargetUrl = bTargetUrl;
    }
}