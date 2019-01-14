package com.naver.myhome2.sample6;

import org.springframework.context.support.GenericXmlApplicationContext;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("com/naver/myhome2/sample6/applicationContext6.xml");
		MessageBeanImpl m3 = (MessageBeanImpl)ctx.getBean("m3");
		m3.setGreeting("�ȳ��ϼ���?");
		
		//@Component �� ���
		FileOutputter out = (FileOutputter)ctx.getBean("fileOutputter");
		
		out.setFilePath("out6.txt");
		
		m3.sayHello();
		
		ctx.destroy();
	}
}
