<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	//쿠키에 아이디가 있으면 세션으로 빼온다.
	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("id")) {
				String id = cookie.getValue();
				session.setAttribute("id", id);
			}
		}
	}
	
	String id = (String)session.getAttribute("id");
%>

<header>
    <div class="home-line">
        <h1><a href="index.do">Home</a></h1>
        <!-- 세션으로 빼온 아이디가 있으면 -->
<%
			if (id != null) {
%>
        		${ id } 님 반갑습니다.&nbsp;
        		<a href="myPage.do">마이페이지</a>&nbsp;
        		<a href="logoutPro.do">로그아웃</a>
<%
			} else {
%>
        	<!-- 세션으로 빼온 아이디가 없으면 -->
        		 <a href="login.do">로그인&nbsp;</a>
<% 
			}
%>        		 
        
    </div>
    <div class="menu">
        <a href="intro.do">소개</a>                 
        <a href="schedule.do">일정</a>
        <a href="information.do">정보</a>
        <a href="board.do">게시판</a>
    </div>
</header>