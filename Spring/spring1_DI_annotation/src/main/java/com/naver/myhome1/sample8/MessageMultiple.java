/*
 * 24������ �ּ��� ��� ����
 * Could not autowire field: private com.naver.myhome1.sample8.MessageBean 
 * com.naver.myhome1.sample8.MessageMultiple.messagebean; 
 * nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: 
 * No unique bean of type [com.naver.myhome1.sample8.MessageBean] is defined: 
 * expected single matching bean but found 2: [m, m1]
 * 
 * MessageBean Ÿ���� ���� m�� m1 �� ���� �����ؼ� � ��ü�� �������� �𸣱� ������
      �߻��ϴ� �����Դϴ�.
 *
 * @Qualifier annotation�� �̿��ؼ� ���Ե� ��ü�� ���̵� �̸��� ������ �� �ֽ��ϴ�.
 * 
 * @Autowired�� @Qualifier�� �� ���� ó���� �� �ִ� ���� @Resource�Դϴ�.
 */
package com.naver.myhome1.sample8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageMultiple {

		@Autowired
		@Qualifier("m") //MessageBean�� ��ӹ޴°� �� ���ִµ� ���� m���� �����϶�
		//@Autowired �� @Qualifier("m1") �� ���� annotation ��� @Resource�� �� ���� ó������
		//@Resource(name="m1") 
		private MessageBean messagebean;
		
		public MessageMultiple() {
			System.out.println("MessageMultiple �������Դϴ�.");
		}
		
		public void print() {
			messagebean.sayHello("Spring");
		}
}
