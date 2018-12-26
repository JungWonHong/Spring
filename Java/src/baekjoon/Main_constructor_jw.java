package baekjoon;

public class Main_constructor_jw {

	public static void main(String[] args) {
		int[] N = new int[10000];
		int[] n = new int[10000];
		for (int i = 0; i < N.length; i++) {
			N[i] = i + 1;
			n[i] = d(i + 1);
		}

		for (int i = 0; i < N.length; i++) {
			int cnt = 0;
			for (int j = 0; j < n.length; j++) {
				if (N[i] == n[j])
					cnt++;
			}
			if (cnt == 0)
				System.out.println(N[i]);
		}

	}

	static int d(int n) {
		int result = 0;

		if (n >= 10000) {
			result = n + n / 10000 + (n % 10000) / 1000 + ((n % 10000) % 1000) / 100 + (((n % 10000) % 1000) % 100) / 10
					+ (((n % 10000) % 1000) % 100) % 10;
		} else if (n >= 1000 && n < 10000) {
			result = n + n / 1000 + (n % 1000) / 100 + ((n % 1000) % 100) / 10 + ((n % 1000) % 100) % 10;
		} else if (n >= 100 && n < 1000) {
			result = n + n / 100 + (n % 100) / 10 + (n % 100) % 10;
		} else if (n >= 10 && n < 100) {
			result = n + n / 10 + n % 10;
		} else if (n > 0 && n < 10) {
			result = n + n;
		}

		return result;
	}

}
