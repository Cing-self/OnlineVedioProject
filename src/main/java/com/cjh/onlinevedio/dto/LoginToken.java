package com.cjh.onlinevedio.dto;

import cn.hutool.crypto.digest.DigestUtil;
import com.cjh.onlinevedio.domain.User;

import java.util.Date;

public class LoginToken {

    private String ip;
    private String now;
    private String userAgent;
    private User user;

    private String loginToken;

    /**
     * 生成自动登录的凭证
     * @return
     */
    public String generateToken(){
        //时间 + 用户(email) + IP + 浏览器信息 = (MD5)
        StringBuilder builder = new StringBuilder();
        builder.append(ip);
        builder.append(now);
        builder.append(userAgent);
        builder.append(user.getUEmail());
        //增加MD5的复杂度
        builder.append("abc123!@#");
        return DigestUtil.md5Hex(builder.toString());
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    @Override
    public String toString() {
        return "LoginToken{" +
                "ip='" + ip + '\'' +
                ", now='" + now + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", user=" + user +
                '}';
    }
}
