// int -> String  만드는 방법 2가지
package ex14_1_Wrapper;

public class Wrapper3_1_int_to_String {

	public static void main(String[] args) {
		int i = 10;
		//방법1. Integer.toString() 사용
		String age = Integer.toString(i);
		
		//방법2. + 연산자 사용
		String age2 = "" + 10; //"" + i
		String age3 = "" + i;
		
		System.out.println(age);
		System.out.println(age2);
		System.out.println(age3);
	}

}
