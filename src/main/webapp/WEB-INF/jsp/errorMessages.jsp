<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<style>
#abc{
  font:Verdana, Geneva, sans-serif;
  font-size:18px;
  text-align:center;
  height:50px;
  line-height: 600px;
}
</style>
<%@ include file = "header.jsp" %>

<h3><div id="abc">${requestScope.exception.getMessage()}</h3>
<%@ include file = "footer.jsp" %>
</body>
</html>