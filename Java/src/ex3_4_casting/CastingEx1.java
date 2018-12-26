package ex3_4_casting;

public class CastingEx1 {

	public static void main(String[] args) {
		int i1 = 10;
		
		double d1 = i1; //묵시적 형변환
		
		System.out.println("d1 데이타는 " + d1 + "입니다.");
		
//		double d2 = 10.0;
//		int i2 = d2; //에러발생 : cannot convert from double to int
//		System.out.println("i2 데이타는 " + i2 + "입니다.");
	}

}
