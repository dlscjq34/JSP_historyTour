package com.tour.controller.ticketing;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.DAO.BoardDAO;
import com.tour.VO.BoardVO;
import com.tour.controller.Action;

public class BoardAction implements Action {	// 전체 리스트와 검색된 리스트 동시 표현 가능

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardAction");
		
		String strNowIndex = request.getParameter("nowIndex");	//뷰에서 넘어온 현재인덱스 문자열
		String method = request.getParameter("method"); // 전체리스트 표시할 지, 검색리스트 표시할 지 판단
		String field = request.getParameter("field");	//뷰에서 넘어온 현재인덱스 문자열
		String word = request.getParameter("word");	//뷰에서 넘어온 현재인덱스 문자열		
		
		
		BoardDAO dao = BoardDAO.getInstance();
		
		
		int count = dao.getCount("title", "");    
		int nowIndex = (strNowIndex == null)? 1:Integer.parseInt(strNowIndex);	//페이지 첫 방문 시 현재인덱스 초기화, 그 이후는 넘어온 값을 정수로 변환
		int contentSize = 10;	// 게시글 표시 갯수		
		int startContent = (nowIndex - 1) * contentSize;	// 화면에 표시될 첫번째 게시글
		int totalIndex = (count/contentSize) + ((count % contentSize > 0)? 1:0);// 총 인덱스 수; 
		int indexSize = 5;	// 화면 당 인덱스 수
		int startIndex = nowIndex - ((nowIndex % indexSize == 0)? indexSize:(nowIndex % indexSize)) + 1;	// 화면에 표시될 첫번째인덱스
		int endIndex = startIndex + (indexSize - 1);	// 화면에 표시될 마지막인덱스
			endIndex = (endIndex > totalIndex)? totalIndex:endIndex; // 전체리스트의 마지막인덱스까지만 화면에 나오도록 처리
		    
			
		List<BoardVO> list = null;

		
		
		if(method != null && !method.equals("")) {	// 리스트에서 검색할 떄만 적용
			list = dao.getList(startContent, contentSize, field, word);
			count = dao.getCount(field, word);
			totalIndex = (count/contentSize) + ((count % contentSize > 0)? 1:0);// 검색 결과 인덱스 수
			endIndex = (endIndex > totalIndex)? totalIndex:endIndex; // 검색리스트의 마지막인덱스까지만 화면에 나오도록 처리
			System.out.println("startIndex :"+startIndex);
		} else {	// 전체 리스트 적용
			list = dao.getList(startContent, contentSize, "title", "");// DB호출, 하나의 getList 메서드로 검색도 겸하기 위해 파라미터 값 빈문자열 적용, 검색 건트롤러에서 파라미터 사용
		}
		
		
		
		//view로 자료 전달
		request.setAttribute("list", list);
		request.setAttribute("startIndex", startIndex);
		request.setAttribute("nowIndex", nowIndex);
		request.setAttribute("endIndex", endIndex);
		request.setAttribute("count", count);
		request.setAttribute("totalIndex", totalIndex);
		request.setAttribute("indexSize", indexSize);
		request.setAttribute("method", method);
		request.setAttribute("field", field);
		request.setAttribute("word", word);
		
		
		return "ticketing/board";
	}
}

