//File  Ŭ������ ���丮 ����
//���� �� �� �� : ���� ���� ���丮 �̸�
//���� �� �� �� : �̹� �ִ� ���丮 �̸�
package ex18_10_File;
import java.io.*;
public class FileExample2_1 {

	public static void main(String[] args) {
		String dir = "E:\\newDirectory";
		//���丮 ����
		File f2 = new File(dir);
		if(!f2.exists()){
			System.out.println("���� ���� ���丮 �̸� : " + f2.getPath());
			f2.mkdir(); //���丮 ����
		}else{
			System.out.println("�̹� �ִ� ���丮 �̸� : " + f2.getPath());
		}

	}

}
