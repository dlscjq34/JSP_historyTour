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

public class WriteProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteProAction");
		
		//cos lib
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/upload");
		System.out.println("File RealPath : "+realPath);//test
		int maxSize = 1024 * 1024 * 100; // 100MB 
		MultipartRequest multiReq = new MultipartRequest
				(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		
		//원본파일명
		String originFileName = multiReq.getOriginalFileName("fileName");
		System.out.println("originFileName : "+originFileName);//test
		
		//실저장파일명
		String storedFileName = multiReq.getFilesystemName("fileName");
		System.out.println("storedFileName : "+storedFileName);//test
		
		//로그인정보
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		//주글 참조번호 얻어오기
		BoardDAO dao = BoardDAO.getInstance();
		int replyRef = dao.getReplyRef();
		
		//DB로 자료 입력
		BoardVO vo = BoardVO.getInstance();
		vo.setTitle(multiReq.getParameter("title"));
		vo.setWriter(id);
		vo.setContent(multiReq.getParameter("content"));
		vo.setWrtDate(new Timestamp(System.currentTimeMillis()));
		vo.setHit(0);
		vo.setFilename(storedFileName);
		vo.setReplyRef(replyRef);//주글참조번호(이걸 기준으로 댓글들이 묶인다.)
		vo.setReplyLevel(0);//주글에 대한 댓글의 깊이(댓글 들여쓰기용)
		vo.setReplySeq(0);//주글그룹의 순차번호(게시글 정렬용)
		dao.addContent(vo);
		
		
		return "redirect:board.do";
	}}
