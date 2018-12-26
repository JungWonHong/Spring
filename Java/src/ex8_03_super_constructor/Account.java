package ex8_03_super_constructor;

//모든 클래스의 조상은 Object 클래스입니다.
//다른 클래스로부터 상속 받지 않는 모든 클래스들은 자동적으로
//Object 클래스로 부터 상속 받습니다.
public class Account { //컴파일러가 extends Object를 추가합니다.
	String accountNo; //계좌번호
	String ownerName; //예금주 이름
	int balance;	  //잔액

	Account(){ }  //부모 클래스에서 다른생성자가 정의되어있으면 기본생성자는 자동으로 생기지 않는다.
				  //따로 기본생성자를 정의해 주지않으면 자식클래스에서 생성자를 만들때 오류가 발생한다.
				  //자식클래스에서 생성자를 만들면 생성자 내부에 묵시적으로 부모클래스의 기본생성자를 호출한다.
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
