package com.tour.controller.ticketing;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.DAO.BoardDAO;
import com.tour.VO.BoardVO;
import com.tour.controller.Action;

public class BoardDeleteProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardDeleteProAction");
		
		
		int num = Integer.parseInt(request.getParameter("num"));		
		String filename = request.getParameter("filename");
		String nowIndex = request.getParameter("nowIndex");
		
		
		if(filename != null) {	// 첨부파일 있을 시 삭제하기
			ServletContext context = request.getServletContext();
			String realPath = context.getRealPath("/upload");	//실제 경로 탐색
			File file = new File(realPath, filename);	// 파일 객체를 만들어 실제경로와, 저장된 파일명으로 초기화
			if(file.exists())	// 파일이 실제로 존재하는지 확인 후 삭제
				file.delete();
		}
			
		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(num);	//파일 제거까지 한 후 데이터 삭제
		
		
		return "redirect:board.do?nowIndex="+nowIndex;
	}
}
