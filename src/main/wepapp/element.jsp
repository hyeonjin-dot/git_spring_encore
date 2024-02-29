<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="mvc.model.dao.MariaDao" %>
<%@page import="mvc.domain.dto.RequestUserDto" %>
<%@page import="mvc.domain.dto.ResponseUserDto" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title name</title>
</head>
<body>
    <%-- jsp 주석 --%>
    <%-- 선언문 (변수, 메서드) --%>
    <%-- 멤버 변수 선언 --%>
    <%!
        private MariaDao dao;
        private RequestUserDto params;
        private ResponseUserDto user;

        private String msg;
    
        public void  setMsg(String msg){
            this.msg = msg;
        }
    
        public String getMsg(){
            return this.msg;
        }
    %>
    <%-- Scriptlet tag (서블릿의 메서드(doGet | doPost))
        사용자가 jsp를 호출하게 되면 수행되는 영역
        doGet(HttpServeltRequest request, HttpServletResponse response){}
     --%>
    <%-- 지역변수 선언 --%>
    <%
        dao = new MariaDao();
        params = new RequestUserDto("encore", "encore");
        user = dao.loginRow(params);

        setMsg("집에 가고 싶다.");
        out.print("<div align='center'>");
        out.print(getMsg());
        out.print("</div>");
    %>
    <%-- 표현식 태그(out.print()) --%>
    <%= user.getName() %>님 환영합니다.
</body>
</html>