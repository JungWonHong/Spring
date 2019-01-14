package com.naver.myhome1.sample7;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloApp_Set {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("com/naver/myhome1/sample7/applicationContext.xml");
		
		//빈 팩토리 생성합니다.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
		Set<String> addressList = bean.getAddressList();
		//Set 컬렉션은 값은 데이터를 중복해서 저장하지 않습니다.
		for(String address : addressList)
			System.out.println(address.toString()); // toString() 생략되어있는 거라는걸 명시적으로 보여주기 위해 씀.
	}

}
	