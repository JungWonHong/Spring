package baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1;i<=100;i++){
			sum += i;
		}
		System.out.println(sum);
		/*Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		int tmp = 0;
		while (N > sum) {
			tmp++;
			sum += tmp;
		}
		int a =1,b=1;
		
		if(tmp%2!=0){
			
		}
		sc.close();*/
/*		String str = "정보처리기사,정보보안기사,";
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}*/
	}
}
