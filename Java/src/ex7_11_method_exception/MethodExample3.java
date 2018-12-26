package ex7_11_method_exception;

//Numbers2 클래스를 사용하는 프로그램
class MethodExample3 {

	public static void main(String[] args) {

		int arr[] = new int[0]; // 길이가 0인 배열을 생성
		Numbers obj = new Numbers(arr);
		int average = obj.getAverage();// 이 메소드 안에서 익셉션이 발생
		// 0으로 나눌수 없기 때문에 에러발생.
		System.out.println("평균 = " + average);

	}

}
