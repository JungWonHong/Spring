package ex7_11_method_exception;

public class Account2 {
	String accountNo;
	String ownerName;
	int balance;

	Account2(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) throws Exception {
		if (balance < amount)
			throw new Exception("잔액이 부족합니다."); //일부러 에러발생
		//이걸 호출 했던곳에서 처리하도록 요청하기 위함. 에러가 발생하면 뒷부분 실행X
		//메소드 선언시 뒷부분에 throws Exception을 슨다.
		balance -= amount;
		return amount;
	}
}
