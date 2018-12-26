package report_0412;
class CheckingAccount  extends Account  {
    String cardNo;     
    String name = "CheckingAccount";
    CheckingAccount(String accountNo, String ownerName, 
                    int balance, String cardNo) {
        super(accountNo, ownerName, balance);   
        this.cardNo = cardNo;
    }     
    
    int pay(String cardNo, int amount) throws Exception {
        if (!cardNo.equals(this.cardNo) || (balance < amount))
            throw new Exception("������ �Ұ����մϴ�.");
        return withdraw(amount);
    }
    
   
}
