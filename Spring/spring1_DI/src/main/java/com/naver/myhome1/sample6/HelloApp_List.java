package com.naver.myhome1.sample6;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloApp_List {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("com/naver/myhome1/sample6/applicationContext.xml");
		
		//빈 팩토리 생성합니다.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
		List<String> list = bean.getAddressList();
		for(String str : list)
			System.out.println(str.toString()); // toString() 생략되어있는 거라는걸 명시적으로 보여주기 위해 씀.
	}

}
	