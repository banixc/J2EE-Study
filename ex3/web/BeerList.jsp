<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="beer" class="com.banixc.study.j2ee.lesson.ex3.Beer" scope="request"/>
<jsp:setProperty name="beer" property="*"/>

<%
    if (beer.getColor().equals("amber")) {
%>
<jsp:forward page="ShowAmberBeer.jsp"/>
<% }
    if (beer.getColor().equals("brown")) {
%>
<jsp:forward page="ShowBrownBeer.jsp"/>
<% }
    if (beer.getColor().equals("dark")) {
%>
<jsp:forward page="ShowDarkBeer.jsp"/>
<% }
%>
<jsp:include page="Header_act.jsp">
    <jsp:param name="subTitle" value="Welcome to the ${beer.color} Beer World!"/>
</jsp:include>
<%@ include file="DisplayItem.jsp" %>