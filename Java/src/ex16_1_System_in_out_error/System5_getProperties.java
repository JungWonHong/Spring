//�ý��� ������Ƽ�� ��� �����ͼ� ����ϴ� ���α׷�
//�ý��� ������Ƽ�� �ڹ� ���α׷��� ���� ȯ�濡 ���� ���� ���� ������ ��� ������ �ϴ�
//������ ������
//�ڹ� ���� ��谡 �ڹ� ���α׷��� ������ �� �ü���κ��� �о�ͼ� �ڵ����� �����մϴ�.
package ex16_1_System_in_out_error;
import java.util.*;
public class System5_getProperties {

	public static void main(String[] args) {
		//�ý��� ������Ƽ�� ��� �����ɴϴ�.
		Properties props = System.getProperties();
		
		//������ �ý��� ������Ƽ�� ����մϴ�.
		// props ��ü�� �ִ� ��� ������Ƽ���� System.out���� ����մϴ�.
		props.list(System.out);
	}

}
