package com.cjh.onlinevedio.controller;

import com.cjh.onlinevedio.domain.Course;
import com.cjh.onlinevedio.domain.Vedio;
import com.cjh.onlinevedio.service.CourseService;
import com.cjh.onlinevedio.service.VedioService;
import com.cjh.onlinevedio.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private VedioService vedioService;

    //课程页面
    @RequestMapping(value = "/course/{cId}")
    public String coursePage(@PathVariable Integer cId, Model model){
        model.addAttribute("focusIndex", Constants.INDEX_COURSE_PAGE);

        Course course = courseService.getCourse(cId);
        model.addAttribute("course", course);

        List<Vedio> vedioList = vedioService.getCourseVedio(cId);
        model.addAttribute("vedioList", vedioList);

        return "course_vedio";
    }

}
