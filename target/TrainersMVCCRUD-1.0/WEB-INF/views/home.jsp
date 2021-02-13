<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
    </head>
    <body>
<!--        prints the "myMessage" attribute -->
        <h1>${myMessage}</h1>
<!--        creates a link based on the context path of the current HttpServletRequest 
        object while appending "/trainer" to it behind the word "Trainers"-->
        <a href="${pageContext.request.contextPath}/trainer">Trainers</a>
    </body>
</html>
