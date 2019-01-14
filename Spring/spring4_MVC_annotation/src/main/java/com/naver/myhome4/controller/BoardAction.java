package com.naver.myhome4.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome4.model.BbsBean;

@Controller
public class BoardAction {
	
	@RequestMapping(value="/login_ok.do", method=RequestMethod.POST)
	public ModelAndView board_write(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		BbsBean bbs =  new BbsBean();
		bbs.setId(id);
		bbs.setPass(pass);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		
		mv.addObject("bkey", bbs);
		
		return mv;
	}
}
