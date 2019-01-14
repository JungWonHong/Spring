package com.naver.myhome1.sample9;

import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloApp_Properties {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("com/naver/myhome1/sample9/applicationContext.xml");
		
		//�� ���丮 �����մϴ�.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
		Properties addressList = bean.getAddressList();
		
		System.out.println(addressList.get("�ּ�"));
		System.out.println(addressList.get("����"));
	}

}
	