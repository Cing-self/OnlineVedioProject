<%--
  Created by IntelliJ IDEA.
  User: cai jin hong
  Date: 2020/11/6
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>在线视频后台管理系统</title>
    <title>在线视频</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="/static/css/onlinevedio.css" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/font-awesome.min.css" crossorigin="anonymous">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>
<body>

<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Company name</a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse"
            data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">Sign out</a>
        </li>
    </ul>
</nav>

    <div class="container-fluid">
        <div class="row">
            <nav id="sidebarMenu" class="col-md-2 col-lg-2 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">
                                <span data-feather="home"></span>
                                用户列表 <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="file"></span>
                                视频类型
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="shopping-cart"></span>
                                课程视频
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="users"></span>
                                工具类型
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="bar-chart-2"></span>
                                网站工具
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="layers"></span>
                                视频专题
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="layers"></span>
                                banner广告
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>

            <main role="main" class="col-md-10 ml-sm-auto col-lg-10 px-md-4">
                <h2>Section title</h2>
                <div class="card shadow mb-4">
                    <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                                <div class="row">
                                    <div class="col-sm-12 col-md-6 mb-1">
                                        <a href="#" class="btn btn-light">添加</a>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <table class="table table-bordered dataTable" id="dataTable" width="100%"
                                               cellspacing="0" role="grid" aria-describedby="dataTable_info"
                                               style="width: 100%;">
                                            <thead>
                                                <tr role="row">
                                                <th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1"
                                                    colspan="1" aria-sort="ascending"
                                                >#ID
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                                    colspan="1"
                                                >手机
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                                    colspan="1"
                                                >用户名
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                                    colspan="1"
                                                >密码
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                                    colspan="1"
                                                >邮箱
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                                    colspan="1"
                                                >会员
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                                    colspan="1"
                                                >注册时间
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                                    colspan="1"
                                                >删除
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1"
                                                    colspan="1"
                                                >修改
                                                </th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <c:forEach items="${userList.list}" var="user">
                                                <tr role="row" class="odd">
                                                    <td class="sorting_1">${user.getUId()}</td>
                                                    <td>${user.getUPhone()}</td>
                                                    <td>${user.getUName()}</td>
                                                    <td>${user.getUPassword()}</td>
                                                    <td>${user.getUEmail()}</td>
                                                    <td>${user.getUVip()}</td>
                                                    <td>${user.getUCreatetime()}</td>
                                                    <td>
                                                        <a myAttr="/admin/userDel/${user.getUId()}?pageNum=" + ${userList.pageNum} class="btn btn-light" onclick="deleteUser(this)">删除</a>
                                                    </td>
                                                    <td>
                                                        <a href="/#" class="btn btn-light">修改</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>

                                            <div class="modal fade" id="delcfmModel">
                                                <div class="modal-dialog">
                                                    <div class="modal-content message_align">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                                                            <h4 class="modal-title">提示信息</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <p>您确认要删除吗？</p>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <input type="hidden" id="url"/>
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                            <a  onclick="urlSubmit()" class="btn btn-success" data-dismiss="modal">确定</a>
                                                        </div>
                                                    </div><!-- /.modal-content -->
                                                </div><!-- /.modal-dialog -->
                                            </div><
                                        </table>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-5">
                                        <div class="dataTables_info" id="dataTable_info" role="status" aria-live="polite">
                                            Showing 1 to ${userList.pages} of ${userList.total} entries
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-7">
                                        <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                                            <%-- 分页--%>
                                            <nav aria-label="Page navigation example">
                                                <ul class="pagination">
                                                    <li class="page-item">
                                                        <a class="page-link"
                                                           href="/admin/user?pageNum=${userList.prePage}">上一页</a>
                                                    </li>
                                                    <c:forEach var="i" begin="${userList.navigateFirstPage}"
                                                               end="${userList.navigateLastPage}">
                                                        <li class=" page-item ${userList.pageNum == i ? "active" : "" } ">
                                                            <a class="page-link"
                                                               href="/admin/user?pageNum=${i}">${i}</a>
                                                        </li>
                                                    </c:forEach>
                                                    <li class="page-item  ">
                                                        <a class="page-link"
                                                           href="/admin/user?pageNum=${userList.nextPage}">下一页</a>
                                                    </li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
<!-- JS -->
<script src="/static/js/jquery-3.3.1.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

<script type="text/javascript">
    function deleteUser(node) {
        $.confirm({
            title: 'Delete user?',
            content: 'This dialog will automatically trigger \'cancel\' in 6 seconds if you don\'t respond.',
            autoClose: 'cancelAction|8000',
            buttons: {
                deleteUser: {
                    text: 'delete user',
                    action: function () {
                        <%--// --/admin/userDel/${user.id}?pageNum=${userList.pageNum}--%>
                        // var val = delNode.getAttribute("value");
                        var myAttr = $(node).attr("myAttr");
                        console.log(myAttr);
                        $.alert('用户已删除!');
                        window.location.href= myAttr;

                    }
                },
                cancelAction: function () {
                    $.alert('用户删除已取消!');
                }
            }
        });
    }
</script>
</body>
</html>
