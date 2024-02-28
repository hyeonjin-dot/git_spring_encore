package mvc.user.ctrl;

import mvc.service.utill.MvcService;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCtrl implements Controller {

    private MvcService service;

    public UpdateCtrl(){}

    public UpdateCtrl(MvcService service){
        this.service = service;
    }
    public View execute(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Update Ctrl");
        service.update();
        View view = new View();
        view.setFlag(true) ;
        view.setResponseJsp("./update/update.jsp");
        return view ;
    }
}
