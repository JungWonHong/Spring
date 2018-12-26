package ex4_08_concate_op;

public class ConcatExample1 {

	public static void main(String[] args) {
		//연산의 순서는 왼쪽에서 오른쪽으로
		String str1 = "num=" + 3 + 4;
		String str2 = 3 + 4 + "=num";
		String str3 = "num=" + (3 + 4);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	
		
	}

}
