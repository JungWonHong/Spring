package com.naver.myhome1.sample4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp {

	public static void main(String[] args) {
		
		Resource resource = new ClassPathResource("applicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MessageBean bean = (MessageBean) factory.getBean("m2");
		bean.sayHello();
		
		/*MessageBeanImpl kk = new MessageBeanImpl("Spring");
		kk.setGreeting("�ȳ��ϼ���!");
		kk.sayHello();*/
	}
}
