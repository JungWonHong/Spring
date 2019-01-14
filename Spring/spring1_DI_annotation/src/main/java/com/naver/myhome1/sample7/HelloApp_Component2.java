/*
	1. MessageBeanImpl.java���� @Component ����� ����
		- Spring �����̳ʰ� component-scan�� ���ؼ�
			�ڵ����� bean ����� ������� �����˴ϴ�.
		- �̶� bean�� �̸��� ������ �� �ִµ� ����� @Component("���� �̸�")gkaus ehlqslek.
		- �̸��� ������� ������ ������ Ŭ������ �̸����� ù���ڸ� �ҹ��ڷ� �ٲ� �̸�����
			bean�� �����˴ϴ�.
 */
package com.naver.myhome1.sample7;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_Component2 {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:com/naver/myhome1/sample7/applicationContext7.xml");
		
		MessageBeanImpl m3 = (MessageBeanImpl)ctx.getBean("m3");
		m3.setGreeting("�ȳ��ϼ���?");
		
		//@Component �� ���
		//FileOutputter out = (FileOutputter)ctx.getBean("fileOutputter");
		
		//@Component("outputter")�� ���
		FileOutputter out = (FileOutputter)ctx.getBean("outputter");
		
		out.setFilePath("out7.txt");
		
		m3.sayHello();
		ctx.close();
	}
}
