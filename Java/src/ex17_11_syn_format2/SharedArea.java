package ex17_11_syn_format2;

public class SharedArea {
	Account account1; // 이몽룡의 계좌
	Account account2; // 성춘향의 계좌

	//동기화 메소드
	synchronized void transfer() { // 계좌 이체를 한다
			account1.withdraw(1000000);

			account2.deposit(1000000);
	}
	
	//동기화 메소드
	synchronized int getTotal() {// 잔액 합계를 구한다
			return account1.balance + account2.balance;
	}
}
