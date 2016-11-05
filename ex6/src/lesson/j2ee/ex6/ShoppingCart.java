package lesson.j2ee.ex6;

import lesson.j2ee.ex6.model.Beer;
import lesson.j2ee.ex6.model.BeerList;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ShoppingCart extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{

		//取得Session对象
		//如果Session不存在，为本次会话创建此对象
		HttpSession session =req.getSession(true);
		Integer itemCount=(Integer)session.getAttribute("itemCount");
		//如果session是新的
		if (itemCount==null)
			itemCount= 0;

		PrintWriter out=res.getWriter();
		res.setContentType("text/html");

		//接收传来的参数
		String[] itemsSelected;
		String itemName;
		itemsSelected=req.getParameterValues("item");

		if(itemsSelected !=null){
			for (String anItemsSelected : itemsSelected) {
				itemName = anItemsSelected;
				System.out.println(itemName);
				itemCount = itemCount + 1;
				//购买的条目
				session.setAttribute("item" + itemCount, itemName);
				//总条目
				session.setAttribute("itemCount", itemCount);
			}
		}

		BeerList list = new BeerList();

		for(int i = 1; i<= itemCount; i++){
			list.addBeer((String) session.getAttribute("item"+i));
		}


		out.println("<html>");
		out.println("<title>");
		out.println("item list");
		out.println("</title>");
		out.println("<body><h4>Session List:</h4><hr><br><br>");
		for(Beer beer:list) {
			out.println(beer.getName() + ": " + beer.getNum() +"<hr>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}