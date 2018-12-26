package ex7_11_method_exception;

//Numbers2 클래스를 사용하는 프로그램
class MethodExample4 {

	public static void main(String[] args) {

		int arr[] = new int[0]; // 길이가 0인 배열을 생성
		Numbers obj = new Numbers(arr);
		try { // 문제가 발생할 수 있는 부분을 try로 묶는다.
			int average = obj.getAverage();// 이 메소드 안에서 익셉션이 발생
			// 0으로 나눌수 없기 때문에 에러발생.
			System.out.println("평균 = " + average);
		} catch (java.lang.ArithmeticException e) {
			System.out.println("평균을 계산하는 도중 에러가 발생했습니다.");
		}
	}

}
