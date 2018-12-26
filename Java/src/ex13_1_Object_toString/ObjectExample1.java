package ex13_1_Object_toString;

import java.io.File;

public class ObjectExample1 {

	public static void main(String[] args) {
		//java.lang.Object
		//		java.io.File
		
		File file = new File("C:\\뻐꾸기");
		String str = file.toString();   //String java.io.File.toString() //Object.toString() 오버라이딩
		System.out.println(str);
	}

}
