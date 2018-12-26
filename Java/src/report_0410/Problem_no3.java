package report_0410;

import java.util.Scanner;

public class Problem_no3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		int output = ((input-1) / 10) * 10;
		
		System.out.println(output);
		
		sc.close();
	}

}
