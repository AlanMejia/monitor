

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/module.css">
  <title>Device Response</title>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  
  <script src="js/d3.js" charset="utf-8"></script>
  <style>
      body  {
        background-image: url("http://api.ning.com/files/Z-JJSpQIZ69X*ewPhMFPeEdrnT67nhNhr4RMgGpSQAZ8FC58vTUR6EOOGanPLsQmVmUQskvjrb11bDCGfnbHpIfKTPnViGCV/mrbean.jpg");
        -moz-background-size: cover;
        -webkit-background-size: cover;
        background-size: cover;
        background-position: top center !important;
        background-repeat: no-repeat !important;
        background-attachment: fixed;
            }
  </style>
</head>
<body>

  <h1 id="res" class="jumbotron" style="background-color:burlywood; opacity:.7; text-align: center"> </h1>
  
  <script>
            var req="${req}";
            if (req=="Turn On Device"){
              document.getElementById("res").innerHTML = "Device has been enabled";
            }else {document.getElementById("res").innerHTML = "Device has been disabled";}
            
  </script>
  
</body>
</html>