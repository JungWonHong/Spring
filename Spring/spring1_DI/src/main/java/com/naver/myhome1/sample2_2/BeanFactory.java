package com.naver.myhome1.sample2_2;

public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("MessageBeanEn")) {
			return new MessageBeanEn();
		}else if(beanName.equals("MessageBeanKo")) {
			return new MessageBeanKo();
		}
		return null;
	}
}
