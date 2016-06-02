

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="css/module.css">
<script src="js/d3.js" charset="utf-8"></script>
<style>
body  {
    background-image: url("http://jhwallpaper.com/wp-content/uploads/2016/04/Amazing-Wallpapers-2OT.jpg");
    -moz-background-size: cover;
    -webkit-background-size: cover;
    background-size: cover;
    background-position: top center !important;
    background-repeat: no-repeat !important;
    background-attachment: fixed;
}
</style>
</head>
<body id="body">
  
  <script>
            var req="${req}";
            if (req=="Turn On Device"){
              document.getElementById("body").innerHTML = "Device has been enabled";
            }else {document.getElementById("body").innerHTML = "Device has been disabled";}
            
  </script>
</body>
</html>