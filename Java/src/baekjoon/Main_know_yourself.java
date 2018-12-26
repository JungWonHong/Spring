package baekjoon;

import java.util.Scanner;

public class Main_know_yourself {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); //�׽�Ʈ���̽� ��

		double[] P = new double[C]; //��°�.
		
		for(int i = 0; i<C;i++){
			int N = sc.nextInt(); //�׽�Ʈ���̽� �� �л� ��
			int[] T = new int[N]; //�׽�Ʈ���̽� �� ����
			for(int j=0;j<N;j++)
				T[j] = sc.nextInt();

			int sum = 0;
			for(int k=0;k<N;k++){
				sum+=T[k];
			}
			
			double avg = (double)sum / N;
			
			int cnt = 0;
			
			for(int j=0;j<N;j++){
				if(T[j]>avg)
					cnt++;
			}
			
			
			P[i] = ((double)cnt/N)*100;
				
		}
		
		for(int i=0;i<C;i++){
		System.out.printf("%.3f%%\n", (double)P[i]);
		}
		
		sc.close();

	}

}