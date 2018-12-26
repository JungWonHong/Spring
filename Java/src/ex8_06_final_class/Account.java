package ex8_06_final_class;

//상속을 금지하는 final 키워드
public final class Account {
	String accountNo; 
	String ownerName; 
	int balance;	 

	Account(String accountNo, String ownerName, int balance){
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	void deposit(int amount) { //예금한다.
		balance += amount;
	}

	int withdraw(int amount) throws Exception { //인출한다.
		if (balance < amount)
			throw new Exception("잔액이 부족합니다.");
		balance -= amount;
		return amount;
	}

}
