package com.tour.controller.ticketing;

import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tour.DAO.BoardDAO;
import com.tour.VO.BoardVO;
import com.tour.controller.Action;

public class BoardDetailReplyProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDetailReplyProAction");
		
		
		// ========================== 이동할 화면 구현에 필요한 내용(1) ========================
		
		// cos lib
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/upload");
		System.out.println("realPath : "+realPath);
		int maxSize = 1024*1024*50;
		
		// 첨부파일용 객체
		MultipartRequest multiReq = new MultipartRequest(
				request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		//이전에 봤던 목록 그대로 재현할 자료 받아오기
		String nowIndex= multiReq.getParameter("nowIndex"); //현재 인덱스
		String method = multiReq.getParameter("method"); // 전체리스트 표시할 지, 검색리스트 표시할 지 판단
		String field = multiReq.getParameter("field");	//뷰에서 넘어온 현재인덱스 문자열
		String word = multiReq.getParameter("word");	//뷰에서 넘어온 현재인덱스 문자열
		

		//=======================================================================================
		
		
				
		
		
		
		//=============== 메인 작업 =======================================================
		
		
		//댓글 입력 내용
		HttpSession session = request.getSession();//로그인 정보 추출
		String id = (String)session.getAttribute("id");
		String title = multiReq.getParameter("title");
		String content = multiReq.getParameter("content");
		String storedFileName = multiReq.getFilesystemName("fileName");
		int replyRef = Integer.parseInt(multiReq.getParameter("replyRef"));
		int replyLevel = Integer.parseInt(multiReq.getParameter("replyLevel"));
		int replySeq = Integer.parseInt(multiReq.getParameter("replySeq"));
			
		//VO에 댓글 입력
		BoardVO vo = BoardVO.getInstance();
		vo.setTitle(title);
		vo.setWriter(id);
		vo.setContent(content);
		vo.setWrtDate(new Timestamp(System.currentTimeMillis()));
		vo.setHit(0);
		vo.setFilename(storedFileName);
		vo.setReplyRef(replyRef);//주글 번호
		vo.setReplyLevel(replyLevel + 1);//댓글 레벨
		vo.setReplySeq(replySeq + 1);//댓글 순번
		
		
		
		BoardDAO dao = BoardDAO.getInstance();		
		dao.defineReplySeq(replyRef, replySeq);	//댓글입력 후 게시판 정렬용, 게시판정렬순서 : replyREF DESC, replySeq ASC  
		dao.addContent(vo);	//댓글 DB입력
		
		
		//댓글그룹용 쿼리문을 활용하여 방금댓글의 번호 추출
		//댓글등록하면 방금 댓글작성 내용을 상세보기로 표시하기 위함
		String num = String.valueOf(dao.getReplyRef()-1); 
				
			
		//==============================================================================
		
		
		
		
		
		
		
				
		//========================== 이동할 화면 구현에 필요한 내용(2) ========================
				
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
		//=========================================================================
		
		
		
		//이전에 봤던 목록 그대로 재현할 자료 보내기
		return "redirect:boardDetail.do?num="+num+"&isImage="+isImage+"&nowIndex="+nowIndex+"&method="+method+"&field="+field+"&word="+word;
	}
		
	
}

