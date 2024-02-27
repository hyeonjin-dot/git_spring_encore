package mvc.user.ctrl;

import mvc.service.utill.MvcService;
import mvc.service.utill.MvcServiceImpl;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

public class DeleteCtrl implements Controller {

    private MvcService service;

    public DeleteCtrl(){}

    public DeleteCtrl(MvcService service){
        this.service = service;
    }
    public View execute(){
        View view = new View();
        view.setFlag(true) ;
        view.setResponseJsp("./delete/delete.jsp");
        MvcServiceImpl impl = new MvcServiceImpl();
        impl.delete();
        return view ;
    }
}
//왜 객체가 사라져