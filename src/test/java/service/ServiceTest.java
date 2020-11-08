package service;

import com.cjh.onlinevedio.domain.Course;
import com.cjh.onlinevedio.service.CourseService;
import com.cjh.onlinevedio.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class ServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;

    @Test
    public void testUserService(){
        System.out.println(userService.existEmail("353674054@qq.com"));
    }

    @Test
    public void testCourseService(){
        PageInfo<Course> pageInfo = courseService.getNewsTopic();
        System.out.println(pageInfo.getPageSize());
    }


}
