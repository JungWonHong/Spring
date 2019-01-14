package com.naver.myhome2.sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("com/naver/myhome2/sample5/applicationContext.xml");
		
		//MessageBean bean = (MessageBean)ctx.getBean("m3");
		MessageBean bean = ctx.getBean("m3", MessageBean.class);
		
		System.out.println("\n======	main���� sayHello ȣ���մϴ�.		======");
		bean.sayHello();//�޼��� ȣ���մϴ�.
		ctx.destroy();
	}
}
