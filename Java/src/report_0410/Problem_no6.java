package report_0410;

import java.util.Scanner;

public class Problem_no6 {

	public static void main(String[] args) {
		int listcount;	//글의 총 갯수
		int limit;		//한 페이지에 나타나는 글의 수
		int maxpage;	//총 페이지 수

		Scanner sc = new Scanner(System.in);
		
		System.out.println("한 페이지에 나타낼 수 있는 수를 입력하세요.");
		limit = sc.nextInt();
		
		System.out.println("글의 총 갯수를 입력하세요.");
		listcount = sc.nextInt();
		
		maxpage = (listcount - 1) / limit + 1;
		System.out.println("총 페이지수는 " + maxpage + "입니다.");
		
		sc.close();
	}

}
