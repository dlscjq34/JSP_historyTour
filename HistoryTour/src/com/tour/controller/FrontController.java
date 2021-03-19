package com.tour.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//메인 컨트롤러
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자 입력 주소 추출
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		System.out.println("doGet URI : "+requestURI);		//	/HistoryTour/index.do
		System.out.println("ContextPath : "+contextPath);	//	/HistoryTour
		
		String command = requestURI.substring(contextPath.length());
		command = command.substring(0, command.indexOf(".do"));
		System.out.println("command : "+command);	//	/index
		
		// 사용자 입력 주소에 맞는 컨트롤러 호출
		ActionFactory actionFactory = ActionFactory.getInstance();
		Action action = actionFactory.getAction(command);
		if(action == null)
			System.out.println("action is not found");
		
		// 컨트롤러 동작 후 이동할 경로 데이터 추출
		String viewAddress = "";
		try {
			viewAddress = action.execute(request, response);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("viewAddress : "+viewAddress);	//	redirect:login
		
		
		// 컨트롤러 이후 또 다른 컨트롤러로 갈 경우
		if(viewAddress.startsWith("redirect:")) {
			viewAddress = viewAddress.substring("redirect:".length());
			System.out.println("redirect path :"+viewAddress);
			response.sendRedirect(viewAddress);
		}
		// 컨트롤러 이후 jsp로 갈 경우
		else {
			String jspPath = "/WEB-INF/views/"+viewAddress+".jsp";
			System.out.println("dispatch path : "+jspPath);	// //WEB-INF/views/index.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
			dispatcher.forward(request, response);
		}
			
	}

	// 일단 포스트로 넘겨 일괄 작업하는 것이 편하다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("doPost URI : "+request.getRequestURI());//test
		doGet(request, response);
	}

}
