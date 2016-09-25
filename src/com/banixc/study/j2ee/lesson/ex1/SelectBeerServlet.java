package com.banixc.study.j2ee.lesson.ex1;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/ex1/select")
public class SelectBeerServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException { 
		String colorParam = request.getParameter("color");
        //根据不同的Color进行不同的处理
        switch (colorParam) {
            case "brown":
                //重定向到/ex1/brown 不保留原请求参数 重新请求
                response.sendRedirect("brown");
                break;
            case "dark":
                //重定向到/ex1/dark 保留原请求参数 URL不变
                request.getRequestDispatcher("dark").forward(request,response);
                break;
            default:
                break;
        }


		PrintWriter out = response.getWriter();
		out.println("<html> " + "<body>"
				+ "<h1 align=center>Beer Color</h1>" + "<br>"
				+ "My selected beer color is: " + colorParam + "</body>" + "</html>");
	}
}
