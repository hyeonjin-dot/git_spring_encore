package org.example;

import mvc.service.utill.MvcService;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/index.encore")
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("debug >> org.example.IndexController doGet()");
        RequestDispatcher view = request.getRequestDispatcher("./main.jsp");
        view.forward(request, response); // servlet으로 들어온  req res를 jsp로 전달
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}*/

public class IndexController implements Controller{

    private  MvcService service;

    public IndexController() {
    }
    public IndexController(MvcService service) {
        this.service = service;
    }

    @Override
    public View execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("index controller execute");
        View view = new View();
        view.setFlag(true);
        view.setResponseJsp("./main.jsp");
        return view;
    }
}