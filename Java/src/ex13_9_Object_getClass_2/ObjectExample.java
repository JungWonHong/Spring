package ex13_9_Object_getClass_2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectExample {

	public static void main(String[] args) {
		Rectangle obj = new Rectangle(10, 20);
		// getClass() : 객체가 속하는 클래스의 정보를 알아내는 메소드
		// getClass 메소드는 객체가 속하는 클래스의 정보를 Class타입의 객체로 만들어서 리턴
		Class cls = obj.getClass();

		String name = cls.getName(); // getName():클래스의 이름을 리턴하는 메소드
		System.out.println("클래스 이름(패키지 포함한 클래스 이름) : " + name);
		System.out.println("클래스 이름(패키지 제외한 클래스 이름) : " + cls.getSimpleName());

		Class superCls = cls.getSuperclass(); // 슈퍼 클래스의 정보를 리턴하는 메소드
		String superName = superCls.getName(); // 슈퍼 클래스의 이름을 리턴하는 메소드
		System.out.println("슈퍼클래스 이름: " + superName);

		Field field[] = cls.getDeclaredFields(); // 클래스에 선언되어 있는 필드
		System.out.println("필드: ");
		for (int cnt = 0; cnt < field.length; cnt++)
			System.out.println("   " + field[cnt]);

		Method method[] = cls.getDeclaredMethods(); // 클래스에 선언되어 있는 메소드
		System.out.println("필드: ");
		for (int cnt = 0; cnt < method.length; cnt++)
			System.out.println("   " + method[cnt]);

	}

}
