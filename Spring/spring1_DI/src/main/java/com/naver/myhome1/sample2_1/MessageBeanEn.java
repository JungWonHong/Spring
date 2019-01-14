package com.naver.myhome1.sample2_1;

public class MessageBeanEn implements MessageBean {
	//추상 메서드
	@Override
	public void sayHello(String name) {
		System.out.println("Hello!" + name);
	}
	
}
