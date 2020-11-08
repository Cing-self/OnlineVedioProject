package com.cjh.onlinevedio.dao;

import com.cjh.onlinevedio.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public int insertUser(User user);

    User findUserById(Integer uId);

    User findUserByCondition(Map<String, Object> map);

    List<User> findUserAll();

    int updateUserByMap(Map<String, Object> map);

    int updateUser(User user);
}
