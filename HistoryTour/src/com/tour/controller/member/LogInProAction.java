package com.tour.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tour.DAO.MemberDAO;
import com.tour.VO.MemberVO;
import com.tour.controller.Action;

public class LogInProAction implements Action {	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LogInProAction");
		
		String id = request.getParameter("id");
		String pswd = request.getParameter("pswd");
		String keepLogin = request.getParameter("keepLogin"); //쿠키에 사용자 정보 보관할지 판단
				
		
		
		MemberVO vo = MemberVO.getInstance();
		MemberDAO dao = MemberDAO.getInstance();		
		vo = dao.searchMember(id);		
		System.out.println("LogInProAction vo : "+vo);//test
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		
		if(vo == null) {	// 등록된 회원이 없을 시
			PrintWriter out = null;
			out = response.getWriter();				
			out.print("<script>");
			out.print("alert('아이디가 없습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			return null;
				
		}	
		else if(!pswd.equals(vo.getPswd())) {	// 등록된 회원이 있으나 암호가 다를 시
			PrintWriter out = null;
			out = response.getWriter();				
			out.print("<script>");
			out.print("alert('패스워드가 다릅니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			return null;
		}
		
		
		//로그인 유지용 세션
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		

		// 로그인 유지용 쿠키 저장
		if(keepLogin != null) {	
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60*10); // 로그인 유효기간 10분
			cookie.setPath("/");
			
			response.addCookie(cookie);
		}
		
		return "redirect:index.do";
	}
	
}
