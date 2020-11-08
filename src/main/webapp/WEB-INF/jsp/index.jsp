<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <title>在线视频</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="/static/css/onlinevedio.css" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">

<body>
    <%-- 头部--%>
    <jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>

    <!-- 首页内容区域 -->
    <div class="container mt-4">
        <!-- 轮播图 -->
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <!-- 轮播下划线 -->
            <ol class="carousel-indicators">
                <c:forEach items="${bannerList}" var="banner" varStatus="index" begin="0">
                    <li data-target="#carouselExampleIndicators" data-slide-to="${index.index}"
                        <c:if test="${index.index == 0}">
                            class="active">
                        </c:if>
                    </li>
                </c:forEach>

            </ol>
            <!-- 轮播内容 -->
            <div class="carousel-inner">
                <c:forEach items="${bannerList}" var="banner" varStatus="index" begin="0">
                    <div class="carousel-item <c:if test="${index.index == 0}">active</c:if>">
                        <a href="${banner.BTargetUrl}" target="_blank">
                            <img src="${banner.getBImgUrl()}" class="d-block w-100 rounded-lg" alt="${banner.getBTargetUrl()}">
                        </a>
                    </div>
                </c:forEach>
            </div>
            <!-- 左箭头 -->
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <!--    右箭头 -->
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <!-- 最新课程类型 -->
        <div class="shadow p-3 mb-5 bg-white rounded mt-3 text-center">
            <a href="/courseList" class="float-right mr-1">更多></a>
            <h3>最新课程</h3>
        </div>

        <!-- 具体类目ITEM -->
        <div class="row row-cols-1 row-cols-md-4 mt-2">
            <c:forEach items="${newCourseList.list}" var="course">
                <div class="col mb-3">
                    <a href="/course/${course.getCId()}" target="_blank" style="text-decoration: none;">
                        <div class="card select-shadow">
                            <img src="${course.getCImageUrl()}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">${course.getCTitle()}</p>
                                <div>
                                    <span class="card-text">${course.getCViews()}</span>
                                    <c:choose>
                                        <c:when test="${course.getCVip() == 0}">
                                            <span class="badge badge-pill badge-success float-right mr-1 mt-1">免费</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge badge-pill badge-success float-right mr-1 mt-1">会员</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
        
        <!-- <%-- 最新常用框架类型--%> -->
        <div class="shadow p-3 mb-5 bg-white rounded mt-3 text-center">
            <a href="/courseList/type/3" class="float-right mr-1">更多></a>
            <h3>常用框架</h3>
        </div>

        <!-- 具体类目ITEM -->
        <div class="row row-cols-1 row-cols-md-4 mt-2">
            <c:forEach items="${courseList.list}" var="course">
                <div class="col mb-3">
                    <a href="/course/${course.getCId()}" target="_blank" style="text-decoration: none;">
                        <div class="card select-shadow">
                            <img src="${course.getCImageUrl()}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">${course.getCTitle()}</p>
                                <div>
                                    <span class="card-text">${course.getCViews()}</span>
                                    <c:choose>
                                        <c:when test="${course.getCVip() == 0}">
                                            <span class="badge badge-pill badge-success float-right mr-1 mt-1">免费</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge badge-pill badge-success float-right mr-1 mt-1">会员</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>

    <%-- 尾部区域--%>
    <jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>
