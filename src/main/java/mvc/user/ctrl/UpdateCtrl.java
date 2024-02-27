package mvc.user.ctrl;

import mvc.service.utill.MvcService;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

public class UpdateCtrl implements Controller {

    private MvcService service;

    public UpdateCtrl(){}

    public UpdateCtrl(MvcService service){
        this.service = service;
    }
    public View execute(){
        View view = new View();
        view.setFlag(true) ;
        view.setResponseJsp("./update/update.jsp");
        return view ;
    }
}
