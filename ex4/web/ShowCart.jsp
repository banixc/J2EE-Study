<%--
  Created by IntelliJ IDEA.
  User: Banixc
  Date: 2016/10/30
  Time: 15:11
  ??????????
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>

<c:forEach var="beer" items="${paramValues.item}">
    <c:set var="beerList" scope="session" value="${beerList}, ${beer} "/>
</c:forEach>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ShoppingCart</title>
</head>
<body>
<h4>Item:</h4><hr><br><br>
<c:forEach var="beer" items="${beerList}">
    ${beer}<hr />
</c:forEach>
</body>
</html>