package com.cjh.onlinevedio.controller;

import cn.hutool.Hutool;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.cjh.onlinevedio.dto.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class VcodeController {

    char[] vcodeSequence = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    @RequestMapping("/checkVcode")
    @ResponseBody
    public ResponseResult checkVcode(String vcode, HttpSession session){
        ResponseResult result = new ResponseResult(-1, "vcode invalid");
        String sVcode = (String) session.getAttribute("session_vcode");
        if (StrUtil.isEmpty(sVcode) || StrUtil.isEmpty(vcode)){
            return result;
        }
        if (vcode.equals(sVcode)){
            result.setRcode(1);
            result.setMessage("vcode valid");
        }

        return result;

    }
    //响应
    @RequestMapping("/vcode")
    public void getVcode(HttpServletResponse response, HttpServletRequest request){
        //设置生成图片的属性
        BufferedImage bufferedImage = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawRect(0, 0, 80, 30);
        graphics2D.setFont(new Font("宋体", Font.BOLD, 25));
        //保存验证码
        StringBuilder builder = new StringBuilder();
        //生成随机验证码
        for (int i = 0; i < 4; i ++){
            String rdStr = String.valueOf(vcodeSequence[RandomUtil.randomInt(10)]);
            builder.append(rdStr);
            graphics2D.setColor(new Color(RandomUtil.randomInt(255), RandomUtil.randomInt(255), RandomUtil.randomInt(255)));
            graphics2D.drawString(rdStr, i * 15 + 10 , 22);
        }

        //验证码保存到session
        HttpSession session = request.getSession();
        session.setAttribute("session_vcode", builder.toString());

        //设置HTTP响应头，图片类型
        response.setContentType("image/jpeg");
        //设置不使用缓存
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        try {
            ServletOutputStream ous = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpeg", ous);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
