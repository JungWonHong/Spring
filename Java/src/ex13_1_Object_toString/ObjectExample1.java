package ex13_1_Object_toString;

import java.io.File;

public class ObjectExample1 {

	public static void main(String[] args) {
		//java.lang.Object
		//		java.io.File
		
		File file = new File("C:\\���ٱ�");
		String str = file.toString();   //String java.io.File.toString() //Object.toString() �������̵�
		System.out.println(str);
	}

}
