package report_0405;

public class WalletExample {

	public static void main(String[] args) {
		Wallet.money = 10000;
		Wallet DH = new Wallet("대한이");
		Wallet MK = new Wallet("민국이");

		System.out.println(DH.name + "가 지갑에서 1000원을 가져갑니다.");
		DH.getMoney(1000);
		System.out.println(MK.name + "가 지갑에서 1000원을 가져갑니다.");
		MK.getMoney(1000);

		System.out.println("지갑에 남아 있는 돈은 " + Wallet.money + "원 입니다.");

	}

}
