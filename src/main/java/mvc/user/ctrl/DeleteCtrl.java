package mvc.user.ctrl;

import mvc.service.utill.MvcService;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCtrl implements Controller {

    private MvcService service;

    public DeleteCtrl(){}

    public DeleteCtrl(MvcService service){
        this.service = service;
    }
    public View execute(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Delete Ctrl");
        View view = new View();
        view.setFlag(true) ;
        view.setResponseJsp("./delete/delete.jsp");
        service.delete();
        return view ;
    }
}
//왜 객체가 사라져