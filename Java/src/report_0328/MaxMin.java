package report_0328;

import java.util.Scanner;

/*
 1. 세 개의 수를 입력 받아 최대값과 최소값을 구하는 프로그램
    단, if문을 사용하세요
 */
public class MaxMin {

	public static void main(String[] args) {
		int n1, n2, n3, max, min;

		Scanner sc = new Scanner(System.in);

		System.out.println("3개의 정수를 입력하세요~");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();

		if (n1 >= n2 && n1 >= n3) {
			max = n1;
			if (n2 >= n3) {
				min = n3;
			} else {
				min = n2;
			}
		} else if (n2 >= n1 && n2 >= n3) {
			max = n2;
			if (n1 >= n3) {
				min = n3;
			} else {
				min = n1;
			}
		} else {
			max = n3;
			if (n1 >= n2) {
				min = n2;
			} else {
				min = n1;
			}
		}
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		
		/*
		if (n1 > n2) {
			if (n1 > n3) {
				max = n1;
			} else {
				max = n3;
			}
		} else {
			if (n2 > n3) {
				max = n2;
			} else {
				max = n3;
			}
		}
		
		if (n1 < n2) {
			if (n1 < n3) {
				min = n1;
			} else {
				min = n3;
			}
		} else {
			if (n2 < n3) {
				min = n2;
			} else {
				min = n3;
			}
		}
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		*/
		
		sc.close();
		
	}

}
