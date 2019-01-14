package com.naver.myhome3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.myhome3.model.BbsBean;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/*
  Controller ����
  	1. Controller(interface)
  	2. AbstractController
  	3. AbstractCommandController
  	4. MultiActionController
  	       ���� interface/class�� ����Ͽ� Controller�� �ۼ��մϴ�.
  	       
	���� �⺻�� �Ǵ� Controller �ۼ� �մϴ�.
	AbstractController�� ��� �ް� �������̵� �ؼ� �ڵ带 �����մϴ�.
	����� �ڷ����� ModelAndView�� view���� ����� ��ü�� 
	view�� ���� id�� ��й�ȣ�� ������ �� return �մϴ�.
 */
public class BbsWriteController extends AbstractController {

	private BbsBean b;

	// setter DI
	public void setBbsBean(BbsBean b) {
		this.b = b;
	}

	// ModelAndView : DispatcherServlet�� Controller ó�� ��� �� ������
	// view�� view�� ������ ���� �����մϴ�.
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
		// �� ����� ���� �ǹ̷� ModelAndView mv = new ModelAndView("list");
		// ViewResolver�� ���� webapp/view/list.jsp�� ã�ư��� �˴ϴ�.

		mv.addObject("bkey", b);
		// addObjec�� ù ��° �Ű������� Ű(Key), �� ��° �Ű������� ��(Value)�� �ǹ��մϴ�.
		// b�� id�� ��й�ȣ�� ����Ǿ� �ִ� DTO ��ü �Դϴ�.
		// ModelAndView�� ���� ������ ���� webapp/view/list.jsp���� EL�� ��Ÿ���� �ֽ��ϴ�.
		// ID : ${bkey.id} <br>
		// ��й�ȣ : ${bkey.pass} <br>

		return mv;
	}
}
