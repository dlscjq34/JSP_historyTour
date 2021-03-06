package com.tour.controller.ticketing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.DAO.BoardDAO;
import com.tour.VO.BoardVO;
import com.tour.controller.Action;

public class BoardDetailUpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardDetailUpdate");
		
		//해당글 뽑아올 키
		String num = request.getParameter("num");
		//이전에 봤던 목록 그대로 재현할 자료 받아오기
		String nowIndex= request.getParameter("nowIndex"); //현재 인덱스
		String method = request.getParameter("method"); // 전체리스트 표시할 지, 검색리스트 표시할 지 판단
		String field = request.getParameter("field");	//뷰에서 넘어온 현재인덱스 문자열
		String word = request.getParameter("word");	//뷰에서 넘어온 현재인덱스 문자열
		

		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(num);		//해당글 뽑아오기
		
		
		//첨부파일이 이미지일 경우 게시글 변경화면에서 바로 보기
		String filename = vo.getFilename();
		boolean isImage = false;
		if(filename != null) {
			int index = filename.indexOf(".");
			String extention = filename.substring(index + 1);
			
			if( extention.equalsIgnoreCase("jpg")  ||
				extention.equalsIgnoreCase("jpeg") ||
				extention.equalsIgnoreCase("png")  ||
				extention.equalsIgnoreCase("gif") ) {
				isImage = true;
			}
		}
		
		
		//상세페이지에 필요한 데이터
		request.setAttribute("vo", vo);
		request.setAttribute("isImage", isImage);
		
		//이전에 봤던 목록 그대로 재현할 자료 보내기
		request.setAttribute("nowIndex", nowIndex);
		request.setAttribute("method", method);
		request.setAttribute("field", field);
		request.setAttribute("word", word);
				
		
		return "ticketing/boardDetailUpdate";
	}
	
}

