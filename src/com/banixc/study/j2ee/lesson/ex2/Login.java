package com.banixc.study.j2ee.lesson.ex2;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/ex2/Login.do")
public class Login extends HttpServlet {

    private static final String REMEMBER = "remember";

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        boolean remember = REMEMBER.equals(req.getParameter("remember"));

        int judge = 0b000;
        Cookie cookies[] = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    cookie.setValue(name);
                    judge |= 0b001;
                }
                if (cookie.getName().equals("password")) {
                    if(remember) {
                        cookie.setValue(password);
                        judge |= 0b010;
                    } else {
                        cookie.setValue(null);
                    }
                }
                if (cookie.getName().equals("remember")) {
                    if(remember) {
                        cookie.setValue(REMEMBER);
                        judge |= 0b100;
                    } else {
                        cookie.setValue(null);
                    }
                }
            }
        }

        //新建name
        if (0 == (judge & 0b001)) {
            addCookie(res, "name", name);
        }

        //新建password
        if (0 == (judge & 0b010)) {
            addCookie(res, "password", password);
        }

        //新建remember
        if (0 == (judge & 0b100)) {
            addCookie(res, "remember", REMEMBER);
        }

        doGet(req,res);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String name = null;
        String password = null;
        String remember = null;

        Cookie cookies[] = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
                if (cookie.getName().equals("remember")) {
                    remember = cookie.getValue();
                }
            }
        }

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        out.println("<html>");
        out.println("<title>");
        out.println("User list");
        out.println("</title>");
        out.println("<body><h4>User List:</h4><hr><br>");
        printKey(out, "name", name);
        printKey(out, "password", password);
        printKey(out, "remember", remember);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    private void addCookie(HttpServletResponse res, String name, String value){
        Cookie cookie = new Cookie(name, value);
        //不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
        cookie.setMaxAge(24 * 60 * 60);
        res.addCookie(cookie);
    }

    private void printKey(PrintWriter out, String key, String value) {
        if(null == value) value = "NULL";
        out.print(key + ": " + value + "<br>");
    }
}