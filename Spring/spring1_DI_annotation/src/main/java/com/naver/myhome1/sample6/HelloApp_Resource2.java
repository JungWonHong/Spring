/*
 * MessageBeanImpl.java���� @Resource ����� ����
 	- @Autowired�� ������ Ÿ���� �������� �˻��Ͽ� ������ ������ ó��������
 	  @Resource�� ��ü�� �̸��� �̿��Ͽ� ������ ������ ó���մϴ�.
 	- �����ڿ��� ������ �� ���� �ʵ峪 �޼��忡�� ������ �� �ֽ��ϴ�.
 	
 	�ڵ� ���� ����� ���� �� ���� ���
 	1) �ڵ� ���� ��� @Resource �ֳ����̼� ���
 	2) XML ������ <context:annotation-config/> ���
 */
package com.naver.myhome1.sample6;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_Resource2 {

	public static void main(String[] args) {
		
		//1. Spring �����̳� ����
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:com/naver/myhome1/sample6/applicationContext6.xml");
		
		//2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û
		//MessageBean bean = (MessageBean)ctx.getBean("m3");
		MessageBean bean = ctx.getBean("m3", MessageBean.class);
		
		bean.sayHello();//�޼��� ȣ���մϴ�.
		ctx.close();
	}
}
