/* 디자인 패턴 이용하기
 * Factory 패턴을 이용하는 방법으로 클라이언트에서 사용할 객체 생성을 캡슐화하여
      메소드의 매개변수에 따라 객체를 생성합니다.
   ==> 내가 필요한 객체를 직접 생성하지 않고 단지 어떤 객체가 필요한지 BeanFactory에 요청하면
       BeanFactory가 생성하여 넘겨줍니다.
 */
package com.naver.myhome1.sample2_2;

public class HelloApp_Factory {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		MessageBean bean = (MessageBean)factory.getBean("MessageBeanEn");
		bean.sayHello("spring");
	}

}
