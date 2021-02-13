<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer Form</title>
        <link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
    </head>
    <body>
        <!--        A JSTL if tag that checks the daskalos attribute and determines the values of 
                the "link" and "welcometxt" attributes depending on if it's equal to null or not-->
        <c:if test="${trainerToEdit==null}">
            <c:url var="link" value="/trainer/create"/>
            <c:set var="welcometxt" value="Create a Trainer"></c:set>
        </c:if>
        <c:if test="${trainerToEdit!=null}">
            <c:url var="link" value="/trainer/update"/>
            <c:set var="welcometxt" value="Update a Trainer"></c:set>
        </c:if>

        <h1>${welcometxt}</h1>

    <form action="${link}" method="POST">
        <label for="trainerID">Code:</label>
        <input id="trainerID" type="number" name="trainerID" value="${trainerToEdit.trainerID}" readonly/>
        <br/>
        <label for="firstName">First Name:</label>
        <input id="firstName" type="text" name="firstName" value="${trainerToEdit.firstName}"/>
        <br/>
        <label for="lastName">Last Name:</label>
        <input id="lastName" type="text" name="lastName" value="${trainerToEdit.lastName}"/>
        <br/>
        <label for="subject">Subject:</label>
        <input id="subject" type="text" name="subject" value="${trainerToEdit.subject}"/>
        <br/>
        <input type="submit" value="Submit" class="button"/>
    </form>
            
    </body>
</html>
