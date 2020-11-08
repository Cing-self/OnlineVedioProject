package com.cjh.onlinevedio.controller;

import com.cjh.onlinevedio.domain.*;
import com.cjh.onlinevedio.service.*;
import com.cjh.onlinevedio.util.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private CourseService courseService;
    @Autowired
    BannerService bannerService;
    @Autowired
    TypeService typeService;
    @Autowired
    ToolService toolService;
    @Autowired
    ToolTypeService toolTypeService;


    //==============================首页==============================
    /**
     * 获取首页地址
     * @param model
     * @return
     */
    @RequestMapping(value = "/")
    public String indexPage(Model model){
        //设置导航条当前焦点
        model.addAttribute("focusIndex", Constants.INDEX_FIRST_PAGE);
        //获取首页数据
        //获取最新的课程
        PageInfo<Course> newCourseList = courseService.getNewsTopic();

        //获取常用的框架课程
        PageInfo<Course> courseList = courseService.getCourseList(3);
        //获取首页的轮播图banner
        List<Banner> bannerList = bannerService.getIndexBanner();

        model.addAttribute("newCourseList", newCourseList);
        model.addAttribute("courseList", courseList);
        model.addAttribute("bannerList", bannerList);

        return "index";
    }

    //==========================工具==============================
    /**
     * 获取工具页地址
     * @return
     */
    @RequestMapping(value = "/tools")
    public String toolsPage(Model model){
        //设置导航条当前焦点
        model.addAttribute("focusIndex", Constants.INDEX_TOOL_PAGE);
        model.addAttribute("ttId", 0);

        //设置分页，第几页，显示N个
        PageHelper.startPage(1, 16);
//        PageInfo<>
        PageInfo<Tool> toolList = toolService.getNewToolList();
        model.addAttribute("toolList", toolList);

        List<ToolType> toolTypeList = toolTypeService.getToolTypeAll();
        model.addAttribute("toolTypeList", toolTypeList);


        return "tools";
    }

    @RequestMapping(value = "/tools/type/{ttId}")
    public String toolsPage(@PathVariable Integer ttId, Model model, Integer pageNum){
        //设置导航条当前焦点
        model.addAttribute("focusIndex", Constants.INDEX_TOOL_PAGE);
        model.addAttribute("ttId", ttId);

        if (pageNum == null || pageNum <= 1){
            pageNum = 1;
        }

        PageHelper.startPage(pageNum, 16);
        PageInfo<Tool> toolList = null;
        if (ttId == 0){
            //最新专题
            toolList = toolService.getNewToolList();
        }else {
            //对应类型专题
            toolList = toolService.getToolList(ttId);
        }

        //拿到所有课程类型
        List<ToolType> toolTypeList = toolTypeService.getToolTypeAll();

        model.addAttribute("toolTypeList", toolTypeList);
        model.addAttribute("toolList", toolList);
        return "tools";
    }

    //========================课程========================================
    /**
     * 获取课程页地址：显示所有
     * @param model
     * @return
     */
    //课程：显示所有分类
    @RequestMapping(value = "/courseList")
    public String courseListPage(Model model){
        //设置导航条当前焦点
        model.addAttribute("focusIndex", Constants.INDEX_COURSE_PAGE);
        model.addAttribute("tId", 0);

        PageHelper.startPage(1, 16);
        PageInfo<Course> courseList = courseService.getNewsTopic();

        //拿到所有课程类型
        List<Type> typeList = typeService.getTypeAll();

        model.addAttribute("typeList", typeList);
        model.addAttribute("courseList", courseList);
        return "course_list";
    }


    /**
     * 获取课程也地址：显示指定tId的课程
     * @param tId
     * @param model
     * @return
     */
    @RequestMapping(value = "/courseList/type/{tId}")
    public String courseListPage(@PathVariable Integer tId, Model model, Integer pageNum){

        //设置导航条当前焦点
        model.addAttribute("focusIndex", Constants.INDEX_COURSE_PAGE);
        model.addAttribute("tId", tId);

        if (pageNum == null || pageNum <= 1){
            pageNum = 1;
        }

        PageHelper.startPage(pageNum, 16);
        PageInfo<Course> courseList = null;
        if (tId == 0){
            //最新专题
             courseList = courseService.getNewsTopic();
        }else {
            //对应类型专题
            courseList = courseService.getCourseList(tId);
        }


        //拿到所有课程类型
        List<Type> typeList = typeService.getTypeAll();

        model.addAttribute("typeList", typeList);
        model.addAttribute("courseList", courseList);
        return "course_list";
    }



    //==========================会员==============================
    /**
     * 获取会员页
     * @return
     */
    @RequestMapping(value = "/vip")
    public String vipPage(Model model){
        //设置导航条当前焦点
        model.addAttribute("focusIndex", Constants.INDEX_VIP_PAGE);

        return "vip";
    }

    //==========================播放==============================
    /**
     * 获取课程视频播放页
     * @return
     */
    @RequestMapping(value = "/courseVedio")
    public String courseVedioPage(){

        return "course_vedio";
    }


    //==========================直播==============================
    /**
     * 获取直播页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/live")
    public String livePage(Model model){
        //设置导航条当前焦点
        model.addAttribute("focusIndex", Constants.INDEX_LIVE_PAGE);


        return "live";
    }
}
