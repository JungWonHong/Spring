package com.json.jsonroot.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//JoinPoint 인터페이스의 메서드
//Signature getSignature() : 호출되는 메서드에 대한 정보를 구합니다.
//Object getTarget() : 클라이언트가 호출한 비즈니스 메서드를 포함하는 비즈니스 객체를 구합니다.
//Object[] getArgs() : 클라이언트가 메서드를 호출할 때 넘겨준 인자 목록을 Object 배열로 리턴합니다.

//공통으로 처리할 로직을 BeforeAdvice 클래스에 beforeLog()메서드로 구현합니다.
//Advice : 횡단 관심에 해당하는 공통 기능을 의미하며  독립된 클래스의 메서드로 작성됩니다.
//Advice 클래스는 스프링 설정 파일에서 <bean>으로 등록하거나
//@Service annotation을 사용합니다.
//@Service
//@Aspect
public class AfterAdvice {
	
	@Pointcut("execution(* com.json.jsonroot..*Impl.get*(..))")
	public void getPointcut() {}
	
	/*
	 * @After : 비즈니스 메서드 실행 후에 동작합니다.
	 * @After("getPointcut()") : getPointcut() 참조 메서드로 지정한 메서드가 실행 후에 
	 * 							 Advice의 메서드 afterLog()가 호출됩니다.
	 */
	@After("getPointcut()")
	public void afterLog(JoinPoint proceeding) {
		System.out.println("=======>" 
				+ proceeding.getTarget().getClass().getName() + "의" 
				+ proceeding.getSignature().getName() + " 호출 후 입니다.");
		
		System.out.println("=======>AfterAdvice : 비즈니스 로직 수행 후 동작입니다.");
	}
	
}
