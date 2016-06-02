

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
  <link rel="stylesheet" type="text/css" href="css/module.css">
  <title>Device Response</title>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">

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
<body >

<h1 id="res" class="jumbotron" style="background-color:blue; opacity:.65" style="text-align: center"></h1>
  
  <script>
            var req="${req}";
            if (req=="Turn On Device"){
              document.getElementById("res").innerHTML = "Device has been enabled";
            }else {document.getElementById("res").innerHTML = "Device has been disabled";}
            
  </script>
  
</body>
</html>