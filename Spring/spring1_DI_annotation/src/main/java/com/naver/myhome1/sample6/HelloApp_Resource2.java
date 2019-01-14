/*
 * MessageBeanImpl.java에서 @Resource 사용해 보기
 	- @Autowired는 변수의 타입을 기준으로 검색하여 의존성 주입을 처리하지만
 	  @Resource는 개체의 이름을 이용하여 의존성 주입을 처리합니다.
 	- 생성자에는 적용할 수 없고 필드나 메서드에만 적용할 수 있습니다.
 	
 	자동 주입 기능을 위한 두 가지 사용
 	1) 자동 주입 대상에 @Resource 애노테이션 사용
 	2) XML 설정에 <context:annotation-config/> 사용
 */
package com.naver.myhome1.sample6;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_Resource2 {

	public static void main(String[] args) {
		
		//1. Spring 컨테이너 구동
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:com/naver/myhome1/sample6/applicationContext6.xml");
		
		//2. Spring 컨테이너로부터 필요한 객체를 요청
		//MessageBean bean = (MessageBean)ctx.getBean("m3");
		MessageBean bean = ctx.getBean("m3", MessageBean.class);
		
		bean.sayHello();//메서드 호출합니다.
		ctx.close();
	}
}
