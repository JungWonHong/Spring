package com.naver.myhome1.sample6;

import java.io.IOException;

import javax.annotation.Resource;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;
	private Outputter outputter;
	
	//생성자 DI (Spring)
	//생성자 호출을 통하여 name="Spring" 할당합니다
	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("1. MessageBeanImpl 생성자 입니다.");
	} //생성자 정의
	
	@Override
	public void sayHello() {
		String message = greeting + name + "!";
		System.out.println("6. MessageBeanImpl의 sayHello() 호출 : " + message);
		try {
			outputter.output(message);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public String getGreeting() {
		return greeting;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("5. MessageBeanImpl의 setGreeting()에서 값 저장");
	}// setter DI 설정(스프링 용어)
	
	//추가된 부분 - name 속성에 주입하고자 하는 의존 객체의 이름(아이디 값)을 지정합니다.
	@Resource(name="output")
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("4. MessageBeanImpl의 setOutputter()에서 값 저장");
	}// setter DI 설정
}
