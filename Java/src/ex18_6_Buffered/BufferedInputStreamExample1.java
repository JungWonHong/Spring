package ex18_6_Buffered;

import java.io.*;

public class BufferedInputStreamExample1 {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("파일명을 Arguments탭에 output1.dat 입력해 주세요.");
			return;
		}

		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(args[0])); //파일을 연
			byte arr[] = new byte[16]; // byte 단위로 데이터를 읽기 때문에 byte 형 사용
			while (true) {
				//버커크기만큼 데이터를 한꺼번에 읽어 온 후 16바이트 리턴
				int num = in.read(arr); 
				
				if (num < 0)
					break;

				// 읽어들인 바이트 데이터를 16진수로 출력한다.
				for (int cnt = 0; cnt < num; cnt++)
					System.out.printf("%02X ", arr[cnt]);
				// %02X : 2자리 16진수(%X)로 출력하되,
				// 대문자(X가 대문자임)로 출력하면서 숫자가 한 자리이면 앞자리를 0으로 채운다
				// %02x : 2자리 16진수(%x)로 출력하되,
				// 소문자(x가 소문자임)로 출력하면서 숫자가 한 자리이면 앞자리를 0으로 채운다

				//System.out.println();

				//for (int cnt = 0; cnt < num; cnt++)
				//	System.out.printf("%d ", arr[cnt]);
			}
		} catch (FileNotFoundException fe) {
			System.out.println(args[0] + " 파일을 찾을 수 없습니다.");
		} catch (IOException ie) {
			System.out.println(args[0] + " 파일을 읽을 수 없습니다.");
		} finally {
			try {
				in.close(); // 파일을 닫습니다.
			} catch (Exception e) {
			}
		}
	}
}
