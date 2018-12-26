package ex6_2_sort;

public class Rank {

	public static void main(String[] args) {
		int a[][] = { { 30, 1 }, 
				      { 20, 1 }, 
				      { 10, 1 }, 
				      { 40, 1 }, 
				      { 50, 1 } };

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++)
				if (a[i][0] < a[j][0])
					a[i][1]++;
		}

		System.out.print("원본\t등수\n");
		for (int k = 0; k < a.length; k++)
			System.out.print(a[k][0] + "\t" + a[k][1] + "\n");
	}
}
