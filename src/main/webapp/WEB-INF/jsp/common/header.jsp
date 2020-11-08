<%--
  Created by IntelliJ IDEA.
  User: cai jin hong
  Date: 2020/10/31
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light shadow">

    <div class="container">
        <a class="navbar-brand" href="#">在线视频</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item <c:if test="${focusIndex == 1}">active</c:if>">
                    <a class="nav-link" href="/">首页 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item <c:if test="${focusIndex == 2}">active</c:if>">
                    <a class="nav-link" href="/courseList">课程</a>
                </li>
                <li class="nav-item <c:if test="${focusIndex == 3}">active</c:if>">
                    <a class="nav-link" href="/vip">会员</a>
                </li>
                <li class="nav-item <c:if test="${focusIndex == 4}">active</c:if>">
                    <a class="nav-link" href="#">直播</a>
                </li>
                <li class="nav-item <c:if test="${focusIndex == 5}">active</c:if>">
                    <a class="nav-link" href="/tools">工具</a>
                </li>
            </ul>
            <div>
                <%--            已经登录的用户，显示用户名--%>
                <c:choose>
                    <c:when test="${!empty sessionScope.login_user}">
                        <div class="nav-item dropdown float-right mr-3">
                            <a class="nav-link dropdown-toggle text-primary" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    ${sessionScope.login_user.UName}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">个人中心</a>
                                <a class="dropdown-item" href="#">收藏</a>
                                <a class="dropdown-item" href="#">课程表</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/loginOut">退出登录</a>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <a href="#" data-toggle="modal" data-target="#loginModal" data-whatever="@fat" class="mr-1">登录</a>/
                        <a href="#" data-toggle="modal" data-target="#registModal" data-whatever="@mdo" class="ml-1 mr-3">注册</a>
                    </c:otherwise>
                </c:choose>
            </div>

            <form class="form-inline my-2 my-lg-0" method="post" action="/search" onblur="">
                <input name="courseName" class="form-control mr-sm-2" type="search" placeholder="搜索" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
            </form>
        </div>
    </div>

</nav>


<!-- 登录框 -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- 登录表单 -->
            <form method="post" action="/login" onsubmit="return loginSubmit()">
                <div class="modal-header">
                    <h5 class="modal-title" id="loginModalLabel">登录</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- 账号 -->
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationLoginAccount">账号</label>
                            <input type="text" name="uEmail" class="form-control" id="validationLoginAccount" placeholder="请输入用户名/邮箱/手机号" required>
                            <div class="valid-feedback" id="feedbackLoginAccount">
                                Looks good!
                            </div>
                        </div>
                    </div>
                    <!-- 密码： -->
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationLoginPassword">密码</label>
                            <input type="text" name="uPassword" class="form-control" id="validationLoginPassword" placeholder="请输入密码" required>
                            <div class="invalid-feedback" id="feedbackLoginPassword">
                                Please provide a valid city.
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input" name="autoLogin" type="checkbox" value="1" id="invalidCheck3">
                            <label class="form-check-label" for="invalidCheck3">
                                自动登录
                            </label>
                        </div>

                        <div class="mb-1 mt-2">
                            <a href="#" data-toggle="modal" data-dismiss="modal" ata-target="#registModal">还没有账号？点我注册</a>
                            <a href="#" class="float-right">忘记密码</a>
                        </div>

                    </div>

                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button class="btn btn-primary" type="submit">登录</button>
                </div>


            </form>

        </div>
    </div>
</div>

