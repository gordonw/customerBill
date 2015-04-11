<!DOCTYPE HTML>
<html lang="en">
<head> 
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>My Bill</title>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> 

  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
  
  <div id="totalDue" class="alert alert-info" role="alert">
    Total due on ${dueDate}: <strong class="pull-right">${totalDue?string.currency}</strong>
  </div>
  
  
  </div> <!-- /container -->
</body>
</html>
