package com.naver.myhome1.sample9;

import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloApp_Properties {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("com/naver/myhome1/sample9/applicationContext.xml");
		
		//后 蒲配府 积己钦聪促.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
		Properties addressList = bean.getAddressList();
		
		System.out.println(addressList.get("林家"));
		System.out.println(addressList.get("唱捞"));
	}

}
	