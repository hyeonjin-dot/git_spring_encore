package mvc.user.ctrl;

import mvc.domain.dto.ResponseUserDto;
import mvc.service.utill.MvcService;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelectCtrl implements Controller {

    private MvcService service;

    public SelectCtrl(){}
    public SelectCtrl(MvcService service){
        this.service = service;
    }
    @Override
    public View execute(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("select Ctrl");
        List<ResponseUserDto> list = service.select();
        for (ResponseUserDto dto : list) {
            System.out.println(dto.toString());
        }

        //데이터 심기
         request.setAttribute("list", list);

        View view = new View();
        view.setFlag(true) ;
        view.setResponseJsp("../list/list.jsp"); //임의로
        return view;
    }
}
