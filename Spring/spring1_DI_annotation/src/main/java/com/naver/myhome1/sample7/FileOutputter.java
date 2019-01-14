package com.naver.myhome1.sample7;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

//@Component
@Component("outputter")
public class FileOutputter implements Outputter {
	
	private String filePath; //������� ��ο� �����̸��� ������ ����

	public FileOutputter() {
		System.out.println("1. ����� FileOutputter �������Դϴ�.");
	}
	
	@Override
	public void output(String message) throws IOException {
		System.out.println("7. ����� FileOutputter.java�� output() �Դϴ�.");
		FileWriter out = new FileWriter(filePath);
		out.write(message);//�޽����� �����
		out.close();
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath; //out.txt ���ԵǾ����ϴ�.
		System.out.println("5. ����� FileOutputter.java�� setFilePath() �Դϴ�.");
	} //����������  setter�޼��带 Ȱ���� setter DI����
}
