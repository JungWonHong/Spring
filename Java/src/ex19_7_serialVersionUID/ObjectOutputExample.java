package ex19_7_serialVersionUID;

import java.io.*;

public class ObjectOutputExample {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output10.dat"));
			Rectangle obj = new Rectangle(100, 200);
			
			System.out.println("≥–¿Ã : " + obj.width);
			System.out.println("≥Ù¿Ã : " + obj.height);
			out.writeObject(obj);
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}

	}

}
