<%@ page import="mvc.domain.dto.ResponseUserDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page errorPage="../error/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Insert title name</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
    <th scope="col">아이디</th><th scope="col">패스워드</th><th scope="col">이름</th>
    </thead>
</tr>
    <%!
        private List<ResponseUserDto> list;
        private ResponseUserDto user ;
    %>
    <%
        list = (ArrayList<ResponseUserDto>)request.getAttribute("list");
        user = (ResponseUserDto)session.getAttribute("user");
        if (list != null){
            for (int i = 0; i < list.size();i++){
    %>
    <tr>
        <td><%= list.get(i).getId() %></td>
        <td><%= list.get(i).getPwd() %></td>
        <td><%= list.get(i).getName() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>