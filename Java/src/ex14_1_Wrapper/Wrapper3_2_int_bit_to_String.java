/*
 * ������Ƽ�� Ÿ���� ��Ʈ ������ ���ڿ��� �����ϴ� �޼ҵ�
 * 1. toBinaryString �޼ҵ� : 2����
 * 2. toOctalString  �޼ҵ� : 8����
 * 3. toHexString    �޼ҵ� : 16����
 */
package ex14_1_Wrapper;

public class Wrapper3_2_int_bit_to_String {

	public static void main(String[] args) {
		int total = 0;
		args = new String[1];
		args[0] = "12";
		for (int cnt = 0; cnt < args.length; cnt++)
			// ���ڷ� ���� ���ڿ��� intŸ���� ������ �ٲپ �ջ��մϴ�.
			total += Integer.parseInt(args[cnt]);
		
		System.out.println(total);

		System.out.println("10���� : " + total + "\t 2���� : " + Integer.toBinaryString(total));
		System.out.println("10���� : " + total + "\t 8���� : " + Integer.toOctalString(total));
		System.out.println("10���� : " + total + "\t 16���� : " + Integer.toHexString(total));

	}

}
