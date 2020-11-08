<%--
  Created by IntelliJ IDEA.
  User: cai jin hong
  Date: 2020/11/3
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="/static/css/onlinevedio.css" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>

<%-- 头部--%>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>

    <!-- 课程内容区域 -->
    <div class="container mt-4">

        <%--    课程导航--%>
        <ul class="nav nav-pills">
            <li>
                <span>分类：</span>
            </li>
            <li class="nav-item">
                <a class="nav-link ${tId == 0 ? "active" : ""}" href="/courseList">全部</a>
            </li>
            <c:forEach items="${typeList}" var="type">
                <li class="nav-item">
                    <a class="nav-link ${type.TId == tId ? "active" : ""}" href="/courseList/type/${type.TId}">${type.TName}</a>
                </li>
            </c:forEach>
        </ul>
        <%--    具体内容--%>
        <c:forEach items="${courseList.list}" var="course" varStatus="i" begin="0">
            <c:if test="${i.index % 4 == 0}">
                <div class="row row-cols-1 row-cols-md-4 mt-2">
            </c:if>
                <div class="col mb-3">
                    <a href="#" target="_blank" style="text-decoration: none;">
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
                                            <span class="badge badge-pill badge-danger float-right mr-1 mt-1">会员</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            <c:if test="${i.index % 4 == 3 || i.last}">
                </div>
            </c:if>
        </c:forEach>

        <%--    分页--%>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item ${courseList.hasPreviousPage ? '' : 'disabled'}">
                    <a class="page-link" href="/courseList/type/${tId}?pageNum=${courseList.prePage}" tabindex="-1" aria-disabled="true">上一页</a>
                </li>
                <c:forEach var="i" begin="${courseList.navigateFirstPage}" end="${courseList.navigateLastPage}">
                    <li class="page-item ${courseList.pageNum == i  ? 'active' : ''} ">
                        <a class="page-link" href="/courseList/type/${tId}?pageNum=${i}">
                                ${i}
                        </a>
                    </li>
                </c:forEach>
                <li class="page-item ${courseList.hasNextPage ? '' : 'disabled'}">
                    <a class="page-link" href="/courseList/type/${tId}?pageNum=${courseList.nextPage}">下一页</a>
                </li>
            </ul>
        </nav>
    </div>

    <%-- 尾部区域--%>
    <jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

</body>
</html>
