/*
	1. MessageBeanImpl.java에서 @Autowired사용해 보기
		- @Autowired은 생성자나 메서드, 멤버변수 위에 모두 사용할 수 있습니다.
		- 자동 주입 기능을 사용하면 스프링이 알아서 의존 객체를 찾아서 주입해 줍니다.
		- 즉, 해당 타입에 할당할 수 있는 빈 객체를 찾아서 주입합니다.
		- @Autowired 애노테이션을 적용하면 반드시 주입할 의존 객체가 존재해야 합니다.
		- 만약 @Autowired가 붙은 객체가 메모리에 없다면 스프링 컨테이너가
		  NoSuchBeanDefinitionException을 발생시킵니다.
		
		 자동 주입 기능을 위한 두 가지 사용
		1) 자동 주입 대상에 @Autowired 애노테이션 사용
		2) XML 설정에 <context:annotation-config/> 사용
		
	2. IoC 컨테이너
		1) BeanFactory (스프링의 IoC를 담당하는 핵심 컨테이너)
			빈을 등록/생성/조회/반환/관리 합니다.
		2) ApplicationContext(BeanFactory를 확장한 IoC 컨테이너)
			빈을 등록/생성/조회/반환/관리하는 기능은 BeanFactory와 같지만
			여기에 Spring의 각종 부가 서비스를 추가로 제공합니다.
			BeanFactory를 상속합니다.
			부가적인 기능
			- MessageSource를 지원하여 애플리케이션에서 필요한 메시지들을
				관리하는 것이 가능합니다.
			- Spring 프레임워크에서 관리하는 POJO빈들 중 ApplicationListener를
				구현하여 설정파일에 등록할 경우 등록된 리스너에서 이벤트를 전달하는 것이
				가능합니다.
			- 애플리케이션내에서 파일, URL과 같은 다양한 자원에 접근할 필요가 있습니다.
				ResourceLoader를 지원함으로 다양한 하위 레벨의 자원을
				Spring 프레임워크의 Resource 인스턴스로 생성하는 것이 가능합니다.
	3. XML 기반 빈 관리 컨테이너로 ApplicationContext 사용하기
		스프링에서는 자바 객체를 빈(Bean)이라고 합니다.
		그래서 객체 관리 컨테이너를 "빈 컨테이너" 또는 IoC컨테이너 라고 부릅니다.
		스프링은 IoC 컨테이너가 갖추어야 할 기능들을
		ApplicationContext 인터페이스에 정의해 두었습니다.
		(org.springframework.context.ApplicationContext
				빈 컨테이너가 갖추어야 할 기능을 선언한 인터페이스 입니다.)
				
		 주요 구현체들
		 - ClassPathXmlApplicationContext
		 			: 클래스 경로에 있는 빈 설정 XML파일을 찾습니다.
		 - FileSystemXmlApplicationContext 
		 			: 파일 시스템 경로에 있는 빈 설정 파일 XMl파일을 찾습니다.
		 ==>
		 1. GenericXmlApplicationContext(3.0부터 추가)가
		 	위 두 가지 컨테이너 구현 클래스가 제공하는 방식을 모두 제공
		 	
		 2. XmlWebApplicationContext
		 	: 웹 애플리케이션을 위한 IoC컨테이너로 web.xml 파일에 설정된 정보에
		 	     따라 XML 파일을 찾습니다.
 */
package com.naver.myhome1.sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_Autowired2 {

	public static void main(String[] args) {
		
		//1. Spring 컨테이너 구동
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("com/naver/myhome1/sample5/applicationContext5.xml");
		
		//2. Spring 컨테이너로부터 필요한 객체를 요청
		//MessageBean bean = (MessageBean)ctx.getBean("m3");
		MessageBean bean = ctx.getBean("m3", MessageBean.class);
		
		bean.sayHello();//메서드 호출합니다.
		ctx.close();
	}
}
