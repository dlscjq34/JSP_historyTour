package com.tour.controller.member;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.DAO.MemberDAO;
import com.tour.VO.MemberVO;
import com.tour.controller.Action;
	
public class JoinMemberProAction implements Action {	// 폼에서 넘어온 데이터를 DB로 입력

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("JoinMemberProAction");
		
		String id = request.getParameter("id");
		String pswd = request.getParameter("pswd1");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		Timestamp regDate = new Timestamp(System.currentTimeMillis());

		MemberVO vo = MemberVO.getInstance();
		vo.setId(id); 
		vo.setPswd(pswd); 
		vo.setName(name); 
		vo.setBirth(birth); 
		vo.setGender(gender); 
		vo.setTel(tel); 
		vo.setAddress(address); 
		vo.setRegDate(regDate);

		MemberDAO dao = MemberDAO.getInstance();
		dao.addMember(vo);
		
		
		
		return "redirect:login.do";
	}}
