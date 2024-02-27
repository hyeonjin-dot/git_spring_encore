package mvc.user.ctrl;

import mvc.service.utill.MvcService;
import mvc.service.utill.MvcServiceImpl;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

public class JoinCtrl implements Controller {
    private MvcService service;

    public JoinCtrl(){}

    public JoinCtrl(MvcService service){
        this.service = service;
    }
    public View execute(){
        View view = new View();
        view.setFlag(true) ;
        view.setResponseJsp("./join/join.jsp");
        return view ;
    }
}
