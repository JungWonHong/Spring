package ex7_10_in_method_call;
//Numbers2 Ŭ������ ����ϴ� ���α׷�
class MethodExample2 {

	public static void main(String[] args) {
		
		int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		Numbers2 obj = new Numbers2(arr);
		int total = obj.getTotal();
		int average = obj.getAverage();
		System.out.println("�հ� = " + total);
		System.out.println("��� = " + average);

	}

}
