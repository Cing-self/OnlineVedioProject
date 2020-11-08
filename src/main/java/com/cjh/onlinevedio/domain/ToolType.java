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
 * tool_type
 * 
 * @author bianj
 * @version 1.0.0 2020-10-31
 */
public class ToolType implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -618514805340446595L;

    /** ttId */
    private Integer ttId;

    /** ttName */
    private String ttName;

    /** ttFlag */
    private Integer ttFlag;

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

    /**
     * 获取ttName
     * 
     * @return ttName
     */
    public String getTtName() {
        return this.ttName;
    }

    /**
     * 设置ttName
     * 
     * @param ttName
     */
    public void setTtName(String ttName) {
        this.ttName = ttName;
    }

    /**
     * 获取ttFlag
     * 
     * @return ttFlag
     */
    public Integer getTtFlag() {
        return this.ttFlag;
    }

    /**
     * 设置ttFlag
     * 
     * @param ttFlag
     */
    public void setTtFlag(Integer ttFlag) {
        this.ttFlag = ttFlag;
    }
}