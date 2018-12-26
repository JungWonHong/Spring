package ex5_3_while;

public class WhileExample1 {

	public static void main(String[] args) {
		int cnt = 0;

		while (cnt < 10) {
			System.out.println(cnt);
			cnt++;
		}

		System.out.println("Done.");

		cnt = 0;

		while (cnt < 10) {
			System.out.println(cnt++);
		}

		System.out.println("Done.");

		cnt = -1;

		while (++cnt < 10) {
			System.out.println(cnt);
		}

		System.out.println("Done.");
	}

}
