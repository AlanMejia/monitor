<%-- 
    Document   : monitorDashboard
    Created on : Dec 10, 2015, 1:02:12 PM
    Author     : 779609
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>eServices Monitor Dashboard</title>
         <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>   
         <script type="text/javascript" src="/js/dashboard.js"></script>
         <link type="text/css" href="/css/dashboard.css" rel="stylesheet">
         <style>
             .lastDiv{
                 border-radius: 5px; 
                 color:white; 
                background-color:royalblue; 
                opacity:.85; 
                margin-bottom: 50px;    
                 }
           
                body {
                    -moz-background-size: cover;
                    -webkit-background-size: cover;
                    background-size: cover;
                    background-position: top center !important;
                    background-repeat: no-repeat !important;
                    background-attachment: fixed;
                }

         </style>
         
         <script>
    $(document).ready(function(){
        $(".lastDiv").hide();
   
        if ("${fmiCount}" == 0){
         $("#fmiDiv").hide();      
           }else{
               $("#fmibtn").click(function(){       
                 $("#fmiScript").show();
             });}

        if ("${tasksCount}"==0){
          $("#tasksNoValDiv").hide();
            }
     
     if("${SSCount}"==0){
         $("#ssDiv").hide();         
            }else{
                $("#ssbtn").click(function(){       
                  $("#ss").show();
         });}

    if ("${pendCount}"==0){
        $("#openTasksDiv").hide();
    }else{
    $("#tasksbtn").click(function(){       
        $("#tasks").show();
    });}

   if ("${matCount}"==0){
       $("#matDiv").hide();}
    
    
    if ("${lanCount}"==0){
        $("#lanDiv").hide();
    }else{
         $("#lanbtn").click(function(){       
              $("#lan").show();
    });}
    
           
    
});
             
             
         </script>        
             
    </head>
    
    <body  background="<c:url value='/img/leaves.jpg' />" class="container">
        
        <div id="fmiDiv">
            <h1 class="jumbotron" style="background-color:royalblue; opacity:.8">FMI Mismatches</h1>
            <br>
            <span class = "label label-info">Number of rows fetched: <c:out value="${fmiCount}" /></span>
            <c:out value="${fmiResult}" escapeXml="false"/><br>
            <button id="fmibtn" style="margin-bottom:20px" type="button" class="btn btn-primary">Get Script!</button>        
            <div id="fmiScript" class="lastDiv"><b><c:out value="${fmiScript}" escapeXml="false"/></b></div>
        </div>
        
        <div id="tasksNoValDiv">
            <h1 class="jumbotron" style="background-color:royalblue; opacity:.8">Tasks without values</h1>
            <br>
            <span class = "label label-info">Number of rows fetched: <c:out value="${tasksCount}" /></span>
            <c:out value="${tasksResult}" escapeXml="false"/><br>
        </div>
        
        <div id="ssDiv">
            <h1 class="jumbotron" style="background-color:royalblue; opacity:.8">Service Sheet with wrong Loco_ID</h1>
            <br>
            <span  class = "label label-info">Number of rows fetched: <c:out value="${SSCount}" /></span>
            <c:out value="${SSResult}" escapeXml="false"/><br>
            <button id="ssbtn" style="margin-bottom:20px" type="button" class="btn btn-primary">Get Script!</button>
            <div id="ss" class="lastDiv"><b><c:out value="${SSScript}" escapeXml="false"/></b></div>
        </div>
        
        
        <div id="openTasksDiv">
            <h1 class="jumbotron" style="background-color:royalblue; opacity:.8">Open Tasks for pended Service Sheets</h1>
            <br>
            <span  class = "label label-info">Number of rows fetched: <c:out value="${pendCount}" /></span>
            <c:out value="${pendResult}" escapeXml="false"/><br>
            <button id="tasksbtn" style="margin-bottom:20px" type="button" class="btn btn-primary">Get Script!</button>
            <div id="tasks" class="lastDiv"><b><c:out value="${pendScript}" escapeXml="false"/></b></div>
        </div>
            
        <div id="matDiv">    
            <h1 class="jumbotron" style="background-color:royalblue; opacity:.8; color:whitesmoke">Oracle Materials Missing Service Sheets</h1>
            <br>
            <span class = "label label-info">Number of rows fetched: <c:out value="${matCount}" /></span>
            <br><br>
            <c:out value="${matResult}" escapeXml="false"/> 
        </div>
        
        <div id="lanDiv">
            <h1 class="jumbotron" style="background-color:royalblue; opacity:.8">2.0 SPN Language issues</h1>
            <br>
            <span  class = "label label-info">Number of rows fetched: <c:out value="${lanCount}" /></span>
            <br><br>
            <c:out value="${lanResult}" escapeXml="false"/> <br><br>
            <button id="lanbtn" style="margin-bottom:20px" type="button" class="btn btn-primary">Get Script!</button>
            <div id="lan" class="lastDiv"><b><c:out value="${lanScript}" escapeXml="false"/></b></div>
        </div>
        
    </body>
</html>
