<%-- 
    Document   : tasks
    Created on : Nov 4, 2015, 1:02:19 PM
    Author     : 779609
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tasks Page</title>
         <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
        <style>
            
            body {
-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
}

     </style>
    </head>
    <body id="fmiMain" background="<c:url value='/img/eclipse.jpeg' />" class="container">
        <h1 class="jumbotron" style="background-color:burlywood; opacity:.8">Tasks Checker Results</h1>
        <br>
        <span  class = "label label-warning">Number of rows fetched: <c:out value="${counter}" /></span>
        <c:out value="${result}" escapeXml="false"/>         

    </body>
</html>
