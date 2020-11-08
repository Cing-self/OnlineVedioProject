package com.cjh.onlinevedio.service.impl;

import com.cjh.onlinevedio.dao.UserDao;
import com.cjh.onlinevedio.domain.User;
import com.cjh.onlinevedio.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("uEmail", user.getUEmail());
        map.put("uPassword", user.getUPassword());
        return userDao.findUserByCondition(map);
    }

    @Override
    public int regist(User user) {
        user.setUId(1);
        user.setUCreatetime(new Date());
        user.setUVip(-1);
        return userDao.insertUser(user);
    }

    @Override
    public User existEmail(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("uEmail", email);
        return userDao.findUserByCondition(map);
    }

    @Override
    public User selectUser(Map<String, Object> map) {
        return userDao.findUserByCondition(map);
    }

    @Override
    public PageInfo<User> getUserList() {

        List<User> userList = userDao.findUserAll();
        return new PageInfo<>(userList, 4);
    }

    @Override
    public int delete(int uId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uId", uId);
        map.put("uFlag", -1);
        return userDao.updateUserByMap(map);
    }

    @Override
    public int update(User user) {
        return userDao.updateUser(user);
    }
}
