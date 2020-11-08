## 视频学习网站

### 1、项目简介

### 2、开发环境

- 操作系统：win10
- JDK：1.8
- 编译器：IntelliJ IDEA 2019
- Tomcat：9.0.3
- Maven：3.6.3
- Spring：5.2.8
- Mybatis：3.5.3
- Mysql：8.0.13

### 3、技术框架

- 前端：html、css、JS、jQuery、BootStrap
- 后端：SSM框架（框架整合的部份可以看底部的链接地址）
- 数据库：Mysql

### 4、数据库表设计

1. Course：课程专题表
   - c_id：
     - 简介：Course的唯一标识
     - 索引：主键
     - 类型：int，Not Null
   - c_title：
     - 简介：课程标题
     - 类型：varchar(255)
   - c_image_url：
     - 简介：课程图片的url地址
     - 类型：varchar(255)
   - c_intro：
     - 简介：课程的介绍
     - 类型：varchar(255)
   - c_intro_url：
     - 简介：课程的介绍地址
     - 类型：varchar(255)
   - c_views：
     - 简介：课程的浏览次数
     - 类型：int
   - c_flag：
     - 简介：课程的状态
     - 类型：tinyint(4)
   - t_id：
     - 简介：课程的分类
     - 索引：外键（type表的id属性）
     - 类型：int
   - c_vip：
     - 简介：该课程是否是VIP课程
     - 类型：tinyint(4)
   - c_ware_url：
     - 简介：课程的课件下载地址
     - 类型：varchar(255)
   - c_createtime：
     - 简介：课程创建的时间
     - 类型：datatime
2. Vedio：课程视频表
   - v_id：
     - 简介：视频的唯一标识
     - 索引：主键
     - 类型：int Not Null
   - v_name：
     - 简介：视频的名字
     - 类型：varchar(255)
   - v_free_view：
     - 简介：该视频是否可以免费观看
     - 类型：tinyint(4)
   - c_id：
     - 简介：课程专题ID
     - 索引：外键（Course表的ID）
     - 类型：int
   - v_flag：
     - 简介：视频状态
     - 类型：tinyint(4)
   - v_url1：
     - 简介：视频播放地址1
     - 类型：varchar(255)
   - v_url2：
     - 简介：视频播放地址2
     - 类型：varchar(255)
   - v_createtime：
     - 简介：视频创建时间
     - 类型：datetime
3. Type：课程类型表
   - t_id：
     - 简介：课程类型的唯一标识
     - 索引：主键
     - 类型：int NotNull
   - t_name：
     - 简介：课程类型的名称
     - 类型：varchar(255)
   - t_flag：
     - 简介：课程类型的状态
     - 类型：tinyint(4)
     - 表示：
       - 1：可见
       - 0：不可见
4. User：用户表
   - u_id：
     - 简介：用户的唯一标识
     - 索引：主键
     - 类型：int NotNUll
   - u_phone：
     - 简介：用户的联系电话
     - 类型：varchar(255)
   - u_name：
     - 简介：用户的名称
     - 类型：varchar(255)
   - u_password：
     - 简介：用户的密码 
     - 类型：varchar(255)
   - u_email：
     - 简介：用户的邮箱
     - 类型：varchar(255)
   - u_vip：
     - 简介：用户会员的状态
     - 类型：tinyint(4)
     - 状态描述：
       - -1：非会员
       - 1：会员
   - u_createtime：
     - 简介：用户的创建时间
     - 类型：datetime
   - u_flag：
     - 简介：用户的状态
     - 类型：tinyint
     - 表示：
       - 1：表示该用户存在，能被使用
       - -1：表示该用户已被注销
5. Tool_Type：工具类型表
   - tt_id：
     - 简介：工具类型的唯一标识
     - 索引：主键
     - 类型：int NotNUll
   - tt_name：
     - 简介：工具类型的名称
     - 类型：varchar(255)
   - tt_flag：
     - 简介：工具类型的状态
     - 类型：tinyint(4)
     - 表示：
       - 1：可见
       - 0：不可见
6. Tool：工具表
   - t_id：
     - 简介：工具表的唯一标识
     - 索引：主键
     - 类型：int NotNUll
   - t_name：
     - 简介：工具的名称
     - 类型：varchar(255)
   - t_url：
     - 简介：工具的url地址
     - 类型：varchar(255)
   - t_img_url：
     - 简介：工具的图片地址
     - 类型：varchar(255)
   - tt_id：
     - 简介：工具类型的标识
     - 索引：外键（Tool_Type表的tt_id属性）
     - 类型：int
