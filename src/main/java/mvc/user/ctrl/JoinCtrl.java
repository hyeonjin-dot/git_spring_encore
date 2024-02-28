package mvc.user.ctrl;

import mvc.service.utill.MvcService;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinCtrl implements Controller {
    private MvcService service;

    public JoinCtrl(){}

    public JoinCtrl(MvcService service){
        this.service = service;
    }
    public View execute(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Join Ctrl");
        service.join();
        View view = new View();
        view.setFlag(true) ;
        view.setResponseJsp("./join/join.jsp");
        return view ;
    }
}
