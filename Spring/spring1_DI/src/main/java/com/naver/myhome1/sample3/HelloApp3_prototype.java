package com.naver.myhome1.sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class HelloApp3_prototype {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext2.xml");

		BeanFactory factory = new XmlBeanFactory(resource);
		MessageBean bean1 = (MessageBean) factory.getBean("m1");
		MessageBean bean2 = (MessageBean) factory.getBean("m1");
		MessageBean bean3 = (MessageBean) factory.getBean("m1");
		MessageBean bean4 = (MessageBean) factory.getBean("m1");
	}

}
