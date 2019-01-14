/*
 * 24라인이 주석인 경우 에러
 * Could not autowire field: private com.naver.myhome1.sample8.MessageBean 
 * com.naver.myhome1.sample8.MessageMultiple.messagebean; 
 * nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: 
 * No unique bean of type [com.naver.myhome1.sample8.MessageBean] is defined: 
 * expected single matching bean but found 2: [m, m1]
 * 
 * MessageBean 타입의 빈이 m과 m1 두 개가 존재해서 어떤 객체를 주입할지 모르기 때문에
      발생하는 예외입니다.
 *
 * @Qualifier annotation을 이용해서 주입될 객체의 아이디나 이름을 지정할 수 있습니다.
 * 
 * @Autowired와 @Qualifier을 한 번에 처리할 수 있는 것이 @Resource입니다.
 */
package com.naver.myhome1.sample8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageMultiple {

		@Autowired
		@Qualifier("m") //MessageBean을 상속받는게 두 개있는데 그중 m으로 접근하라
		//@Autowired 와 @Qualifier("m1") 두 개의 annotation 대신 @Resource로 한 번에 처리가능
		//@Resource(name="m1") 
		private MessageBean messagebean;
		
		public MessageMultiple() {
			System.out.println("MessageMultiple 생성자입니다.");
		}
		
		public void print() {
			messagebean.sayHello("Spring");
		}
}
