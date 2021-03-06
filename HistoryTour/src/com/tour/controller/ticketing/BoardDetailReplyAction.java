package com.tour.controller.ticketing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.controller.Action;

public class BoardDetailReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDetailReplyAction");

		
		//이전에 봤던 목록 그대로 재현할 자료 받아오기
		String nowIndex= request.getParameter("nowIndex");	// 현재 인덱스
		String method = request.getParameter("method"); // 전체리스트 표시할 지, 검색리스트 표시할 지 판단
		String field = request.getParameter("field");	//뷰에서 넘어온 현재인덱스 문자열
		String word = request.getParameter("word");	//뷰에서 넘어온 현재인덱스 문자열

		//이전에 봤던 목록 그대로 재현할 자료 보내기
		request.setAttribute("nowIndex", nowIndex);
		request.setAttribute("method", method);
		request.setAttribute("field", field);
		request.setAttribute("word", word);
		

		
		//댓글 단계 확인 자료 받아오기
		String replyLevel = request.getParameter("replyLevel");
		String replyRef = request.getParameter("replyRef");
		String replySeq = request.getParameter("replySeq");
		String num = request.getParameter("num");
		
		//댓글 단계 확인 자료 보내기
		request.setAttribute("replyLevel", replyLevel);
		request.setAttribute("replyRef", replyRef);
		request.setAttribute("replySeq", replySeq);
		request.setAttribute("num", num);
		
				
		return "ticketing/boardDetailReply";
	}
	
}

