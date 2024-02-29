package mvc.user.ctrl;

import mvc.user.ctrl.util.Controller;
import mvc.util.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
사용자의 명시적인 로그아웃이 요청되면
사용자 브라우저에 부여한 모든 세션을 클리어 시키는 역할
 */
public class LogoutCtrl implements Controller {
    @Override
    public View execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("logoutCtrl");
        HttpSession session = request.getSession(false);
        session.invalidate();
        View view = new View();
        view.setFlag(true);
        view.setResponseJsp("./index.jsp");
        return view;
    }
}
