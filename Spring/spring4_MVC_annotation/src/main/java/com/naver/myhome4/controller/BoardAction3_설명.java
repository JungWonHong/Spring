package com.naver.myhome4.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome4.model.BbsBean;

//@Controller
public class BoardAction3_설명 {
	
	@RequestMapping(value="/login_ok3.do", method=RequestMethod.POST)
	public ModelAndView board_write(
			@ModelAttribute("hoho")BbsBean bbs,  //command 객체
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		/* command 객체란?
		 * 스프링은 요청 파라미터의 값을 command 객체에 담아주는 기능을 제공합니다.
		 * command 객체에는 파라미터로 넘어온 값들을 저장할 setter 메서드가 존재하면 됩니다.
		 * 즉, 파라미터의 이름과 property의 이름이 같으면 됩니다.
		 * 예로 loginForm.jsp 에서 <input type=text name=id>에서 입력한 값을 저장하기
		       위해 setId()메서드가 존재하면 됩니다.
		 *
		 * String id = request.getParameter("id");
		   String pass = request.getParameter("pass");
		   BbsBean bbs = new BbsBean();
		   bbs.setId(id);
		   bbs.setPass(pass);
		   
		   command 객체를 사용하면 이전에 사용되었던 위의 코드들 기능을 하게 되어 필요 없게 됩니다.
		*/
		/* command 객체에 접근할 때 사용할 속성 명을 변경하고 싶다면
		   @ModelAttribute를 사용합니다.
		   예) @ModelAttribute("hoho") BbsBean bbs
		     view 페이지에서 "hoho"라는 이름으로 사용하면 됩니다.
		     
		     <th>ID2</th><td>${hoho.id }</td>
		 */
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list3");
		//두 문장과 같은 의미로 ModelAndView mv = new ModelAndView("list3");
		//ViewResolver에 의해 WebContent/view/list3.jsp를 찾아가게 됩니다.
		
		return mv;
	}
}
