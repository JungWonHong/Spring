package com.naver.myhome4.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome4.model.BbsBean;

@Controller
public class BoardAction3 {
	
	@RequestMapping(value="/login_ok3.do", method=RequestMethod.POST)
	public ModelAndView board_write(
			@ModelAttribute("hoho")BbsBean bbs,  //command °´Ã¼
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		/*
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("list3");
		 */
		ModelAndView mv = new ModelAndView("list3");
		
		return mv;
	}
}
