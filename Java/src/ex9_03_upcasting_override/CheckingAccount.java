package ex9_03_upcasting_override;
class CheckingAccount  extends Account  {
    String cardNo;                                       
    CheckingAccount(String accountNo, String ownerName, 
                    int balance, String cardNo) {
        super(accountNo, ownerName, balance);   
        this.cardNo = cardNo;
    }     
    
    int pay(String cardNo, int amount) throws Exception {
        if (!cardNo.equals(this.cardNo) || (balance < amount))
            throw new Exception("지불이 불가능합니다.");
        return withdraw(amount);
    }
    
    void override(){
    	System.out.println("여기는 CheckingAccount 클래스의 오버라이딩 한 메서드 입니다.");
    }
}
