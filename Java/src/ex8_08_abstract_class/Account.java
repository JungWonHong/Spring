package ex8_08_abstract_class;
//인스턴스화를 금지하는 abstract키워드
//abstract 키워드가 붙은 클래스를 추상클래스라고 한다.
abstract class Account {
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
