package com.banixc.study.j2ee.lesson.ex1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", urlPatterns={"/ex1/test"}, initParams = {@WebInitParam(name = "InitParamsName", value = "InitParamsValue", description = "Default")})
public class TestInitParams extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("ContextParams:" + getServletContext().getInitParameter("TestContextParams"));
        out.println("InitParams:" + getInitParameter("InitParamsName"));
    }
}
