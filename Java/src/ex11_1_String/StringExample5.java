//String 생성자는 각각 별도의 String 객체를 생성하기 때문에
//객체 변수의 주소값이 다르다.
package ex11_1_String;

public class StringExample5 {

	public static void main(String[] args) {
		String str1 = new String("자바");
		String str2 = new String("자바");
		
		if(str1.equals(str2))
			System.out.println("str1.equals(str2) 같음");
		else
			System.out.println("str1.equals(str2) 다름");
	}

}
