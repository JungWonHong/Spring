package ex7_10_in_method_call;
//Numbers2 클래스를 사용하는 프로그램
class MethodExample2 {

	public static void main(String[] args) {
		
		int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		Numbers2 obj = new Numbers2(arr);
		int total = obj.getTotal();
		int average = obj.getAverage();
		System.out.println("합계 = " + total);
		System.out.println("평균 = " + average);

	}

}
