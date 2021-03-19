package com.tour.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.DAO.MemberDAO;
import com.tour.controller.Action;

public class JoinCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("JoinCheckAction");
		
		
		String id = request.getParameter("id");
		
		// 입력폼에서 넘어온 정보를 이용해 중복여부 체크 
		MemberDAO dao = MemberDAO.getInstance();
		boolean dupCheck = false;
		
		if(dao.checkJoinedMember(id) != 0) {
			dupCheck = true;
		}
		
		// 결과 보냄
		request.setAttribute("id", id);
		request.setAttribute("dupCheck", dupCheck);
		
		return "member/joinCheck";
	}
	
}
