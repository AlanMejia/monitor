

<!DOCTYPE html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
  <link rel="stylesheet" type="text/css" href="css/module.css">
  <title>Device Response</title>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
  
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
  <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
  <h1 id="res" class="jumbotron" style="background-color:burlywood; opacity:.7; text-align: center"> </h1>
  
  <script>
            var req="${req}";
            if (req=="Turn On Device"){
              document.getElementById("res").innerHTML = "Device has been enabled";
            }else {document.getElementById("res").innerHTML = "Device has been disabled";}
            
  </script>
  
</body>
</html>