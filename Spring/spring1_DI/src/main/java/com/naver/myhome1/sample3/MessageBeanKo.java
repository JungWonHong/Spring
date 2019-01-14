package com.naver.myhome1.sample3;

public class MessageBeanKo implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요!" + name);
	}
	
	public MessageBeanKo() {
		System.out.println("이곳은 MessageBeanKo 생성자입니다.");
	}
}
