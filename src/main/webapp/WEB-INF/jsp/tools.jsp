<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cai jin hong
  Date: 2020/11/3
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工具</title>

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

<!-- 工具内容区域 -->
<div class="container mt-4">

<%--    工具导航--%>
    <ul class="nav nav-pills">
        <li>
            <span>分类：</span>
        </li>
        <li class="nav-item">
            <a class="nav-link ${ttId == 0 ? "active" : ""}" href="/tools">全部</a>
        </li>
        <c:forEach items="${toolTypeList}" var="toolType">
            <li class="nav-item">
                <a class="nav-link ${toolType.ttId == ttId ? "active" : ""}" href="/tools/type/${toolType.ttId}">${toolType.ttName}</a>
            </li>
        </c:forEach>
    </ul>
<%--    具体内容--%>
    <c:forEach items="${toolList.list}" var="tool" varStatus="i" begin="0">
        <c:if test="${i.index % 4 == 0}">
            <div class="row row-cols-1 row-cols-md-4 mt-2">
        </c:if>
        <div class="col mb-3">
            <a href="#" target="_blank" style="text-decoration: none;">
                <div class="card select-shadow">
                    <img src="${tool.getTImgUrl()}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text">${tool.getTName()}</p>
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
            <li class="page-item ${toolList.hasPreviousPage ? '' : 'disabled'}">
                <a class="page-link" href="/tools/type/${ttId}?pageNum=${toolList.prePage}" tabindex="-1" aria-disabled="true">上一页</a>
            </li>
            <c:forEach var="i" begin="${toolList.navigateFirstPage}" end="${toolList.navigateLastPage}">
                <li class="page-item ${toolList.pageNum == i  ? 'active' : ''} ">
                    <a class="page-link" href="/tools/type/${ttId}?pageNum=${i}">
                            ${i}
                    </a>
                </li>
            </c:forEach>
            <li class="page-item ${toolList.hasNextPage ? '' : 'disabled'}">
                <a class="page-link" href="/tools/type/${ttId}?pageNum=${toolList.nextPage}">下一页</a>
            </li>
        </ul>
    </nav>
</div>

    <%-- 尾部区域--%>
    <jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

</body>
</html>
