package ex8_02_constructor;

//모든 클래스의 조상은 Object 클래스입니다.
//다른 클래스로부터 상속 받지 않는 모든 클래스들은 자동적으로
//Object 클래스로 부터 상속 받습니다.
public class Account { //컴파일러가 extends Object를 추가합니다.
	String accountNo; //계좌번호
	String ownerName; //예금주 이름
	int balance;	  //잔액

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
