package com.tour.controller.ticketing;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tour.controller.Action;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteAction");
		
		//로그인정보
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		//로그인 안하면 게시판 사용불가
		if(id == null) {	
			response.setContentType("text/html; charset=utf-8");
			response.setCharacterEncoding("utf-8");			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인 후 사용 가능합니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.close();	
			return null;
		}
		
		return "ticketing/write";
	}
	
}
