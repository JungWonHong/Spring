package ex4_08_concate_op;

public class ConcatExample1 {

	public static void main(String[] args) {
		//������ ������ ���ʿ��� ����������
		String str1 = "num=" + 3 + 4;
		String str2 = 3 + 4 + "=num";
		String str3 = "num=" + (3 + 4);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	
		
	}

}
