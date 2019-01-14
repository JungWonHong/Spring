package com.naver.myhome1.sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp2 {

	public static void main(String[] args) {
		
		Resource resource = new ClassPathResource("applicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MessageBean bean = (MessageBean) factory.getBean("m1");
		bean.sayHello("������~");
	}
}
