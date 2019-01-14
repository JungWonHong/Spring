package com.naver.myhome2.sample6;

import org.springframework.context.support.GenericXmlApplicationContext;

//스프링을 이용하여 클래스 사이의 결합상태를 느슨하게 만듭니다.
public class HelloApp {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("com/naver/myhome2/sample6/applicationContext6.xml");
		MessageBeanImpl m3 = (MessageBeanImpl)ctx.getBean("m3");
		m3.setGreeting("안녕하세요?");
		
		//@Component 인 경우
		FileOutputter out = (FileOutputter)ctx.getBean("fileOutputter");
		
		out.setFilePath("out6.txt");
		
		m3.sayHello();
		
		ctx.destroy();
	}
}
