package com.tour.controller;


import java.util.HashMap;
import java.util.Map;

import com.tour.controller.fixedContents.InformationAction;
import com.tour.controller.fixedContents.IntroAction;
import com.tour.controller.member.EditMemberAction;
import com.tour.controller.member.JoinCheckAction;
import com.tour.controller.member.JoinMemberAction;
import com.tour.controller.member.JoinMemberProAction;
import com.tour.controller.member.LogInAction;
import com.tour.controller.member.LogInProAction;
import com.tour.controller.member.LogOutProAction;
import com.tour.controller.member.MyPageAction;
import com.tour.controller.ticketing.BoardAction;
import com.tour.controller.ticketing.BoardDeleteProAction;
import com.tour.controller.ticketing.BoardDetailAction;
import com.tour.controller.ticketing.BoardDetailReplyAction;
import com.tour.controller.ticketing.BoardDetailReplyProAction;
import com.tour.controller.ticketing.BoardDetailUpdateAction;
import com.tour.controller.ticketing.BoardDetailUpdateProAction;
import com.tour.controller.ticketing.DetailAction;
import com.tour.controller.ticketing.ScheduleAction;
import com.tour.controller.ticketing.TicketAction;
import com.tour.controller.ticketing.WriteAction;
import com.tour.controller.ticketing.WriteProAction;


// 기능별 컨트롤러 저장소
public class ActionFactory {

	private static ActionFactory actionFactory = new ActionFactory();
	private Map<String, Action> map = new HashMap<>();
	
	public static ActionFactory getInstance() {
		return actionFactory;
	}

	private ActionFactory() {
		
		// index
		map.put("/index", new IndexAction());
		
		// fixedContents
		map.put("/intro", new IntroAction());
		map.put("/information", new InformationAction());
		
		// member
		map.put("/editMember", new EditMemberAction());
		map.put("/joinMember", new JoinMemberAction());
		map.put("/joinMemberPro", new JoinMemberProAction());
		map.put("/joinCheck", new JoinCheckAction());
		map.put("/login", new LogInAction());
		map.put("/loginPro", new LogInProAction());
		map.put("/logoutPro", new LogOutProAction());
		map.put("/myPage", new MyPageAction());
		
		// ticketing
		map.put("/board", new BoardAction());
		map.put("/boardDetail", new BoardDetailAction());
		map.put("/boardDeleteProAction", new BoardDeleteProAction());
		map.put("/boardDetailUpdate", new BoardDetailUpdateAction());
		map.put("/boardDetailUpdatePro", new BoardDetailUpdateProAction());
		map.put("/boardDetailReply", new BoardDetailReplyAction());
		map.put("/boardDetailReplyPro", new BoardDetailReplyProAction());
		map.put("/write", new WriteAction());
		map.put("/writePro", new WriteProAction());
		map.put("/detail", new DetailAction());
		map.put("/schedule", new ScheduleAction());
		map.put("/ticket", new TicketAction());
	}
	
	public Action getAction(String command) {
		
		return map.get(command);
	}
}
