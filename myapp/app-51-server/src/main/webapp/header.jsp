<%@ page 
    language="java" 
    contentType="text/html;charset=UTF-8" 
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ page import="bitcamp.myapp.vo.User"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='UTF-8'>
    <title>Title</title>
    <link href='/css/common.css' rel='stylesheet'>
</head>
<body>

<header>
  <a href='/'><img src='/images/home.png'></a>
  <h1>프로젝트 관리 시스템</h1>
  <nav>
    <ul>
      <li class='btn btn-default'><a href='/user/list'>회원</a></li>
      <li class='btn btn-default'><a href='/project/list'>프로젝트</a></li>
      <li class='btn btn-default'><a href='/board/list'>게시글</a></li>
    </ul>
  </nav>
<%
User loginUser = (User) ((HttpServletRequest) request).getSession().getAttribute("loginUser");
%>
  <div class='login-state pos-right'>
<%if (loginUser == null) {%>
    <a href='/auth/login' class='btn btn-primary'>로그인</a>
<%} else {%>
    <a href='/user/view?no=<%=loginUser.getNo()%>' class='btn btn-light'><%=loginUser.getName()%></a>
    <a href='/auth/logout' class='btn btn-secondary'>로그아웃</a>
<%}%>
  </div>

</header>