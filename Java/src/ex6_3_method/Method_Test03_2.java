package ex6_3_method;

public class Method_Test03_2 {

	public static void main(String[] args) {

		int n1 = 10, n2 = 1;
		System.out.println("변경 전 : n1= " + n1 + "\t n2= " + n2);
		int imsi = n2;
		n2 = n1;
		n1 = imsi;
		System.out.println("변경 후 : n1= " + n1 + "\t n2= " + n2);

	}

}
