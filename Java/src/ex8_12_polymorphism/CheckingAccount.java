package ex8_12_polymorphism;

public class CheckingAccount extends Account {
	String cardNo; // 직불카드 번호
	
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		//파라미터 3개의 슈퍼 클래스 생성자 호출문 
		super(accountNo, ownerName, balance);  //CheckingAccount.java와 비교.
		this.cardNo = cardNo;		
	}
	
	int pay(String cardNo, int amount) throws Exception { 
		if (!cardNo.equals(this.cardNo) || (balance < amount))
			throw new Exception("지불이 불가능합니다.");       
		return withdraw(amount);
	}

}
