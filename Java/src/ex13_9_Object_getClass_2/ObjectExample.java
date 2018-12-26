package ex13_9_Object_getClass_2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectExample {

	public static void main(String[] args) {
		Rectangle obj = new Rectangle(10, 20);
		// getClass() : ��ü�� ���ϴ� Ŭ������ ������ �˾Ƴ��� �޼ҵ�
		// getClass �޼ҵ�� ��ü�� ���ϴ� Ŭ������ ������ ClassŸ���� ��ü�� ���� ����
		Class cls = obj.getClass();

		String name = cls.getName(); // getName():Ŭ������ �̸��� �����ϴ� �޼ҵ�
		System.out.println("Ŭ���� �̸�(��Ű�� ������ Ŭ���� �̸�) : " + name);
		System.out.println("Ŭ���� �̸�(��Ű�� ������ Ŭ���� �̸�) : " + cls.getSimpleName());

		Class superCls = cls.getSuperclass(); // ���� Ŭ������ ������ �����ϴ� �޼ҵ�
		String superName = superCls.getName(); // ���� Ŭ������ �̸��� �����ϴ� �޼ҵ�
		System.out.println("����Ŭ���� �̸�: " + superName);

		Field field[] = cls.getDeclaredFields(); // Ŭ������ ����Ǿ� �ִ� �ʵ�
		System.out.println("�ʵ�: ");
		for (int cnt = 0; cnt < field.length; cnt++)
			System.out.println("   " + field[cnt]);

		Method method[] = cls.getDeclaredMethods(); // Ŭ������ ����Ǿ� �ִ� �޼ҵ�
		System.out.println("�ʵ�: ");
		for (int cnt = 0; cnt < method.length; cnt++)
			System.out.println("   " + method[cnt]);

	}

}
