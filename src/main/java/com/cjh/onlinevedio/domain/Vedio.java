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
 * vedio
 * 
 * @author bianj
 * @version 1.0.0 2020-10-31
 */
public class Vedio implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -6080786580434891116L;

    /** vId */
    private Integer vId;

    /** vName */
    private String vName;

    /** vFreeView */
    private Integer vFreeView;

    /** cId */
    private Integer cId;

    /** vFlag */
    private Integer vFlag;

    /** vUrl1 */
    private String vUrl1;

    /** vUrl2 */
    private String vUrl2;

    /** vCreatetime */
    private Date vCreatetime;

    /**
     * 获取vId
     * 
     * @return vId
     */
    public Integer getVId() {
        return this.vId;
    }

    /**
     * 设置vId
     * 
     * @param vId
     */
    public void setVId(Integer vId) {
        this.vId = vId;
    }

    /**
     * 获取vName
     * 
     * @return vName
     */
    public String getVName() {
        return this.vName;
    }

    /**
     * 设置vName
     * 
     * @param vName
     */
    public void setVName(String vName) {
        this.vName = vName;
    }

    /**
     * 获取vFreeView
     * 
     * @return vFreeView
     */
    public Integer getVFreeView() {
        return this.vFreeView;
    }

    /**
     * 设置vFreeView
     * 
     * @param vFreeView
     */
    public void setVFreeView(Integer vFreeView) {
        this.vFreeView = vFreeView;
    }

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
     * 获取vFlag
     * 
     * @return vFlag
     */
    public Integer getVFlag() {
        return this.vFlag;
    }

    /**
     * 设置vFlag
     * 
     * @param vFlag
     */
    public void setVFlag(Integer vFlag) {
        this.vFlag = vFlag;
    }

    /**
     * 获取vUrl1
     * 
     * @return vUrl1
     */
    public String getVUrl1() {
        return this.vUrl1;
    }

    /**
     * 设置vUrl1
     * 
     * @param vUrl1
     */
    public void setVUrl1(String vUrl1) {
        this.vUrl1 = vUrl1;
    }

    /**
     * 获取vUrl2
     * 
     * @return vUrl2
     */
    public String getVUrl2() {
        return this.vUrl2;
    }

    /**
     * 设置vUrl2
     * 
     * @param vUrl2
     */
    public void setVUrl2(String vUrl2) {
        this.vUrl2 = vUrl2;
    }

    /**
     * 获取vCreatetime
     * 
     * @return vCreatetime
     */
    public Date getVCreatetime() {
        return this.vCreatetime;
    }

    /**
     * 设置vCreatetime
     * 
     * @param vCreatetime
     */
    public void setVCreatetime(Date vCreatetime) {
        this.vCreatetime = vCreatetime;
    }
}