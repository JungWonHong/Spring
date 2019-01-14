package com.naver.myhome1.sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//�������� �̿��Ͽ� Ŭ���� ������ ���ջ��¸� �����ϰ� ����ϴ�.
public class HelloApp1_comment {

	public static void main(String[] args) {
		/*
		 * Resource ���� Ŭ������ ClassPathResource�Դϴ�.
		 * �������̽� Resource�� �پ��� ������ �ڿ��� ������ ������� �����Ͽ�
		 * ǥ���� �� �ְ� ���ݴϴ�.
		 * org.springframework.core.io.ClassPathResource
		 *  : ClassPath�� �ִ� �ڿ��� �����մϴ�.
		 */
		Resource resource = new ClassPathResource("applicationContext.xml");
		// applicationContext.xml(������ ��������) ������ ����ϰ� �ֽ��ϴ�.
		// ������ �������ϸ��� �ٸ��̸����� �����ص� ��������ϴ�.
		
		/*
		 * �������̽�  BeanFactory : Bean ��ü�� �����ϰ�,
		 * �� Bean��ü���� �������踦 �����ϴ� ���� �ܼ��� �����̳��Դϴ�.
		 * BeanFactory�� ������ Ŭ������ XmlBeanFactory �Դϴ�.
		 * XmlBeanFactory ��ü ������ ���� ������ ��ġ�� �˷���� �մϴ�.
		 */
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MessageBean bean = (MessageBean) factory.getBean("m");
		bean.sayHello("Spring");
	}
}
