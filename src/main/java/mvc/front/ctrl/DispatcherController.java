package mvc.front.ctrl;
import mvc.bean.factory.BeanFactory;
import mvc.service.utill.MvcService;
import mvc.service.utill.MvcServiceImpl;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("*.hanwha")
public class DispatcherController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontController process");
        System.out.println("client request path : " + request.getRequestURL());
        BeanFactory factory = BeanFactory.getInstance();
        Controller ctrl = factory.getCtrl(request.getRequestURI());
        View view = ctrl.execute();
        if (view.isFlag()){
            RequestDispatcher rd = request.getRequestDispatcher(view.getResponseJsp());
            rd.forward(request, response); // 주소값 *.hanwha 그대로
        }else{
            response.sendRedirect(view.getResponseJsp()); //주소 입력한 값으로 변경
        }
    }
}