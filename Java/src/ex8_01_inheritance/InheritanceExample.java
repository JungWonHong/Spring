package ex8_01_inheritance;

public class InheritanceExample {

	public static void main(String[] args) {
		CheckingAccount obj = new CheckingAccount();
		obj.accountNo = "111-22-33333333";	//상속받은 필드
		obj.ownerName = "홍길동";				//상속받은 필드
		obj.cardNo = "5555-6666-7777-8888";
		obj.deposit(100000);				//상속 받은 메소드
		
		try {
			int paidAmount = obj.pay("5555-6666-7777-8888", 47000);
			System.out.println("지불액:" + paidAmount);
			System.out.println("잔액:" + obj.balance);
			paidAmount = obj.pay("5555-6666-7777-8888", 3000);
			System.out.println("지불액:" + paidAmount);
			System.out.println("잔액:" + obj.balance);
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}

	}

}
