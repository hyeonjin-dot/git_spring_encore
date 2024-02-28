package mvc.user.ctrl;

import mvc.domain.dto.RequestUserDto;
import mvc.domain.dto.ResponseUserDto;
import mvc.service.utill.MvcService;
import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//controller 역할
// 1. 파라미터가 있으면 값을 전달받고 이걸 DTO 바인딩한다.
// 2. DTO객체를 service에 전달하여 특정 결과를 반환받는다.
// 3. 전달받은 값을 jsp에 출력한다면, 데이터를 request 혹은 session에 심는다.
// 4. View 객체를 통해 분기 방식과 렌더링될 페이지 정보를 front-controller에 전달
public class LoginCtrl implements Controller {

    private MvcService service;

    public LoginCtrl(){}
    public LoginCtrl(MvcService service){
        this.service = service;
    }

    public View execute(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Login Ctrl");
        //브라우저로부터 전달된 정보는 request에 들어있고, getParameter() 이용해서 값을 얻을 수 있다.
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        System.out.println("param id : " + id);
        System.out.println("param pwd : " + pwd);

        RequestUserDto params = new RequestUserDto(id, pwd);
        //서비스로부터 반환 받은 값
        ResponseUserDto user = service.login(params);
        View view = new View();

        if (user != null){
            request.setAttribute("user", user);
            view.setFlag(true);
            view.setResponseJsp("./ok.jsp");
            return view;
        }else{
            view.setFlag(true) ;
            view.setResponseJsp("./error.jsp");
            return view ;
        }

    }
}
