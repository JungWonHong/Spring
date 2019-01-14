package com.json.jsonroot.common;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.util.StopWatch;

public class AroundAdvice {
/*
 * PreceedingJoinPoint �������̽��� JoinPoint�� ����߱� ������
   JoinPoint�� ���� ��� �޼��带 �����մϴ�.
   Around Advice������ ProceedingJoinPoint�� �Ű������� ����ϴµ�
       �� ������ proceed()�޼��尡 �ʿ��ϱ� �����Դϴ�.
   Around Advice�� ��� ����Ͻ� �޼��� ���� ���� �Ŀ� ���� �Ǵµ�
       ����Ͻ� �޼��带 ȣ���ϱ� ���ؼ��� ProceedingJoinPoint��
   proceed()�޼��尡 �ʿ��մϴ�.
       ��, Ŭ���̾�Ʈ�� ��û�� ����æ �����̽��� Ŭ���̾�Ʈ��
       ȣ���� ����Ͻ� �޼���(ServiceImpl�� get���� �����ϴ� �޼���)�� ȣ���ϱ� ����
   ProceedingJoinPoint ��ü�� �Ű� ������ �޾�
   proceed()�޼��带 ���ؼ� ����Ͻ� �޼��带 ȣ���� �� �ֽ��ϴ�.
 */
	public Object aroundLog(ProceedingJoinPoint proceeding) throws Throwable {
		System.out.println("=======>Around Advice�� before : ����Ͻ� �޼��� ���� �� �Դϴ�.");
		StopWatch sw = new StopWatch();
		sw.start();
		
		//�� �ڵ��� ������ ���Ŀ� ���� ����� ���� �ڵ带 ��ġ ��Ű�� �˴ϴ�.
		//��� ��ü�� �޼��� public void getInsert(BoardVO b)�� ȣ���մϴ�.
		//Around�� proceed() �������� ������ get�޼��� ������ ���� , �Ʒ��� �� ����.
		Object result = proceeding.proceed();
		sw.stop();
		
		System.out.println("=======>Around Advice�� after : ����Ͻ� �޼��� ���� �� �Դϴ�.");
		
		//org.aspectj.lang.Signature �������̽��� ȣ��Ǵ� �޼���� ���õ� ������ �����մϴ�.
		//String getName() : �޼����� �̸��� ���մϴ�.
		//String toLongString() : �޼��带 �����ϰ� ǥ���� ������ ���մϴ�.
		//(�޼����� ���� Ÿ��, �Ķ���� Ÿ���� ��� ǥ�õ˴ϴ�.)
		//String toShortString() : �޼��带 �����ϰ� ǥ���� ������ ���մϴ�.
		//(�⺻ ������ �޼����� �̸��� ���մϴ�.)
		Signature sig = proceeding.getSignature();
		System.out.printf("=======> %s.%s(%s) \n", 
				proceeding.getTarget().getClass().getSimpleName(), 
				sig.getName(), 
				Arrays.toString(proceeding.getArgs()));
		System.out.println("=======>" + proceeding.getSignature().getName() 
				+ "() �޼ҵ� ���� �ð� : " + sw.getTotalTimeMillis() + "(ms)��");
		System.out.println("=======>" + proceeding.getTarget().getClass().getName()); //com.json.jsonroot.dao.ServiceImpl
		
		return result;
	}
}
