package ex6_3_method;

import java.util.Scanner;

public class Method_Test06 {

	static void change(int data[]) {

		int imsi = data[0];
		data[0] = data[1];
		data[1] = imsi;

	}

	public static void main(String[] args) {

		int data[] = new int[2];
		Scanner sc = new Scanner(System.in);

		System.out.println("정수 2개를 입력하세요?");
		for (int i = 0; i < data.length; i++)
			data[i] = sc.nextInt();

		System.out.println("before change \ndata[0]=" + data[0] + "\ndata[1]=" + data[1] + "\n");

		change(data);

		System.out.println(("after chage \ndata[0]=") + data[0] + "\ndata[1]=" + data[1]);

		sc.close();

	}

}
