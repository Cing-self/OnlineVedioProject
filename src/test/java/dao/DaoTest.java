package dao;

import cn.hutool.core.util.RandomUtil;
import com.cjh.onlinevedio.dao.*;
import com.cjh.onlinevedio.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class DaoTest {

    @Autowired
    TypeDao typeDao;
    @Autowired
    BannerDao bannerDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    VedioDao vedioDao;
    @Autowired
    ToolDao toolDao;
    @Autowired
    ToolTypeDao toolTypeDao;
    @Autowired
    UserDao userDao;

    @Test
    public void testTypeDao(){
        Type type = new Type();
        type.setTId(1);
        type.setTName("数据库优化");
        type.setTFlag(1);
        typeDao.insertType(type);
    }

    @Test
    public void testBannerDao(){
        Banner banner = new Banner();
        banner.setBId(1);
        banner.setBFlag(1);
        banner.setBImgUrl("testurl");
        banner.setBTargetUrl("testTargetUrl");
        banner.setBType("type");
        int result = bannerDao.insertBanner(banner);
        System.out.println(result);
    }

    @Test
    public void testCourseDao(){
        for (int i = 1; i <= 100; i++) {
            Course course = new Course();
            course.setCId(i);
            course.setCTitle("Flutter" + i + "从入门到进阶");
            course.setCWareUrl("none");
            course.setCIntro("掌握Flutter" + i +"开发的各项技术，可以在公司实际应用和开发Flutter，了解Flutter一些底层原理技术。");
            course.setCIntroUrl("none");
            course.setCViews(1000);
            course.setCVip(RandomUtil.randomInt(0, 2));
            course.setCFlag(1);
            course.setCCreatetime(new Date());
            course.setCImageUrl("/static/imgs/card-item.png");
            course.setTId(RandomUtil.randomInt(1, 8));
            courseDao.insertCourse(course);
        }


    }

    @Test
    public void testVedioDao(){
        ArrayList<String> list = new ArrayList<>();
        list.add("//player.bilibili.com/player.html?aid=202637985&bvid=BV1sa411c7Sv&cid=252536788&page=1");
        list.add("//player.bilibili.com/player.html?aid=457638460&bvid=BV1r5411L76f&cid=251900050&page=1");
        list.add("//player.bilibili.com/player.html?aid=842718649&bvid=BV1k54y1r7tF&cid=252693396&page=1");
        list.add("//player.bilibili.com/player.html?aid=842729394&bvid=BV1o54y1r7qN&cid=252797078&page=1");
        list.add("//player.bilibili.com/player.html?aid=372547470&bvid=BV1TZ4y1V7Ji&cid=250933064&page=1");
        list.add("//player.bilibili.com/player.html?aid=755125633&bvid=BV1Hr4y1w7Db&cid=252606976&page=1");
        list.add("//player.bilibili.com/player.html?aid=499384684&bvid=BV11K411N7KA&cid=232615748&page=1");
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 7; j ++) {
                Vedio vedio = new Vedio();
                vedio.setVId(i * 100 + j);
                vedio.setVName("Vue 3.0 正式版---" + j);
                vedio.setVCreatetime(new Date());
                vedio.setCId(i);
                vedio.setVFlag(1);
                if (j <=3 ){
                    vedio.setVFreeView(0);
                }else {
                    vedio.setVFreeView(1);
                }
                vedio.setVUrl1(list.get(j - 1));
                vedio.setVUrl2("none");
                vedioDao.insertVedio(vedio);
            }
        }
    }

    @Test
    public void testUserDao(){
        for (int i = 2; i <= 100; i++) {
            User user = new User();
            user.setUId(i);
            user.setUName("username" + i);
            if (i % 2 == 0){
                user.setUVip(1);
            }else {
                user.setUVip(-1);
            }
            user.setUEmail(i + "@qq.com");
            user.setUPassword("" + i + i + i + i);
            user.setUPhone("12306" + i);
            user.setUCreatetime(new Date());
            userDao.insertUser(user);
        }
    }

    @Test
    public void testToolDao(){
        for (int i = 1; i <= 50; i++) {
            Tool tool = new Tool();
            tool.setTId(i);
            tool.setTName("Spring" + i + "开发文档");
            tool.setTtId(RandomUtil.randomInt(1, 4));
            tool.setTImgUrl("/static/imgs/card-item.png");
            tool.setTUrl("none");
            toolDao.insertTool(tool);
        }
    }

    @Test
    public void testToolTypeDao(){
        ToolType toolType = new ToolType();
        toolType.setTtId(1);
        toolType.setTtName("toolType1");
        int result = toolTypeDao.insertToolType(toolType);
        System.out.println(result);
    }
}
