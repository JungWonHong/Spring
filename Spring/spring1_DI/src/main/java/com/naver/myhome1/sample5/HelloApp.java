package com.naver.myhome1.sample5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp {

	public static void main(String[] args) {
		
		Resource resource = new ClassPathResource("applicationContext.xml");
		
		//�� ���丮 �����մϴ�.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		//�� ���丮�� ���� ���� �����ɴϴ�.
		//Object getBean(String name) :
		//			argument�� ������ �̸��� bean �ν��Ͻ��� ��ȯ�մϴ�.
		//applicationContext.xml���� id�� "m3"�� bean�� �����ɴϴ�.
		MessageBean bean = (MessageBean) factory.getBean("m3");
		
		bean.sayHello();//�޼��� ȣ���մϴ�.
	}
}
