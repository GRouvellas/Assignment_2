<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainers</title>
        <link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
    </head>
    <body>
        <h1>List of trainers</h1>
        <div>
            <h3>Trainers</h3>
            <p>
<!--                prints the "message" attribute-->
                ${message}
            </p>
<!--        creates a link based on the context path of the current HttpServletRequest object 
        while appending "/trainer" and "/create" to it behind the phrase "Add Trainer"-->
            <a href="${pageContext.request.contextPath}/trainer/create">Add trainer</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>trainer ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Subject</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
<!--                iterates the listOfTrainers list for every Trainer object printing its properties 
                in the cells of a row-->
                <c:forEach items="${listOfTrainers}" var = "trainer">
                    <tr>
                        <td>${trainer.trainerID}</td>
                        <td>${trainer.firstName}</td>
                        <td>${trainer.lastName}</td>
                        <td>${trainer.subject}</td>
                        <td>
<!--                creates a link based on the context path of the current HttpServletRequest object
                while appending "/trainer", "/create" and the trainerID of the Trainer object that
                the iterator got to, behind the word "Update", in a cell next to the trainer.subject
                cell of the table-->
                            <a href="${pageContext.request.contextPath}/trainer/update/${trainer.trainerID}">Update</a>
                        </td>
                        <td>
<!--                creates a link based on the context path of the current HttpServletRequest object
                while appending "/trainer", "/delete?=(the trainerID of the Trainer object that
                the iterator got to)", behind the word "Delete", in a cell next to the cell with 
                the update link -->
                            <a href="${pageContext.request.contextPath}/trainer/delete?id=${trainer.trainerID}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
