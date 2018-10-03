<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="iciciHomeTheme.css" type="text/css">
  <script type="text/javascript">
function myFunction() {
    var pass1 = document.form.newPassword.value;
    var pass2 = document.form.confirmNewPassword.value;
    var ok = true;
    if (pass1 != pass2) {
    	window.alert("Passwords do not match");
    	return false ;
    }
    
    return ok;
}
</script>
  
   </head>

<body class="" style="background-image: url('https://motionarray.imgix.net/preview-86316-Fzhsm5Qo04-high_0014.jpg?w=750&amp;q=60&amp;fit=max&amp;auto=format');background-size:cover;">
  <%@ include file="header.jsp" %>
  
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-3"> </div>
        <div class="col-md-6">
          <div class="card text-white p-5 bg-transparent bg-light">
            <div class="card-body bg-dark">
              <h1 class="mb-4 text-light">Update Password</h1>
              <form action="updatePassword" method="post" name="form" onSubmit="return myFunction()">
                <div class="form-group">
                  <label class="">Old Password</label>
                  <input type="password" class="form-control" placeholder="Old Password" name="oldPassword"> </div>
                <div class="form-group">
                  <label class="">New Password</label>
                  <input type="password" class="form-control" placeholder="New Password" name="newPassword"> </div>
                  <div class="form-group">
                  <label class="">Confirm New Password</label>
                  <input type="password" class="form-control" placeholder="Confirm New Password" name="confirmNewPassword"> </div>
                  
                <div class="form-row text-center">
                  <div class="col-12">
                    <button type="submit" class="btn btn-dark">Update</button>
                  </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  </pingendo>
</body>

</html>