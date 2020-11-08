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
 * user
 * 
 * @author bianj
 * @version 1.0.0 2020-10-31
 */
public class User implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1929000076776484542L;

    /** uId */
    private Integer uId;

    /** uPhone */
    private String uPhone;

    /** uName */
    private String uName;

    /** uPassword */
    private String uPassword;

    /** uEmail */
    private String uEmail;

    /** uVip */
    private Integer uVip;

    /** uCreatetime */
    private Date uCreatetime;

    /** flag */
    private Integer uFlag;

    /**
     * 获取uId
     * 
     * @return uId
     */
    public Integer getUId() {
        return this.uId;
    }

    /**
     * 设置uId
     * 
     * @param uId
     */
    public void setUId(Integer uId) {
        this.uId = uId;
    }

    /**
     * 获取uPhone
     * 
     * @return uPhone
     */
    public String getUPhone() {
        return this.uPhone;
    }

    /**
     * 设置uPhone
     * 
     * @param uPhone
     */
    public void setUPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    /**
     * 获取uName
     * 
     * @return uName
     */
    public String getUName() {
        return this.uName;
    }

    /**
     * 设置uName
     * 
     * @param uName
     */
    public void setUName(String uName) {
        this.uName = uName;
    }

    /**
     * 获取uPassword
     * 
     * @return uPassword
     */
    public String getUPassword() {
        return this.uPassword;
    }

    /**
     * 设置uPassword
     * 
     * @param uPassword
     */
    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    /**
     * 获取uEmail
     * 
     * @return uEmail
     */
    public String getUEmail() {
        return this.uEmail;
    }

    /**
     * 设置uEmail
     * 
     * @param uEmail
     */
    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    /**
     * 获取uVip
     * 
     * @return uVip
     */
    public Integer getUVip() {
        return this.uVip;
    }

    /**
     * 设置uVip
     * 
     * @param uVip
     */
    public void setUVip(Integer uVip) {
        this.uVip = uVip;
    }

    /**
     * 获取uCreatetime
     * 
     * @return uCreatetime
     */
    public Date getUCreatetime() {
        return this.uCreatetime;
    }

    /**
     * 设置uCreatetime
     * 
     * @param uCreatetime
     */
    public void setUCreatetime(Date uCreatetime) {
        this.uCreatetime = uCreatetime;
    }

    /**
     * 获取uFlag
     *
     * @return uFlag
     */
    public Integer getuFlag() {
        return uFlag;
    }

    /**
     * 设置uFlag
     *
     * @param uFlag
     */
    public void setuFlag(Integer uFlag) {
        this.uFlag = uFlag;
    }
}