package com.cjh.onlinevedio.service.impl;

import com.cjh.onlinevedio.dao.CourseDao;
import com.cjh.onlinevedio.domain.Course;
import com.cjh.onlinevedio.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    @Override
    public int insertCourse(Course course) {
        return courseDao.insertCourse(course);
    }

    @Override
    public PageInfo<Course> getCourseList(int tId) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("tId", tId);
        map.put("cFlag", 1);

        List<Course> courseList = courseDao.findCourseByCondition(map);
        PageInfo<Course> pageInfo = new PageInfo<>(courseList, 4);
        return pageInfo;
    }

    @Override
    public PageInfo<Course> getNewsTopic() {
        //设置
        HashMap<String, Object> map = new HashMap<>();
        //1：表示降序，默认是升序
        map.put("order", 1);

        List<Course> list = courseDao.findNewCourseByTidAndLimit(map);

        PageInfo<Course> pageInfo = new PageInfo<>(list, 4);
        pageInfo.getNavigatePages();

        return pageInfo;
    }

    @Override
    public Course getCourse(int cId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cId", cId);

        return courseDao.findNewCourseByTidAndLimit(map).get(0);
    }
}
