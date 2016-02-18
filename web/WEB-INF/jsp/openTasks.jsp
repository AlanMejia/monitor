<%-- 
    Document   : openTasks
    Created on : Dec 7, 2015, 5:19:48 PM
    Author     : 779609
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Open Tasks Page</title>
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
/*td{
    border: 1px solid whitesmoke;
    color: whitesmoke;
    
}  */
     </style>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>   
     <script> 
$(document).ready(function(){
    $("div").hide();
    $("#showScript").click(function(){
       
        $("div").show();
    });
});
         
        
         
    

</script>
    </head>
    <body id="fmiMain" background="<c:url value='/img/cat.jpg' />" class="container">
        <h1 class="jumbotron" style="background-color:chartreuse; opacity:.8">Open Tasks Checker Results</h1>
        <br>
        <span  class = "label label-warning">Number of rows fetched: <c:out value="${counter}" /></span>
        <c:out value="${result}" escapeXml="false"/><br>
        <button style="margin-bottom:20px" type="button" id="showScript" class="btn btn-success">Get Script!</button>
        
        <div style="border-radius: 5px; color:brown; background-color:chartreuse; opacity:.85"><b><c:out value="${script}" escapeXml="false"/></b></div>

    </body>
</html>
