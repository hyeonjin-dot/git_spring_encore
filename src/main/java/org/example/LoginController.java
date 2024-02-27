package org.example;

import test.domain.dto.TestDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login.encore")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("debug >> client uri : " + request.getRequestURI());
        System.out.println("debug >> client QueryString : " + request.getQueryString());
        System.out.println("debug >> client request method : " + request.getMethod());

        //한글 인코딩 작업을 해야 깨지지 않음
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        System.out.println(id + pwd);

        if (id.equals("encore") && pwd.equals("encore")){
            TestDTO param = new TestDTO();

            param.setId("encore");
            param.setPwd("encore");
            param.setName("엔코아");

            //scope는 forward 되어지는 페이지까지만 데이터를 유지할 수 있다.
            request.setAttribute("user", param);

            //session에 데이터 심기
            HttpSession session = request.getSession();
            session.setAttribute("user", param);
//            RequestDispatcher view = request.getRequestDispatcher("./ok.jsp");
//            view.forward(request, response);
            response.sendRedirect("./ok.jsp"); // 데이터 유지 안됌
        }else{
            RequestDispatcher view = request.getRequestDispatcher("./error.jsp");
            view.forward(request, response);
        }
    }
}