package com.json.jsonroot.dao;

//공통으로 처리할 로직을 LogAdvice 클래스에 beforeLog() 메서드로 ㄱ현합니다.
public class LogAdvice {
	
	public void beforeLog() {
		System.out.println("=======>LogAdvice : 비즈니스 로진 수행 전 동작입니다.");
	}
	
}
