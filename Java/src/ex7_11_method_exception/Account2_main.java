package ex7_11_method_exception;

public class Account2_main {

	public static void main(String[] args) {
		Account2 obj = new Account2("777-777-77777777", "최대박", 10);

		try {
			int amount = obj.withdraw(100000000);
			System.out.println("인출액:" + amount);
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}

	}

}
