package com.naver.myhome1.sample7;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//�߰� �մϴ�. - "m3" �� ���� �̸��Դϴ�.
//��, @Component�� ���� �Ӽ����� ���� �̸��Դϴ�.
//getBean�� ȣ���� �� �� �̸��� ����մϴ�.
@Component("m3")
public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;
	private Outputter outputter;
	
	//���� �κ�
	public MessageBeanImpl() {
		name = "ȫ�浿";
		System.out.println("2. MessageBeanImpl ������ �Դϴ�.");
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
		System.out.println("4. MessageBeanImpl�� setGreeting()���� �� ����");
	}// setter DI ����(������ ���)
	
	//�߰��� �κ� 
	@Autowired //�ش� Ÿ�Կ� �Ҵ��� �� �ִ� �� ��ü�� ã�Ƽ� �ڵ� ���Ե˴ϴ�.
			   //�ݵ�� ������ ���� ��ü�� �����ؾ� �մϴ�.
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("3. MessageBeanImpl�� setOutputter()���� �� ����");
	}// setter DI ����
}
