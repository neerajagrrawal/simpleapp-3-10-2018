<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="/css/iciciHomeTheme.css" type="text/css"> </head>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
  
<body class="">
  <nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="#">
        <i class="fa d-inline fa-lg fa-cloud"></i>
        <b>SNTV-BANK</b>
      </a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse text-center" id="navbar2SupportedContent">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="/">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <c:if test = "${empty sessionScope.customer.customerName}">
          <li class="nav-item">
            <a class="nav-link" href="loginPage">Edit Profile</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="loginPage">Dashboard</a>
          </li>
        </ul>
        <ul class="navbar-nav mr-auto">
          <li class="nav-item ">
            <a class="nav-link" href="about.jsp">
              <i class="fa d-inline fa-lg fa-bookmark-o"></i>About</a>
          </li>
          
          </c:if>
          
          
          <c:if test = "${not empty sessionScope.customer.customerName}">
          <li class="nav-item">
            <a class="nav-link" href="editProfilePage">Edit Profile</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="dashboard">Dashboard</a>
          </li>
        </ul>
        <ul class="navbar-nav mr-auto">
          <li class="nav-item ">
            <a class="nav-link" href="about.jsp">
              <i class="fa d-inline fa-lg fa-bookmark-o"></i>About</a>
          </li>
          
          </c:if>
          
          
          
          
          
          
          
          
          
          
          
        </ul>
        
        <c:set var = "username" scope = "session" value = "${sessionScope.customer.customerName}"/>
        <c:if test = "${empty sessionScope.customer.customerName}">
        <a class="btn navbar-btn ml-2 text-white btn-dark" href="loginPage">
          <i class="fa d-inline fa-lg fa-user-circle-o"></i> Sign in</a>
          </c:if>
          
          <c:if test = "${not empty sessionScope.customer.customerName}">
          Welcome,${sessionScope.customer.customerName}
          <a class="btn navbar-btn ml-2 text-white btn-dark" href="logoutSession">
          <i class="fa d-inline fa-lg fa-user-circle-o"></i> Log Out</a>
          </c:if>
      </div>
    </div>
  </nav>