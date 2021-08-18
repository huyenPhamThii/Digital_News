<%-- 
    Document   : Home
    Created on : May 10, 2021, 1:38:11 PM
    Author     : Pham Thi Huyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="../common/Header.jsp"/>
            <div class="content">
                <div class="left">
                    <div class="titleLeft">
                        ${mostRecentArticle.title}
                    </div>

                    <div class="image">
                        <img src="images/${mostRecentArticle.image}" alt=""/>
                    </div>

                    <div class="description">
                        ${mostRecentArticle.description}
                    </div>

                    <div class="infor">
                        <img src="images/comment.gif" alt=""/>
                        <img src="images/timeicon.gif" alt=""/>
                        By ${mostRecentArticle.author} | ${timePost}
                    </div>
                </div>

                <jsp:include page="../common/Right.jsp"/>
            </div>
            <jsp:include page="../common/Footer.jsp"/>
        </div>
    </body>
</html>
