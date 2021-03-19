package com.tour.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 액션 컨트롤러들의 결합도를 낮추는 용도의 인터페이스
public interface Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
