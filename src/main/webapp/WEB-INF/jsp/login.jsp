<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="iciciHomeTheme.css" type="text/css"> </head>

<body class="" style="background-image: url('https://motionarray.imgix.net/preview-86316-Fzhsm5Qo04-high_0014.jpg?w=750&amp;q=60&amp;fit=max&amp;auto=format');background-size:cover;">
  <%@ include file="header.jsp" %>
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-3"> </div>
        <div class="col-md-6">
          <div class="card text-white p-5 bg-transparent bg-light">
            <div class="card-body bg-dark">
              <h1 class="mb-4 text-light">Login form</h1>
              <form:form action="authenticate" method="post" modelAttribute="customer">
                <div class="form-group">
                  <form:label class="" path="customerId">Customer ID</form:label>
                  <form:input type="number" class="form-control" placeholder="Enter Customer ID" path="customerId"></form:input> </div>
                <form:errors path="customerId" cssClass = "error" />
                <div class="form-group">
                  <form:label class="" path="password">Password</form:label>
                  <form:input type="password" class="form-control" placeholder="Password" path="password"></form:input> </div>
               <form:errors path="password" cssClass = "error" />
                <div class="form-row text-center">
                  <div class="col-12">
                    <button type="submit" class="btn btn-dark">Login</button>
                  </div>
              </form:form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  </pingendo>
</body>

</html>