package com.naver.myhome4.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.myhome4.model.BbsBean;

//@Controller
public class BoardAction2_���� {
	
	@RequestMapping(value="/login_ok2.do", method=RequestMethod.POST)
	public String board_write(
			BbsBean bbs,  //command ��ü
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		return "list2";
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
		   
		   command ��ü�� ����� ���� JSP���� ����ϱ� ���ؼ���
		   ${bbsBean.id} �Ǵ� ${bbsBean.pass}�� ����մϴ�.
		       ��, list2.jsp����
		   command ��ü�� Ŭ���� �̸�(ù ���ڸ� �ҹ��ڷ� �ٲߴϴ�.)��
		       ������ �Ӽ� �̸��� ����ؼ� command ��ü�� �信 �����մϴ�.
		       ���� command ��ü�� Ŭ���� �̸��� BbsBean�� ��� JSP �ڵ忡����
		   bbsBean�̶�� �̸��� ����ؼ� command ��ü�� ������ �� �ְ� �˴ϴ�.
		 */
	}
}
