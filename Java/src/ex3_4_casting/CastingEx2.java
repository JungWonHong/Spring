package ex3_4_casting;

public class CastingEx2 {

	public static void main(String[] args) {
		int i1 = 10;
		
		double d1 = i1; //묵시적 형변환
		
		System.out.println("d1 데이타는 " + d1 + "입니다.");
		
		/*
		double d2 = 10.0;
		int i2 = d2; //에러발생 : cannot convert from double to int
		System.out.println("i2 데이타는 " + i2 + "입니다.");
		*/
		
		//에러 수정 - double -> int
		double d2 = 10.1234;
		int i2 = (int)d2; //명시적 형변환
		System.out.println("i2 데이터는 " + i2 + "입니다.");
		
	}

}
