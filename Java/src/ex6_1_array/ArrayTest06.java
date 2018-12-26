package ex6_1_array;

import java.util.Scanner;

public class ArrayTest06 {

	public static void main(String[] args) {
		// String[] names = { "홍길동", "전우치", "홍길동", "세종대왕", "김길동" };
		// 아래와 같은 의미
		String[] names = new String[] { "홍길동", "전우치", "홍길동", "세종대왕", "김길동" };

		Scanner sc = new Scanner(System.in);
		String input;
		int cnt = -1;

		System.out.println("검색할 이름을 입력하세요?");
		System.out.print("이름:");
		input = sc.next();

		for (int i = 0; i < names.length; i++) {
			if (input.equals(names[i]))
				cnt = i;
		}

		if (cnt == -1)
			System.out.println(input + "은(는) 배열방에서 찾지 못했습니다.");
		else
			System.out.println(input + "은(는) 배열의 [" + cnt + "]방에서 찾았습니다.");

		sc.close();
	}

}
