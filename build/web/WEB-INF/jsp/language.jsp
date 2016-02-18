<%-- 
    Document   : language
    Created on : Nov 23, 2015, 11:18:33 AM
    Author     : 779609
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>language Page</title>
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
    <body id="languageMain" background="<c:url value='/img/blacknblue.jpg' />" class="container"">
        <h1 class="jumbotron" style="background-color:royalblue; opacity:.8">Language Checker Results</h1>
        <br>
        <span  class = "label label-info">Number of rows fetched: <c:out value="${counter}" /></span>
        <br><br>
        <c:out value="${result}" escapeXml="false"/> <br><br>
        <button style="margin-bottom:20px" type="button" id="showScript" class="btn btn-primary">Get Script!</button>
        <div style="border-radius: 0px; color:white; opacity:.7; background-color:royalblue"><b><c:out value="${script}" escapeXml="false"/></b></div>

    </body>
</html>
