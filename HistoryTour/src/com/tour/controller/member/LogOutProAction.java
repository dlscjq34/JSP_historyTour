package com.tour.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tour.controller.Action;

public class LogOutProAction implements Action {	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LogOutProAction");
		
		//세션 삭제
		HttpSession session = request.getSession();
		session.invalidate();
		
		//쿠키 삭제
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("id"));
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
		}
		
		//로그아웃 표시
		response.setContentType("text/html charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out = response.getWriter();				
		out.print("<script>");
		out.print("alert('로그아웃 되었습니다.');");
		out.print("location.href='index.do'");
		out.print("</script>");
		out.close();
		
		return null;
	}
	
}
