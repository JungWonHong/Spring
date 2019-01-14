package com.naver.myhome1.sample5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//스프링을 이용하여 클래스 사이의 결합상태를 느슨하게 만듭니다.
public class HelloApp {

	public static void main(String[] args) {
		
		Resource resource = new ClassPathResource("applicationContext.xml");
		
		//빈 팩토리 생성합니다.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		//빈 팩토리로 부터 빈을 가져옵니다.
		//Object getBean(String name) :
		//			argument로 지정된 이름의 bean 인스턴스를 반환합니다.
		//applicationContext.xml에서 id가 "m3"인 bean을 가져옵니다.
		MessageBean bean = (MessageBean) factory.getBean("m3");
		
		bean.sayHello();//메서드 호출합니다.
	}
}
