<%-- 
    Document   : materials
    Created on : Nov 5, 2015, 2:50:57 PM
    Author     : 779609
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oracle Materials Checker Page</title>
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
    <body id="fmiMain" background="<c:url value='/img/blacknred.jpg' />" class="container">
        <h1 class="jumbotron" style="background-color:darkred; opacity:.8; color:whitesmoke">Oracle Materials Checker Page</h1>
        <br>
        <span class="label label-danger">Number of rows fetched: <c:out value="${counter}" /></span>
        <br><br>
        <c:out value="${result}" escapeXml="false"/>           

    </body>
</html>
