<%-- 
    Document   : Search
    Created on : May 15, 2021, 3:21:58 PM
    Author     : Pham Thi Huyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/search.css" rel="stylesheet" type="text/css"/>
        <title>Search Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="../common/Header.jsp"/>
            <div class="content">
                <div class="left">
                    <div>
                        <c:forEach items="${listSearch}" var="i">
                            <div class="title">
                                <a href="home?id=${i.id}" >${i.title}</a>
                            </div>

                            <div class="image_search">
                                <img src="images/${i.image}" alt=""/>
                            </div>

                            <div class="shortDes_search">
                                ${i.shortDes}
                            </div>
                        </c:forEach>

                    </div>
                    <div class="page">
                        <c:forEach begin="1" end="${pageNumber}" var="i">
                            <a class="${i==pageIndex?"active":""}" href="search?pageIndex=${i}&keyword=${keyword}">${i}</a>
                        </c:forEach>
                    </div>
                </div>

                <jsp:include page="../common/Right.jsp"/>
            </div>

            <jsp:include page="../common/Footer.jsp"/>
        </div>
    </body>
</html>
