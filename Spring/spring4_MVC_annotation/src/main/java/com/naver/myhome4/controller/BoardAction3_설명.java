package com.naver.myhome4.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome4.model.BbsBean;

//@Controller
public class BoardAction3_���� {
	
	@RequestMapping(value="/login_ok3.do", method=RequestMethod.POST)
	public ModelAndView board_write(
			@ModelAttribute("hoho")BbsBean bbs,  //command ��ü
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		/* command ��ü��?
		 * �������� ��û �Ķ������ ���� command ��ü�� ����ִ� ����� �����մϴ�.
		 * command ��ü���� �Ķ���ͷ� �Ѿ�� ������ ������ setter �޼��尡 �����ϸ� �˴ϴ�.
		 * ��, �Ķ������ �̸��� property�� �̸��� ������ �˴ϴ�.
		 * ���� loginForm.jsp ���� <input type=text name=id>���� �Է��� ���� �����ϱ�
		       ���� setId()�޼��尡 �����ϸ� �˴ϴ�.
		 *
		 * String id = request.getParameter("id");
		   String pass = request.getParameter("pass");
		   BbsBean bbs = new BbsBean();
		   bbs.setId(id);
		   bbs.setPass(pass);
		   
		   command ��ü�� ����ϸ� ������ ���Ǿ��� ���� �ڵ�� ����� �ϰ� �Ǿ� �ʿ� ���� �˴ϴ�.
		*/
		/* command ��ü�� ������ �� ����� �Ӽ� ���� �����ϰ� �ʹٸ�
		   @ModelAttribute�� ����մϴ�.
		   ��) @ModelAttribute("hoho") BbsBean bbs
		     view ���������� "hoho"��� �̸����� ����ϸ� �˴ϴ�.
		     
		     <th>ID2</th><td>${hoho.id }</td>
		 */
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list3");
		//�� ����� ���� �ǹ̷� ModelAndView mv = new ModelAndView("list3");
		//ViewResolver�� ���� WebContent/view/list3.jsp�� ã�ư��� �˴ϴ�.
		
		return mv;
	}
}
