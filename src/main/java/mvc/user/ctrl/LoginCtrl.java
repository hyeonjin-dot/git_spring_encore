package mvc.user.ctrl;

import mvc.service.utill.MvcService;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

public class LoginCtrl implements Controller {

    private MvcService service;

    public LoginCtrl(){}

    public LoginCtrl(MvcService service){
        this.service = service;
    }
    public View execute(){
        View view = new View();
        view.setFlag(false) ;
        view.setResponseJsp("./login/login.jsp");
        return view ;
    }
}
