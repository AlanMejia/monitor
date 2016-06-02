

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="css/module.css">
<script src="js/d3.js" charset="utf-8"></script>
<style>
body  {
    background-image: url("http://science-all.com/images/wallpapers/home-wallpaper/home-wallpaper-6.jpg");
    background-color: #cccccc;
}
</style>
</head>
<body id="body">
  <c:out value="${req}" escapeXml="false"/><br>
  <script>
            var req="${req}";
            if (req=="Device Turn On"){
              document.getElementById("body").innerHTML = "Device has been enabled";
            }else {document.getElementById("body").innerHTML = "Device has been disabled";}
  </script>
</body>
</html>