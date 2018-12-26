package ex6_1_array;

import java.util.Scanner;

public class ArrayTest07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] names = new String[] { "갓영재", "전우치", "세종대왕", "갓영재", "이순신", "신사임당" };
		String input;
		int index = -1;
		
		System.out.println("검색할 이름을 입력하세요?");
		System.out.print("이름:");
		input = sc.next();

		for (int i = 0; i < names.length; i++) {
			if (input.equals(names[i])) {
				index = i;
				break;
			}	
		}

		if (index != -1)
			System.out.println(input + "은(는) 배열의 " + index + "방에서 찾았습니다.");
		else
			System.out.println(input + "은(는) 배열방에서 찾지 못했습니다.");
		
		sc.close();
	}

}
