package ex9_03_upcasting_override;
class Account { 
    String accountNo;
    String ownerName;
    int balance;
    Account(String accountNo, String ownerName, int balance) {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    void deposit(int amount) {
        balance += amount;
    }
    int withdraw(int amount) throws Exception {
        if (balance < amount)
            throw new Exception("잔액이 부족합니다.");
        balance -= amount;
        return amount;
    }
    
    void override(){
    	System.out.println("여기는 Account 클래스의 메서드 입니다.");
    }
}
