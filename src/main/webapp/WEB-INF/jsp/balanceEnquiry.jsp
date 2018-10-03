
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Enquiry</title>
</head>
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

<h3><div id="abc">
Name: ${sessionScope.customer.customerName}</div>

<div id="abc">
Account Id: ${sessionScope.customer.account.accountId}</div>


<div id="abc">
Balance: ${sessionScope.customer.account.balance}</h3></div>
<%@ include file = "footer.jsp" %>
</body>
</html>