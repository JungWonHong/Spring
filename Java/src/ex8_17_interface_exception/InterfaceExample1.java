package ex8_17_interface_exception;

public class InterfaceExample1 {

	public static void main(String[] args) {
		SeparateVolume2 obj = new SeparateVolume2("863.ㅂ", "나무", "베르베르");
		bookPossible(obj, "이수경", "20161012");
		bookPossible(obj, "강감찬", "20161012");
	}

	static void bookPossible(SeparateVolume2 obj, String borrower, String date) {
		try {
			obj.checkOut(borrower, date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
