<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beer List</title>
</head>
<body>
<h1 align="center">A Beer List of the color you selected</h1>
<hr>
<b>You have selected the ${beer.color} Beer</b>
<p><b>Choose following information:</b></p>
<form method="post" action="SelectedBeerColor.jsp">
  <table width="500" border="0" cellspacing="0" cellpadding="0">
    <tr> 
      <td width="69"> 
        <input type="checkbox" name="item" value="The ${beer.color} beer of China">
      </td>
      <td width="431">Item1: The ${beer.color} beer of China</td>
    </tr>
    <tr> 
      <td width="69">
        <input type="checkbox" name="item" value="The ${beer.color} beer of France">
      </td>
      <td width="431">Item2: The ${beer.color} beer of France</td>
    </tr>
    <tr> 
      <td width="69">
        <input type="checkbox" name="item" value="The ${beer.color} beer of American">
      </td>
      <td width="431">Item3: The ${beer.color} beer of American</td>
    </tr>
  </table>
  <hr>
  <p>
  <div style="text-align: center;">
    <input type="submit" name="btn_submit" value="Buy Now">
  </div>
</form>
</body>
</html>