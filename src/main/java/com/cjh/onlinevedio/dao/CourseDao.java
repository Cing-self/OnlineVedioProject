package com.cjh.onlinevedio.dao;

import com.cjh.onlinevedio.domain.Course;

import java.util.List;
import java.util.Map;

public interface CourseDao {

    public int insertCourse(Course course);

    List<Course> findCourseByCondition(Map<String, Object> map);

    List<Course> findNewCourseByTidAndLimit(Map<String, Object> map);


}
