package com.cjh.onlinevedio.service;

import com.cjh.onlinevedio.domain.Course;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseService {

    public int insertCourse(Course course);

    PageInfo<Course> getCourseList(int tId);

    PageInfo<Course> getNewsTopic();

    Course getCourse(int cId);
}
