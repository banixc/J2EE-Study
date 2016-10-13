package com.banixc.study.j2ee.lesson.ex1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/code")
public class CodeReturn extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("application/jar");
        ServletContext ctx = getServletContext();
        InputStream is = ctx.getResourceAsStream("resources/bookCode.jar");

        //修改下载的文件名称
        String name = "bookCode.jar";
        response.addHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");

        int read;
        byte[] bytes = new byte[1024];
        OutputStream os = response.getOutputStream();
        while ((read = is.read(bytes)) != -1) {
            os.write(bytes, 0, read);
        }
        os.flush();
        os.close();
    }
}
