<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

 
  
  <link rel="stylesheet" type="text/css" href="css/module.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Domotics Welcome Page</title>
  <script src="js/d3.js" charset="utf-8"></script>
  <style>
      
     
    .background {
          position: fixed;
          top: 0;
          left: 0;
          right: 0;
           bottom: 0;
           background:url("http://science-all.com/images/wallpapers/home-wallpaper/home-wallpaper-6.jpg") no-repeat center center fixed;
          -webkit-background-size: cover;
          -moz-background-size: cover;
          -o-background-size: cover;
          background-size: cover;
          height: 100%; /* or change accordingly - not quite clear in question */
          width: 100%;
          background-color: #131516 !important;
    }
      @media only screen and (max-width:480px) { 
                 .bt {
                 width:75%;
                
                    }
            }
  </style>
</head>
<div class="background">
<body>
  <h1 class="jumbotron" style="background-color:blue; opacity:.7; text-align: center" >Home Control Center</h1>
  
  <form action="/Switch" method="post" style="margin-bottom: 7px" >
        <input style="margin-left:10px" class="btn-lg btn-success bt" type="submit" value="Turn On Device" name="on"/>
</form>
  </form>
  
  <form action="/Switch" method="post" style="margin-bottom: 7px">
        <input style="margin-bottom:10px; margin-left:10px" class="btn-lg btn-info bt" type="submit" value="Turn Off Device" name="on">
  </form>

  
	<%-- <c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br>
	JSTL URL: ${url}
	<br> --%>
	
	
	
 <%--<script>
	var holder = d3.select("body") // select the 'body' element
    .append("svg")           // append an SVG element to the body
    .attr("width", 449)      // make the SVG element 449 pixels wide
    .attr("height", 249);    // make the SVG element 249 pixels high

//draw a circle
holder.append("circle")        // attach a circle
  .attr("cx", 200)           // position the x-center
  .attr("cy", 100)           // position the y-center
  .attr("r", 100).style("fill", "silver");            // set the radius
  
  holder.append("text")         // append text
  .style("fill", "black")   // fill the text with the colour black
  .attr("x", 200)           // set x position of left side of text
  .attr("y", 100)           // set y position of bottom of text
  .attr("text-anchor", "middle") // set anchor y justification 
  .text("${message}");          // define the text to display  
  
</script> --%>

</body>
</div>
</html>