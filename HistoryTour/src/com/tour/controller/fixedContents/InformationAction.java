package com.tour.controller.fixedContents;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tour.controller.Action;

public class InformationAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("InformationAction");
		return "fixedContents/information";
	}}
