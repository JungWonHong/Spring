package com.json.jsonroot.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//JoinPoint �������̽��� �޼���
//Signature getSignature() : ȣ��Ǵ� �޼��忡 ���� ������ ���մϴ�.
//Object getTarget() : Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼��带 �����ϴ� ����Ͻ� ��ü�� ���մϴ�.
//Object[] getArgs() : Ŭ���̾�Ʈ�� �޼��带 ȣ���� �� �Ѱ��� ���� ����� Object �迭�� �����մϴ�.

//�������� ó���� ������ BeforeAdvice Ŭ������ beforeLog()�޼���� �����մϴ�.
//Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ�  ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
//Advice Ŭ������ ������ ���� ���Ͽ��� <bean>���� ����ϰų�
//@Service annotation�� ����մϴ�.
//@Service
//@Aspect
public class AfterAdvice {
	
	@Pointcut("execution(* com.json.jsonroot..*Impl.get*(..))")
	public void getPointcut() {}
	
	/*
	 * @After : ����Ͻ� �޼��� ���� �Ŀ� �����մϴ�.
	 * @After("getPointcut()") : getPointcut() ���� �޼���� ������ �޼��尡 ���� �Ŀ� 
	 * 							 Advice�� �޼��� afterLog()�� ȣ��˴ϴ�.
	 */
	@After("getPointcut()")
	public void afterLog(JoinPoint proceeding) {
		System.out.println("=======>" 
				+ proceeding.getTarget().getClass().getName() + "��" 
				+ proceeding.getSignature().getName() + " ȣ�� �� �Դϴ�.");
		
		System.out.println("=======>AfterAdvice : ����Ͻ� ���� ���� �� �����Դϴ�.");
	}
	
}
