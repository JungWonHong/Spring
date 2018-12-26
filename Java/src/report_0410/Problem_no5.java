package report_0410;

import java.util.Scanner;

public class Problem_no5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int page = sc.nextInt();
		int startpage = ((page -1) / 10) * 10 +1;
		
		System.out.println(startpage);
		
		sc.close();

	}

}
