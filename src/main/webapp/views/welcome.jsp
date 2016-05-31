<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="css/module.css">
<script src="js/d3.js" charset="utf-8"></script>
<style>
body  {
    background-image: url("http://www.hdwallpapersnew.net/wp-content/uploads/2015/03/red-flowers-hd-wallpapers-new-best-roses-images-background-download-free.jpg");
    background-color: #cccccc;
}
</style>
</head>
<body>

	<%-- <c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br>
	JSTL URL: ${url}
	<br> --%>
	
	
	
<script>
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
  
</script>
</body>
</html>