<!-- 注册框 -->
<div class="modal fade" id="registModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- 注册表单 -->
            <form action="regist" method="post" onsubmit="return registSubmit()">
                <div class="modal-header">
                    <h5 class="modal-title" id="registerModalLabel">注册</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- 用户名 -->
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationRegisterName">用户名</label>
                            <input type="text" name="uName" placeholder="请输入用户名" class="form-control" id="validationRegisterName" required>
                            <div class="valid-feedback">
                                Looks good!
                            </div>
                        </div>
                    </div>
                    <!-- 邮箱 -->
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationRegisterEmail">邮箱</label>
                            <input id="validationRegisterEmail" type="text" name="uEmail" placeholder="请输入邮箱" onblur="checkEmail(this)"
                                   pattern="[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?"
                                   class="form-control" required>
                            <div class="valid-feedback" id="feedbackRegisterEmail">
                                Looks good!
                            </div>
                        </div>
                    </div>
                    <!-- 手机 -->
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationRegisterPhone">手机</label>
                            <input type="text" pattern="1[3456789]\d{9}$" placeholder="请输入手机号" name="uPhone" class="form-control" id="validationRegisterPhone" required>
                            <div class="valid-feedback" id="feedbackPhone">
                                Looks good!
                            </div>
                        </div>
                    </div>
                    <!-- 密码： -->
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationRegisterPassword">密码</label>
                            <input type="text" name="uPassword" placeholder="包含数字和字母且在6-20位之间"
                                   pattern="^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{6,20}$" class="form-control" id="validationRegisterPassword" required>
                            <div class="invalid-feedback">
                                Please provide a valid city.
                            </div>
                        </div>
                    </div>
                    <!-- 验证码 -->
                    <div class="form-row">
                        <div class="col-md-12 mb-3">
                            <label for="validationRegisterVcode">验证码</label>
                            <!-- is-valid is-invalid-->
                            <div class="row">
                                <div class="col-md-7">
                                    <input type="text" name="vcode" placeholder="请输入验证码" class="form-control" id="validationRegisterVcode" maxlength="4" required>
                                    <div class="valid-feedback" id="feedbackVcode">
                                        Looks good!
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <img src="/vcode" onclick="changeVcode(this)"></img>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ml-1">
                            <a href="#" data-toggle="modal" data-dismiss="modal" data-target="#loginModal">已有账号？点我登录</a>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button class="btn btn-primary" type="submit">注册</button>
                </div>

            </form>
        </div>
    </div>
</div>

<!-- JS -->
<script src="/static/js/jquery-3.3.1.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script type="application/javascript">

    //登录校验
    function loginSubmit() {
        var flag = false;

        $.ajax({
            url: "/checkLogin",
            type: "POST",
            data: {
                uEmail: $("#validationLoginAccount").val(),
                uPassword: $("#validationLoginPassword").val()
            },
            async: false,
            success: function (result) {
                if (result.rcode == 1){
                    //可以登录
                    flag = true;
                    console.log("登录成功");
                }else {
                    //不可以登录
                    console.log("登录失败");
                    $("#validationLoginAccount").addClass("is-invalid");
                    $("#validationLoginPassword").addClass("is-invalid");
                    $("#feedbackLoginPassword").addClass("invalid-feedback").text("账号或密码错误");
                    flag = false;
                }
            },
        });

        return flag;
    }
    //注册验证
    function registSubmit() {
        var vcodeFlag = checkVcode();
        if(vcodeFlag){
            //提交注册
            $("#validationRegisterVcode").removeClass("is-invalid").addClass("is-valid");
            $("#feedbackVcode").text("验证码正确").removeClass("invalid-feedback").addClass("valid-feedback");
            return true;
        }
        //否则设置验证码的状态
        $("#validationRegisterVcode").removeClass("is-valid").addClass("is-invalid");
        $("#feedbackVcode").text("验证码错误").removeClass("valid-feedback").addClass("invalid-feedback");
        return false;
    }

    function checkVcode() {
        var vcode = $('#validationRegisterVcode').val();
        var flag = false;
        $.ajax({
            url: "/checkVcode?vcode=" + vcode,
            success: function (result) {
                if(result.rcode == 1){
                    flag = true;
                }
            },
            async: false
        });

        return flag;
    }
    function changeVcode(img) {
        img.src = "/vcode?ram" + new Date().getTime();
    }

    //检查邮箱
    function checkEmail(emailNode) {
        var email = emailNode.value;
        if (email != null && email != ""){
            $.ajax({
                url: "/checkEmail?email=" + email,
                success: function (result) {
                    if (result.rcode == 1){
                        //可以注册
                        $("#validationRegisterEmail").removeClass("is-invalid").addClass("is-valid");
                        $("#feedbackRegisterEmail").text("Email可以注册");
                        $("#feedbackRegisterEmail").removeClass("invalid-feedback").addClass("valid-feedback");
                    }else {
                        //不可以注册
                        $("#validationRegisterEmail").removeClass("is-valid").addClass("is-invalid");
                        $("#feedbackRegisterEmail").text("Email不可以注册").removeClass("valid-feedback").addClass("invalid-feedback");
                    }
                }
            });
        }
    }

    //搜索框提示
</script>
