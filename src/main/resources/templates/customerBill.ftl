<!DOCTYPE HTML>
<html lang="en">
<head> 
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>My Bill</title>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/bill.css">
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
        <h3 id="packageSectionTitle" class="panel-title">Your Sky Package</h3>
      </div>
      <div class="panel-body">
        <table id="packageDetails" class="table table-striped">
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
      <div id="packageCost" class="panel-footer">Sky package total: ${packageTotal?string.currency}</div>
    </div>
    
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 id="callChargesTitle" class="panel-title">Call Charges</h3>
      </div>
      <div class="panel-body">
        <table id="callCharges" class="table table-striped">
          <thead>
            <tr>
              <th>Called</th>
              <th>Duration</th>
              <th>Cost</th>
            </tr>
          </thead>
          <tbody>
          <#list calls as callDetail>
             <tr>
               <td>${callDetail.called}</td>
               <td>${callDetail.duration}</td>
               <td>${callDetail.cost?string.currency}</td>
             </tr>
           </#list>
          </tbody>
        </table>
      </div>
      <div id="callCost" class="panel-footer">Call charges total: ${callTotal?string.currency}</div>
    </div>
      
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 id="storeTitle" class="panel-title">Sky Store Charges</h3>
      </div>
      <div class="panel-body">
        <row>
          <div class="col-md-6">
            <h4 id="rentalsTitle">Rentals</h4>	
            <table id="rentals" class="table table-striped">
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Cost</th>
                </tr>
              </thead>
              <tbody>
              <#list rentals as rentalItem>
                <tr>
                  <td>${rentalItem.title}</td>
                  <td>${rentalItem.cost}</td>
                </tr>
              </#list>
              </tbody>
            </table>
          </div>
        
          <div class="col-md-6">
            <h4 id="buyTitle">Buy and Keep</h4>	
 	        <table id="buyAndKeep" class="table table-striped">
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Cost</th>
                </tr>
              </thead>
              <tbody>
              <#list buyAndKeep as purchasedItem>
                <tr>
                  <td>${purchasedItem.title}</td>
                  <td>${purchasedItem.cost}</td>
                </tr>
              </#list>
              </tbody>
            </table>
          </div>
        </row>  
        
      </div>
      <div id="storeCost" class="panel-footer">Sky store total: ${storeTotal?string.currency}</div>
    </div>  
    
  </div> <!-- /container -->
</body>
</html>
