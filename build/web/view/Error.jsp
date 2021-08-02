<%-- 
    Document   : Error
    Created on : May 15, 2021, 2:22:00 PM
    Author     : Pham Thi Huyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/error.css" rel="stylesheet" type="text/css"/>

        <title>Error Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="common/Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="content">
                        ${error}
                    </div>
                </div>

                <jsp:include page="common/Right.jsp"/>
            </div>
            <jsp:include page="common/Footer.jsp"/>
        </div>
    </body>
</html>
