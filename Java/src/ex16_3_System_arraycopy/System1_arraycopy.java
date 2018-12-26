package ex16_3_System_arraycopy;

public class System1_arraycopy {

	public static void main(String[] args) {
		char arr1[] = { '가', '나', '다', '라', '마', '바', '사', '아', '자', '차', '카', '타', '파', '하' };
		char arr2[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' };
		
		// System.arraycopy(원본 배열, 원본 항목 시작 위치, 복사 대상 배열, 복사 대상 항목 시작 위치, 복사할 항목의 수);
		System.arraycopy(arr1, 10, arr2, 2, 3);
		// arr1[10]~arr1[12]의 값을 arr2[2]~arr2[4]에 복사

		for (char ch : arr2)
			System.out.print(ch + "  ");
	}

}
