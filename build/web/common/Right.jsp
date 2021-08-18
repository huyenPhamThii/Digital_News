<%-- 
    Document   : Right
    Created on : May 13, 2021, 10:11:49 PM
    Author     : Pham Thi Huyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
        <title>Search Page</title>
    </head>
    <body>
        <div class="right">
            <div class="titleRight">
                Digital News
            </div>

            <div class="shortDes">
                ${mostRecentArticle.shortDes}
            </div>

            <div class="titleRight">
                Search
            </div>

            <form action="search" method="POST" name="checkForm">
                <div class="search">
                    <input class="txtSearch" type="text" name="keyword" value="${keyword}" required size="15" placeholder="Enter to search..." pattern=".*\S+.*" title="This field is required"/>
                    <input class="btnSearch" type="submit" value="Go" />
                </div>
            </form>

            <div class="titleRight">
                Last Articles
            </div>
            <c:forEach items="${top5MostRecent}" begin="1" var="o">
                <div class="lastArticles">
                    <a href="home?id=${o.id}">${o.title}</a>
                </div>
            </c:forEach>
        </div>
        
    </body>
</html>