7. Banner：轮播图片
   - b_id：
     - 简介：轮播图的唯一标识
     - 索引：主键
     - 类型：int
   - b_img_url：
     - 简介：轮播图图片的url地址
     - 类型：varchar(255)
   - b_flag：
     - 简介：轮播图的状态
     - 类型：tinyint(4)
   - b_type：
     - 简介：轮播图的类型
     - 类型：varchar(255)
   - b_target_url：
     - 简介：点击轮播图之后的跳转地址
     - 类型：varchar(255)

### 5、功能设计

**用户模块**

- 登录：

  - 登录验证：

    ```
    1、前端获取<input>标签中的账号和密码，通过ajax发送到后端
    2、后端接收到请求后，根据账号和密码查询数据库中的用户：
    	如果用户存在，返回状态码1
    	如果用户不存在，返回状态码-1
    3、浏览器接收到状态码之后
    	如果账号和密码都正确，就发送登录的请求
    	如果不正确就提示用户账号和密码错误
    ```

  - 登录实现：

    ```
    1、浏览器获取<input>标签中的账号、密码以及自动登录的标志位，发送给后端
    2、后端接收到用户和密码之后，首先验证用户信息的合法性
    3、获取application全局对象和seesion对象
    4、根据用户的账号和密码查询数据库中的用户，如果存在则保存到session作用域里
    5、判断是否需要自动登录，如果需要
    	1）
    ```

  - 自动登录的拦截验证：

    ```
    1、后端自定义一个拦截器，拦截所有请求
    2、获取用户的Cookie，判断cookie的Token和application的Token是否一致，判断步骤如下：
    	1）判断cookie是否存在
    	2）判断cookie的Token是否存在
    	3）判断application全局作用域是否存在用户的autoToken及对应的用户信息
    		3.1 判断用户信息是否存在
    		3.2 判断cookieToken是否存在对应的用户数据
    		3.3 判断用户的token是否超时（48时内）
    		3.4 判断cookie的token和application的token是否一致
    3、根据判断的结果：
    	true：获取用户的cookie保存在application中的信息，设置到session作用域里
    ```

  - 退出登录：

    ```
    1、清空用户的session
    2、清空application的Token
    3、设置autoToken的Cookie失效
    ```

    

  - 整体流程：

    - 1）拦截器的自动登录验证，如果没有则放行，交给controller层去解决
    - 2）进行登录验证，验证成功，跳转到第三步
    - 3）实现登录
    - 4）退出登录

  

- 注册：

  - 正则表达式的生成：

    - 使用W3C的生成工具，网址如下：
    - https://www.sojson.com/regex/generate

  - 验证邮箱、手机号、密码格式：

    ```
    通过<input>标签的pattern属性，使用正则表达式去验证
    ```

  - 邮箱验证：

    ```
    1、获取<input>中的value属性，将邮箱发送给服务器
    2、服务器接收到之后，查询该邮箱对应的用户
    3、如果用户为空，则可以使用该邮箱进行注册，返回1
    4、如果用户不为空，证明该邮箱已经被使用过了，不可以被注册-1
    5、服务器将验证结果返回给浏览器
    6、浏览器接收到之后，根据结果进行判断，并提示给用户
    ```

  - 验证码获取：

    ```
    1、通过a标签发送vcode请求，请求服务器
    2、服务器接收到之后
    	1）生成图片，设置图片的大小和字体
    	2）随机生成4位数验证码，设置数字的坐标点和颜色
    	3）设置HTTP响应头，不适用缓存
    	4）响应回给浏览器
    3、将vcode保存在session中
    4、浏览器接收，实现changeVcode(this)方法，当点击验证码，会再次发送vcode请求
    ```

  - 验证码验证：

    ```
    1、将<input>标签中的value属性发送给服务器
    2、服务器接收到之后，先获取session中的vcode，将浏览器发送过来的验证码和真正的vcode进行比较
    3、如果两个验证码相同，则返回1
    4、如果不同，则返回-1
    5、浏览器接收到验证结果后，根据结果提示给用户
    
    ```

  - 注册验证：

    ```
    1、判断邮箱、手机号、密码的格式是否正确
    2、将注册用户的信息插入进数据库
    3、注册成功后，将该用户存放进入session作用域，并跳转到首页，自动登录
    ```

- 忘记密码：

