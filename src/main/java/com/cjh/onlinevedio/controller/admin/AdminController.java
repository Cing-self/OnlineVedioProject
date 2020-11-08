package com.cjh.onlinevedio.controller.admin;

import com.cjh.onlinevedio.domain.User;
import com.cjh.onlinevedio.exception.UserException;
import com.cjh.onlinevedio.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin")
    public String adminPage(Model model){

        PageHelper.startPage(1, 8);
        PageInfo<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);

        return "/admin/main";
    }

    @RequestMapping(value = "/admin/user")
    public String userList(Model model, Integer pageNum){

        if (pageNum == null || pageNum <= 1){
            pageNum = 1;
        }

        PageHelper.startPage(pageNum, 8);
        PageInfo<User> userList = userService.getUserList();

        model.addAttribute("userList", userList);
        return "/admin/main";
    }

    //删除
    @RequestMapping(value = "/admin/userDel/{uId}")
    public String deleteUser(@PathVariable Integer uId, Integer pageNum){
        int code = userService.delete(uId);
        System.out.println(code);
        if (pageNum == null || pageNum <= 1){
            pageNum = 1;
        }

        return "redirect:/admin/user?pageNum=" + pageNum;
    }

    //修改
    @RequestMapping(value = "/admin/userUpdate")
    public String updateUser(User user, Model model, Integer pageNum){
        if (pageNum == null || pageNum <= 1){
            pageNum = 1;
        }
        if (user == null){
            throw new UserException("修改出错，请返回上一页");
        }
        User dbUser = userService.selectUser(new HashMap<String, Object>(){
            {
                put("uId", user.getUId());
            }
        });
        if (dbUser == null){
            throw new UserException("该用户不存在，请重新刷新页面");
        }
        int code = userService.update(user);

        return "redirect:/admin/user?pageNum=" + pageNum;
    }
    //
}
