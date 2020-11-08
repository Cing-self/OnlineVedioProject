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
 * type
 * 
 * @author bianj
 * @version 1.0.0 2020-10-31
 */
public class Type implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -2707285419840813455L;

    /** tId */
    private Integer tId;

    /** tName */
    private String tName;

    /** tFlag */
    private Integer tFlag;

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
     * 获取tFlag
     * 
     * @return tFlag
     */
    public Integer getTFlag() {
        return this.tFlag;
    }

    /**
     * 设置tFlag
     * 
     * @param tFlag
     */
    public void setTFlag(Integer tFlag) {
        this.tFlag = tFlag;
    }
}