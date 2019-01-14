package com.naver.myhome1.sample4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//스프링을 이용하여 클래스 사이의 결합상태를 느슨하게 만듭니다.
public class HelloApp {

	public static void main(String[] args) {
		
		Resource resource = new ClassPathResource("applicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MessageBean bean = (MessageBean) factory.getBean("m2");
		bean.sayHello();
		
		/*MessageBeanImpl kk = new MessageBeanImpl("Spring");
		kk.setGreeting("안녕하세요!");
		kk.sayHello();*/
	}
}
