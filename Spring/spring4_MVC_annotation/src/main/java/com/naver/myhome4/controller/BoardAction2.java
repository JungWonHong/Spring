package com.naver.myhome4.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.myhome4.model.BbsBean;

@Controller
public class BoardAction2 {
	
	@RequestMapping(value="/login_ok2.do", method=RequestMethod.POST)
	public String board_write(
			BbsBean bbs,  //command °´Ã¼
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		return "list2";
	}
}
