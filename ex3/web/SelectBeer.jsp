<%--
  Created by IntelliJ IDEA.
  User: Banixc
  Date: 2016/10/8
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!--import a java package -->
<%@ page import="com.banixc.study.j2ee.lesson.ex3.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! int kinds = 4; %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Select a color for beer!</title>
</head>
<body>
<%@ include file="Header_ins.jsp" %>
<h1 align="center">Beer Selection Page</h1>
<!-- Commit to a Servlet Page -->
<!-- form method="POST" action="SelectBeer.do" -->
<!-- Commit to a JSP Page -->
<form method="POST" action="BeerList.jsp">
    You have selected the beer characteristics for
    <%=StatisticInfo.getCount()%>.<p>
    There are <% out.print(kinds); %> kinds of beer for choose.<p>
    <select name="color" size="1">
        <option>light
        <option>amber
        <option>brown
        <option>dark
    </select>
    <div style="text-align: center;">
        <input type="SUBMIT" value="Submit">
    </div>
</form>

</body>
</html>
