<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="theme.css" type="text/css"> </head>

<body class="" style="background-image: url('https://motionarray.imgix.net/preview-86316-Fzhsm5Qo04-high_0014.jpg?w=750&amp;q=60&amp;fit=max&amp;auto=format');background-size:cover;">
    <%@ include file="header.jsp" %>
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-3"> </div>
        <div class="col-md-6">
          <div class="card text-white p-5 bg-transparent bg-light">
            <div class="card-body bg-dark">
              <h1 class="mb-4 text-light">Transfer Money</h1>
              <form action="transferMoney" method="post" class="text-left">
                <div class="form-group">
                  <label class="">Account Id</label>
                  <input type="number" class="form-control" placeholder="Enter Account ID" name="toAccountId"> </div>
                <div class="form-group">
                  <label class="">Amount</label>
                  <input type="number" class="form-control" placeholder="Enter Amount (Rs)" name="amount"> </div>
                <div class="form-row text-center">
                  <div class="col-12">
                    <button type="submit" class="btn btn-dark">Transfer</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <img src="https://pingendo.com/site-assets/Pingendo_logo_big.png" class="d-block" alt="Pingendo logo" height="16"> </body>

</html>