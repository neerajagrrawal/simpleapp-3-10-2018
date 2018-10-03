<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="theme.css" type="text/css"> </head>

<body class="" style="background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoi6zyyBYFqq1Iyc_eaUKkOiu0Qg3KWrTacIljtYSIOTllDKln');background-size:cover;" >
  <%@ include file="header.jsp" %>
  <div class="py-5 h-25">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="display-4 text-center text-light">ACCOUNT DETAILS</h1>
        </div>
      </div>
    </div>
  </div>
  <div class="p-3">
    <div class="container">
      <div class="row w-100">
        <div class="col-md-3 px-2 mx-0">
          <div class="card w-75 mx-4">
            <img class="card-img img-fluid" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3hxlMTZaZDlfpC52sMwb_oywEUePI7eAJs2--mLvFPDDfSXZK" alt="Card image" height="200px"> </div>
        </div>
        <div class="col-md-6 mx-0 px-4">
          <table class="table text-light">
            <thead>
              <tr>
                <th>1</th>
                <th>Full Name</th>
                <th>${sessionScope.customer.customerName}</th>
              </tr>
            </thead>
            <tbody class="">
              <tr>
                <td>2</td>
                <td>Account Id&nbsp;</td>
                <td>${sessionScope.customer.account.accountId}</td>
              </tr>
              <tr>
                <td>3</td>
                <td>Account Type</td>
                <td>${sessionScope.customer.account.accountType}</td>
              </tr>
              <tr>
                <td>4</td>
                <td>Balance</td>
                <td>${sessionScope.customer.account.balance}</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class=""></div>
      </div>
    </div>
  </div>
  <div class="text-center p-1">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <a class="btn btn-dark text-light" href="transferMoneyPage">Transfer Money</a>
        </div>
      </div>
    </div>
  </div>
  
  </pingendo>
</body>

</html>