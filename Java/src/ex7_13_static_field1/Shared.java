package ex7_13_static_field1;

public class Shared {

	public static void main(String[] args) {
		StaticCount sc1 = new StaticCount();
		System.out.println("sc1.number = " + sc1.number);

		sc1.number++;
		System.out.println("sc1.number = " + sc1.number);

		StaticCount sc2 = new StaticCount();
		System.out.println("sc2.number = " + sc2.number);

		sc2.number++;
		System.out.println("sc2.number = " + sc2.number);
		// ���� �ʵ�(��� ����) ���� : Ŭ������.���� ��� �����̸�
		// �޸𸮿� �׻� �����ϱ� ������ ���� ������ ����� ���� ����ϸ� �ȴ�.
		StaticCount.number++;
		System.out.println("StaticCount.number = " + StaticCount.number);

	}

}
