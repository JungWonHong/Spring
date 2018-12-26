package ex19_3_Serializable_interface;

import java.io.*;

public class ObjectInputExample2 {

	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output2.dat"));
			while (true) {
				GoodsStock gstock = (GoodsStock) in.readObject();
				String code = gstock.code;
				int num = gstock.num;
				System.out.println("상품코드:" + code + "\t상품수량" + num);
			}
		} catch (FileNotFoundException fe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (EOFException eofe) { // 파일로부터 더이상 읽을 객체가 없을 때 발생하는 예외 처리
			System.out.println("끝");
		} catch (IOException ie) {
			System.out.println();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스가 존재하지 않습니다.");
		} finally {
			try {
				in.close();
			} catch (Exception e) {

			}
		}
	}

}
