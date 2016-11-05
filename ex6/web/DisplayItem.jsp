<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="MyFirstTag" prefix="mytag"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beer List</title>
</head>
<body>
<c:set var="sessionList" scope="session" value="${sessionList}, ${param.color} " />
<h1 align="center">The beer corlor that you selected is ${param.color}.</h1>
<b><a href="SelectedBeerColor.jsp">(View the selected beer colors).</a></b>
<p><b>Choose following information:</b></p>
<%--<form method="post" action="ShoppingCart.do">--%>
<form method="post" action="ShopCart.jsp">
  <table width="500" border="0" cellspacing="0" cellpadding="0">
    <mytag:beerList color="${param.color}" />
  </table>
  <hr>
  <p>
  <center> 
    <input type="submit" name="btn_submit" value="Buy Now">
  </center>
</form>
</body>
</html>