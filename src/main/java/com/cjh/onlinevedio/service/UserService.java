package com.cjh.onlinevedio.service;

import com.cjh.onlinevedio.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface UserService {

    User login(User user);

    int regist(User user);

    User existEmail(String email);

    User selectUser(Map<String, Object> map);

    PageInfo<User> getUserList();

    int delete(int uId);

    int update(User user);

}
