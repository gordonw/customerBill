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
  
  <div class="page-header">
    <h1 id="billTitle">Current Bill</h1>
    <p id="statementDates">Generated on ${generatedDate} for bill period: ${fromDate} - ${toDate}</p>
  </div>
  
  <div id="totalDue" class="alert alert-info" role="alert">
    Total due on ${dueDate}: <strong class="pull-right">${totalDue?string.currency}</strong>
  </div>
  
  <div class="panel panel-default">
    <div class="panel-heading">
      <h3 class="panel-title" id="packageBreakdownTitle">Your Sky Package</h3>
    </div>
    <div class="panel-body">
      <table class="table table-striped" id="skyPackage">
        <thead>
          <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Cost</th>
          </tr>
        </thead>
        <tbody>
        <#list subscriptions as item>
          <tr>
            <td>${item.name}</td>
            <td>${item.type}</td>
            <td>${item.cost?string.currency}</td>
          </tr>
        </#list>
        </tbody>
      </table>	  
      </div>
     <div class="panel-footer" id="packageTotal">Sky package total: ${packageTotal?string.currency}</div>
  </div>
  
  
  
  
  
  </div> <!-- /container -->
</body>
</html>
