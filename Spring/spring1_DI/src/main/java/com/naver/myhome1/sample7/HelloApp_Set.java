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
		
		//�� ���丮 �����մϴ�.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
		Set<String> addressList = bean.getAddressList();
		//Set �÷����� ���� �����͸� �ߺ��ؼ� �������� �ʽ��ϴ�.
		for(String address : addressList)
			System.out.println(address.toString()); // toString() �����Ǿ��ִ� �Ŷ�°� ��������� �����ֱ� ���� ��.
	}

}
	