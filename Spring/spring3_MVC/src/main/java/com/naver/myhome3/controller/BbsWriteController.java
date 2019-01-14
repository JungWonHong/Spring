package com.naver.myhome3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.myhome3.model.BbsBean;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/*
  Controller 종류
  	1. Controller(interface)
  	2. AbstractController
  	3. AbstractCommandController
  	4. MultiActionController
  	       위의 interface/class를 상속하여 Controller를 작성합니다.
  	       
	가장 기본이 되는 Controller 작성 합니다.
	AbstractController를 상속 받고 오버라이딩 해서 코드를 구현합니다.
	결과의 자료형은 ModelAndView로 view에서 사용할 객체와 
	view에 대한 id와 비밀번호를 저장한 후 return 합니다.
 */
public class BbsWriteController extends AbstractController {

	private BbsBean b;

	// setter DI
	public void setBbsBean(BbsBean b) {
		this.b = b;
	}

	// ModelAndView : DispatcherServlet은 Controller 처리 결과 후 응답할
	// view와 view에 전달할 값을 저장합니다.
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html;charset=UTF-8");

		// request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id").trim();
		String pass = request.getParameter("pass").trim();

		b.setId(id);
		b.setPass(pass);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		// 두 문장과 같은 의미로 ModelAndView mv = new ModelAndView("list");
		// ViewResolver에 의해 webapp/view/list.jsp를 찾아가게 됩니다.

		mv.addObject("bkey", b);
		// addObjec의 첫 번째 매개변수는 키(Key), 두 번째 매개변수는 값(Value)을 의미합니다.
		// b는 id와 비밀번호가 저장되어 있는 DTO 객체 입니다.
		// ModelAndView에 값을 저장한 것은 webapp/view/list.jsp에서 EL로 나타낼수 있습니다.
		// ID : ${bkey.id} <br>
		// 비밀번호 : ${bkey.pass} <br>

		return mv;
	}
}
