package com.tour.controller.ticketing;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tour.DAO.BoardDAO;
import com.tour.VO.BoardVO;
import com.tour.controller.Action;

public class BoardDetailUpdateProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDetailUpdateProAction");
		
		
		
		
		// ========================== 이 페이지로 온 직후 세팅 화면 및 이동할 화면 구현에 필요한 내용들 ========================
		
		// cos lib
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/upload");
		System.out.println("realPath : "+realPath);
		int maxSize = 1024*1024*50;
		
		// 첨부파일용 객체
		MultipartRequest multiReq = new MultipartRequest(
				request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		//이전에 봤던 목록 그대로 재현할 자료 받아오기
		String nowIndex= multiReq.getParameter("nowIndex");
		String method = multiReq.getParameter("method"); // 전체리스트 표시할 지, 검색리스트 표시할 지 판단
		String field = multiReq.getParameter("field");	//뷰에서 넘어온 현재인덱스 문자열
		String word = multiReq.getParameter("word");	//뷰에서 넘어온 현재인덱스 문자열
		
		//해당글 뽑아오기
		String num = multiReq.getParameter("num");
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(num);		
		
		
		//=======================================================================================
		
		
		
		
		
		// 기존 파일 삭제 시
		String delFilename = multiReq.getParameter("delFilename");
		if(delFilename != null) {
			File file = new File(realPath, delFilename);
			vo.setFilename(null);	// 파일명이 불일치해도 일단 디비에서는 파일명 지운다.
			if(file.exists()) {
				file.delete();
			}
		}
		//(파일 새로 입력했을 시 )
		String storedFileName = multiReq.getFilesystemName("newFile");		
		if(storedFileName != null) {		
			vo.setFilename(storedFileName);
		}
		
		
		
		//DB로 데이터 입력
		String title = multiReq.getParameter("title");
		String content = multiReq.getParameter("content");
		vo.setTitle(title);
		vo.setContent(content);
		
			
		
		//DB실행
		dao.updateContent(vo);
		
		
		//첨부파일이 이미지일 경우 게시글 변경화면에서 바로 보기 세팅
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

		
		//이전에 봤던 목록 그대로 재현할 자료 보내기
		request.setAttribute("vo", vo);
		request.setAttribute("isImage", isImage);
		request.setAttribute("nowIndex", nowIndex);
		request.setAttribute("method", method);
		request.setAttribute("field", field);
		request.setAttribute("word", word);
				
		
		return "ticketing/boardDetail";
	}
	
}

