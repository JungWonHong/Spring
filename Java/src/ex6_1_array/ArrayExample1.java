package ex6_1_array;

public class ArrayExample1 {

	public static void main(String[] args) {
		int arr[]; 			// 배열 변수를 선언, stack영역에 메모리확보
		arr = new int[10];  // 배열 생성, heap영역에 메모리생성
							// stack영역에 heap에서 생성된 배열메모리의 주소저장
		// 배열 사용
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = arr[0] + arr[1];

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
