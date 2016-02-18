<%-- 
    Document   : MainPage
    Created on : Oct 27, 2015, 4:45:47 PM
    Author     : 779609
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
       <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>">
       <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
            
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
        <title>eServices Monitor Main Page</title>
        
        <style>            
            body {
    -moz-background-size: cover;
    -webkit-background-size: cover;
    background-size: cover;
    background-position: top center !important;
    background-repeat: no-repeat !important;
    background-attachment: fixed;
}
            li{ 
                list-style-type: none;
                float:contour;
                margin-right: 1em;               
    
}

#spin{
    position:absolute;
    top:300px;
    margin-left: 470px;
    
}
#circles{height: auto; 
        width: auto; 
        max-width: 200px; 
        max-height: 200px;}

        </style>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>   
     
     <script> 
$(document).ready(function(){
        $('#spin').hide();
        $("ul").hide();
        $("ul").slideDown("slow");
        
        $('input').click(function(){
            $('#spin').show();
           
        });
         
    
});
</script>
    </head>
    <body background="<c:url value='/img/leaves.jpg' />"  >
        <header>
            <div class="container">
                <div class="jumbotron" style="background-color:darkblue; opacity:.8 ">   
                        <h1 style="color:black; text-align: center;"> eServices Monitor Main Page </h1>
                        <p style="color:white;  text-align: center; font-size:12px"><c:out value="${message}"/></p>
                </div>
            
         <nav>
            <ul>
                    <li><form action="/eServicesMonitor/controller/FMIController.do" method="post" style="margin-bottom: 7px">
                       <input class="btn btn-primary" type="submit" value="Check FMI's status">
                    </form></li>
                    <li><form action="/eServicesMonitor/controller/Tasks.do" method="post" style="margin-bottom: 7px">
                        <input class="btn btn-primary" type="submit" value="Check Tasks without values">
                    </form></li>
                    <li><form action="/eServicesMonitor/controller/OracleMaterials.do" method="post" style="margin-bottom: 7px">
                         <input class="btn btn-primary" type="submit" value="Check Oracle Materials missing Service Sheet">
                     </form></li>
                     <li><form action="/eServicesMonitor/controller/eServicesLanguage.do" method="post" style="margin-bottom: 7px">
                         <input class="btn btn-primary" type="submit" value="Check eServices Language (SPN)">
                     </form></li>
                     <li><form action="/eServicesMonitor/controller/ServiceSheetController.do" method="post" style="margin-bottom: 7px">
                         <input class="btn btn-primary" type="submit" value="Check Service Sheets with wrong Loco_ID">
                     </form></li>
                     <li><form action="/eServicesMonitor/controller/OpenTasks.do" method="post" style="margin-bottom: 7px">
                         <input class="btn btn-primary" type="submit" value="Check Open tasks for pended Service Sheets">
                     </form></li>
                     <li><form action="/eServicesMonitor/controller/Dashboard.do" method="post" style="margin-bottom: 0px">
                         <input class="btn btn-danger" type="submit" value="Show complete Dashboard">
                     </form></li>
            </ul>
            
             <div id="spin" >
                <img id="circles" style="opacity:.6; border-radius: 800px;"src="<c:url value='/img/spinner2.gif' />"> 
             </div>
         
                                 
           </nav>
                </div>
        </header>
                
                
               
                        
                       
        
            
        
    </body>
</html>
