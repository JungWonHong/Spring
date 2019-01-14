package com.naver.myhome1.sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//스프링을 이용하여 클래스 사이의 결합상태를 느슨하게 만듭니다.
public class HelloApp1_comment {

	public static void main(String[] args) {
		/*
		 * Resource 구현 클래스가 ClassPathResource입니다.
		 * 인터페이스 Resource는 다양한 종류의 자원을 동일한 방식으로 통일하여
		 * 표현할 수 있게 해줍니다.
		 * org.springframework.core.io.ClassPathResource
		 *  : ClassPath에 있는 자원을 관리합니다.
		 */
		Resource resource = new ClassPathResource("applicationContext.xml");
		// applicationContext.xml(스프링 설정파일) 파일을 취득하고 있습니다.
		// 스프링 설정파일명은 다른이름으로 설정해도 상관없습니다.
		
		/*
		 * 인터페이스  BeanFactory : Bean 객체를 관리하고,
		 * 각 Bean객체간의 의존관계를 설정하는 가장 단순한 컨테이너입니다.
		 * BeanFactory를 구현한 클래스가 XmlBeanFactory 입니다.
		 * XmlBeanFactory 객체 생성시 설정 파일의 위치를 알려줘야 합니다.
		 */
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MessageBean bean = (MessageBean) factory.getBean("m");
		bean.sayHello("Spring");
	}
}
