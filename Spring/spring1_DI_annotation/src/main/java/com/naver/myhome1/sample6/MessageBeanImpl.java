package com.naver.myhome1.sample6;

import java.io.IOException;

import javax.annotation.Resource;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;
	private Outputter outputter;
	
	//������ DI (Spring)
	//������ ȣ���� ���Ͽ� name="Spring" �Ҵ��մϴ�
	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("1. MessageBeanImpl ������ �Դϴ�.");
	} //������ ����
	
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
		System.out.println("5. MessageBeanImpl�� setGreeting()���� �� ����");
	}// setter DI ����(������ ���)
	
	//�߰��� �κ� - name �Ӽ��� �����ϰ��� �ϴ� ���� ��ü�� �̸�(���̵� ��)�� �����մϴ�.
	@Resource(name="output")
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("4. MessageBeanImpl�� setOutputter()���� �� ����");
	}// setter DI ����
}
