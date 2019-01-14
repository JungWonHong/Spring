package com.naver.myhome1.sample8;

import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloApp_Map {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("com/naver/myhome1/sample8/applicationContext.xml");
		
		//�� ���丮 �����մϴ�.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
		Map<String, String> addressList = bean.getAddressList();
		
		System.out.println(addressList.get("�ּ�"));
		System.out.println(addressList.get("����"));
	}

}
	