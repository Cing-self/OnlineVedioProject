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
 * tool
 * 
 * @author bianj
 * @version 1.0.0 2020-10-31
 */
public class Tool implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 6722293623345700506L;

    /** tId */
    private Integer tId;

    /** tName */
    private String tName;

    /** tUrl */
    private String tUrl;

    /** tImgUrl */
    private String tImgUrl;

    /** ttId */
    private Integer ttId;

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
     * 获取tName
     * 
     * @return tName
     */
    public String getTName() {
        return this.tName;
    }

    /**
     * 设置tName
     * 
     * @param tName
     */
    public void setTName(String tName) {
        this.tName = tName;
    }

    /**
     * 获取tUrl
     * 
     * @return tUrl
     */
    public String getTUrl() {
        return this.tUrl;
    }

    /**
     * 设置tUrl
     * 
     * @param tUrl
     */
    public void setTUrl(String tUrl) {
        this.tUrl = tUrl;
    }

    /**
     * 获取tImgUrl
     * 
     * @return tImgUrl
     */
    public String getTImgUrl() {
        return this.tImgUrl;
    }

    /**
     * 设置tImgUrl
     * 
     * @param tImgUrl
     */
    public void setTImgUrl(String tImgUrl) {
        this.tImgUrl = tImgUrl;
    }

    /**
     * 获取ttId
     * 
     * @return ttId
     */
    public Integer getTtId() {
        return this.ttId;
    }

    /**
     * 设置ttId
     * 
     * @param ttId
     */
    public void setTtId(Integer ttId) {
        this.ttId = ttId;
    }
}