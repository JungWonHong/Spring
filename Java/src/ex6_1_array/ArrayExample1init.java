package ex6_1_array;

public class ArrayExample1init {

	public static void main(String[] args) {
		int arr[]; 			// 배열 변수 선언
		arr = new int[10];  // 배열 생성
							// new에 의해 배열의 자동 초기화 - int형 : 0, double형 : 0.0
		// for(int i=0;i<10;i++)
		for (int i = 0; i < arr.length; i++) //length는 배열의 속성으로 배열의 크기를 구해준다.
			System.out.println("arr[" + i + "]" + "=" + arr[i]);

	}

}
