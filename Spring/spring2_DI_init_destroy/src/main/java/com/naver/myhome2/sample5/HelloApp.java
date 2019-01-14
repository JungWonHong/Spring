package com.naver.myhome2.sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

//스프링을 이용하여 클래스 사이의 결합상태를 느슨하게 만듭니다.
public class HelloApp {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("com/naver/myhome2/sample5/applicationContext.xml");
		
		//MessageBean bean = (MessageBean)ctx.getBean("m3");
		MessageBean bean = ctx.getBean("m3", MessageBean.class);
		
		System.out.println("\n======	main에서 sayHello 호출합니다.		======");
		bean.sayHello();//메서드 호출합니다.
		ctx.destroy();
	}
}
