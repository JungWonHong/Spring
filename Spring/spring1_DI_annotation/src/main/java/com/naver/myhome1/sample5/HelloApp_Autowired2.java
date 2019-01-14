/*
	1. MessageBeanImpl.java���� @Autowired����� ����
		- @Autowired�� �����ڳ� �޼���, ������� ���� ��� ����� �� �ֽ��ϴ�.
		- �ڵ� ���� ����� ����ϸ� �������� �˾Ƽ� ���� ��ü�� ã�Ƽ� ������ �ݴϴ�.
		- ��, �ش� Ÿ�Կ� �Ҵ��� �� �ִ� �� ��ü�� ã�Ƽ� �����մϴ�.
		- @Autowired �ֳ����̼��� �����ϸ� �ݵ�� ������ ���� ��ü�� �����ؾ� �մϴ�.
		- ���� @Autowired�� ���� ��ü�� �޸𸮿� ���ٸ� ������ �����̳ʰ�
		  NoSuchBeanDefinitionException�� �߻���ŵ�ϴ�.
		
		 �ڵ� ���� ����� ���� �� ���� ���
		1) �ڵ� ���� ��� @Autowired �ֳ����̼� ���
		2) XML ������ <context:annotation-config/> ���
		
	2. IoC �����̳�
		1) BeanFactory (�������� IoC�� ����ϴ� �ٽ� �����̳�)
			���� ���/����/��ȸ/��ȯ/���� �մϴ�.
		2) ApplicationContext(BeanFactory�� Ȯ���� IoC �����̳�)
			���� ���/����/��ȸ/��ȯ/�����ϴ� ����� BeanFactory�� ������
			���⿡ Spring�� ���� �ΰ� ���񽺸� �߰��� �����մϴ�.
			BeanFactory�� ����մϴ�.
			�ΰ����� ���
			- MessageSource�� �����Ͽ� ���ø����̼ǿ��� �ʿ��� �޽�������
				�����ϴ� ���� �����մϴ�.
			- Spring �����ӿ�ũ���� �����ϴ� POJO��� �� ApplicationListener��
				�����Ͽ� �������Ͽ� ����� ��� ��ϵ� �����ʿ��� �̺�Ʈ�� �����ϴ� ����
				�����մϴ�.
			- ���ø����̼ǳ����� ����, URL�� ���� �پ��� �ڿ��� ������ �ʿ䰡 �ֽ��ϴ�.
				ResourceLoader�� ���������� �پ��� ���� ������ �ڿ���
				Spring �����ӿ�ũ�� Resource �ν��Ͻ��� �����ϴ� ���� �����մϴ�.
	3. XML ��� �� ���� �����̳ʷ� ApplicationContext ����ϱ�
		������������ �ڹ� ��ü�� ��(Bean)�̶�� �մϴ�.
		�׷��� ��ü ���� �����̳ʸ� "�� �����̳�" �Ǵ� IoC�����̳� ��� �θ��ϴ�.
		�������� IoC �����̳ʰ� ���߾�� �� ��ɵ���
		ApplicationContext �������̽��� ������ �ξ����ϴ�.
		(org.springframework.context.ApplicationContext
				�� �����̳ʰ� ���߾�� �� ����� ������ �������̽� �Դϴ�.)
				
		 �ֿ� ����ü��
		 - ClassPathXmlApplicationContext
		 			: Ŭ���� ��ο� �ִ� �� ���� XML������ ã���ϴ�.
		 - FileSystemXmlApplicationContext 
		 			: ���� �ý��� ��ο� �ִ� �� ���� ���� XMl������ ã���ϴ�.
		 ==>
		 1. GenericXmlApplicationContext(3.0���� �߰�)��
		 	�� �� ���� �����̳� ���� Ŭ������ �����ϴ� ����� ��� ����
		 	
		 2. XmlWebApplicationContext
		 	: �� ���ø����̼��� ���� IoC�����̳ʷ� web.xml ���Ͽ� ������ ������
		 	     ���� XML ������ ã���ϴ�.
 */
package com.naver.myhome1.sample5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_Autowired2 {

	public static void main(String[] args) {
		
		//1. Spring �����̳� ����
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("com/naver/myhome1/sample5/applicationContext5.xml");
		
		//2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û
		//MessageBean bean = (MessageBean)ctx.getBean("m3");
		MessageBean bean = ctx.getBean("m3", MessageBean.class);
		
		bean.sayHello();//�޼��� ȣ���մϴ�.
		ctx.close();
	}
}
