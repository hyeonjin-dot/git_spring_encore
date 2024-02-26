package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/test.encore")
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("debug >> org.example.TestController doGet()");
        /*PrintWriter out = response.getWriter();
        out.print("<div align=\"center\">Web Application Programming(Servlet/JSP)</div>"); // 화면에 출력
        out.close();*/
        //response.sendRedirect("./test.jsp");

//        RequestDispatcher view = request.getRequestDispatcher("./test.jsp");
//        view.forward(request, response); // servlet으로 들어온  req res를 jsp로 전달
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}