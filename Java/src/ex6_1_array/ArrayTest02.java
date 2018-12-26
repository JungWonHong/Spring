package ex6_1_array;

import java.util.Scanner;

public class ArrayTest02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("정수 5개를 입력하세요?");

		int num[] = new int[5];
		int sum = 0;
		double avg = 0;

		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			sum += num[i];
		}

		avg = (double) sum / num.length; // 형변환 해줘야한다. 안해줘도 오류는 안뜨지만 
										 // 정수형끼리의 계산이므로 몫만 출력된다.	
		System.out.println("합 = " + sum);
		System.out.println("평균 = " + avg);

		sc.close();

	}

}
