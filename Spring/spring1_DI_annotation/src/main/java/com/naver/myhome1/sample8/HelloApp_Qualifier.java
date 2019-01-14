package com.naver.myhome1.sample8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp_Qualifier {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx
			= new ClassPathXmlApplicationContext("com/naver/myhome1/sample8/applicationContext8.xml");
		MessageMultiple bean = (MessageMultiple)ctx.getBean("m2");
		bean.print();
		ctx.close();
	}

}
