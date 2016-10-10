<%--
  Created by IntelliJ IDEA.
  User: Banixc
  Date: 2016/10/8
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    Integer itemCount=(Integer)session.getAttribute("itemCount");
    //如果session是新的
    if (itemCount==null)
        itemCount= 0;

    String[] itemsSelected;
    itemsSelected=request.getParameterValues("item");

    if(itemsSelected !=null) {

        for (String item : itemsSelected) {
            itemCount = itemCount + 1;
            //购买的条目
            session.setAttribute("item" + itemCount, item);
            //总条目
            session.setAttribute("itemCount", itemCount);
        }
    }
%>
<html>
<title>item list</title>
<body><h4>Session List:</h4><hr><br><br>
<%
    for(int i = 1; i<= itemCount; i++){
        out.print(session.getAttribute("item"+i)+"<hr />");
    }
%>
</body>
</html>
