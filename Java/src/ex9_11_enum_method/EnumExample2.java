package ex9_11_enum_method;
/*
 * ���� Ÿ�Կ� ���� valueOf �޼ҵ带 ȣ���ϴ� ��
 * public static ex9_11_enum_method.Day valuesOf(java.lang.String);
 * 		==> ���� ����� �̸��� ���ڿ��� �Ѱ��ָ� �׿� �ش��ϴ� ���� ����� �����ϴ� �޼ҵ�
 */
public class EnumExample2 {

	public static void main(String[] args) {
		printDay("MONDAY");
		printDay("TUESDAY");
		printDay("FRIDAY");
		//printDay("FRIDAY2"); //�������� ���� ��� �̱� ������ �������.
	}
	
	static void printDay(String name){
		Day day = Day.valueOf(name);
		System.out.println(day);
	}

}
