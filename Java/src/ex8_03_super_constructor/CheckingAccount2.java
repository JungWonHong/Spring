package ex8_03_super_constructor;
//슈퍼 클래스의 생성자를 호출하는 직불 계좌 클래스
public class CheckingAccount2 extends Account {
	String cardNo; // 직불카드 번호
	
	//에러해결:
	//컴파일러는 생성자 안에 슈퍼 클래스의 생성자 호출문이 있으면
	//no-arg constructor호출문을 추가하지 않기 때문에
	//슈퍼 클래스의 생성자 호출문을 추가합니다.
	//슈퍼 클래스의 생성자 호출 키워드는 super (this는 자기자신)
	//슈퍼 클래스의 생성자 호출문을 생성자의 첫 번째 명령문에 놓아야한다.
	public CheckingAccount2(String accountNo, String ownerName, int balance, String cardNo) {
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
