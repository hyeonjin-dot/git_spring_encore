<%@ page 	language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"%>
<%@ page 	import="mvc.domain.dto.ResponseUserDto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<%@ include file="./common/header.jsp" %>
<div align="center">
    Hanwha SW 5th Camp landing page
</div>
<p/>
<%!
    private ResponseUserDto user ;
%>
<%
    user = (ResponseUserDto)session.getAttribute("user");
    if(user == null ) {
%>
<div align = "right">
    <form method = "post"  action = "login.hanwha" >
        <input type="text" 		name="id" >
        <input type="password" 	name="pwd" >
        <input type="submit" value="login">

        &nbsp;&nbsp;
        <a href="join.encore" class="btn primary">JOIN</a>
    </form>
</div>
<%
} else {
%>
<div align = "right">
    <%= user.getName() %>님 환영합니다.
    &nbsp;&nbsp;
    <a href="logout.hanwha">로그아웃</a>

</div>
<%
    }
%>
<hr/>
<ul>
    <li><a href="./select/select.hanwha">전체출력</a> </li>
</ul>
<%@ include file="./common/footer.jsp"%>
</body>
</html>