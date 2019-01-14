package com.naver.myhome2.sample6;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("m3")
public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;
	private Outputter outputter;

	// ������ ȣ���� ���Ͽ� name="Spring" �Ҵ��մϴ�
	public MessageBeanImpl() {
		name = "ȫ�浿";
		System.out.println("1. MessageBeanImpl ������ �Դϴ�.");
	} // ������ ����

	@Override
	public void sayHello() {
		String message = greeting + name + "!";
		System.out.println("6. MessageBeanImpl�� sayHello() ȣ�� : " + message);
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
		System.out.println("4. MessageBeanImpl�� setGreeting()���� �� ����");
	}// setter DI ����(������ ���)

	@Autowired
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("5. MessageBeanImpl�� setOutputter()���� �� ����");
	}// setter DI ����

	// ��ü�� ������ �Ŀ� init-method �Ӽ����� ������ �� �޼��带 ȣ���մϴ�.
	@PostConstruct //init-method="initMethod"�� �ش��ϴ� annotation
	public void initMethod() {
		System.out.println(" MessageBeanImpl�� init-method�� �����մϴ�.");
	}
}
