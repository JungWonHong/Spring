package com.naver.myhome2.sample6;

import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class FileOutputter implements Outputter {
	
	private String filePath;

	public FileOutputter() {
		System.out.println("2. ����� FileOutputter �������Դϴ�.");
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
		System.out.println("3. ����� FileOutputter.java�� setFilePath() �Դϴ�.");
	} //����������  setter�޼��带 Ȱ���� setter DI����
	
	@PreDestroy //destroy-method="destroyMethod"�� �ش��ϴ� annotation
	public void destroyMethod() {
		System.out.println("FileOutputter�� destroyMethod()�Դϴ�.");
	}
}
