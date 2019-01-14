package com.json.jsonroot.common;

import org.aspectj.lang.JoinPoint;

//JoinPoint �������̽��� �޼���
//Signature getSignature() : ȣ��Ǵ� �޼��忡 ���� ������ ���մϴ�.
//Object getTarget() : Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼��带 �����ϴ� ����Ͻ� ��ü�� ���մϴ�.
//Object[] getArgs() : Ŭ���̾�Ʈ�� �޼��带 ȣ���� �� �Ѱ��� ���� ����� Object �迭�� �����մϴ�.

//�������� ó���� ������ BeforeAdvice Ŭ������ beforeLog()�޼���� �����մϴ�.
//Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ�  ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
public class BeforeAdvice {
	public void beforeLog(JoinPoint proceeding) {
		System.out.println("=======>BeforeAdvice : ����Ͻ� ���� ���� �� �����Դϴ�.");
		
		System.out.println("=======>" 
				+ proceeding.getTarget().getClass().getName() + "��" 
				+ proceeding.getSignature().getName() + " ȣ���մϴ�.");
	}
	
}
