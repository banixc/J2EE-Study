<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Banixc
  Date: 2016/11/5
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="item" items="${param.item}">
    <c:set var="beerList" scope="session" value="${beerList}, ${item} " />
</c:forEach>
<h1>
<c:forEach var="item" items="${beerList}">
    ${item}<hr />
</c:forEach>
</h1>