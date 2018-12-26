package net.board.action;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDownload implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("����� �ٿ�ε�");
		request.setCharacterEncoding("utf-8");
		String fileName = request.getParameter("file_name");
		String savePath = "upload";
		
		ServletContext context = request.getServletContext();
		String sDownloadPath = context.getRealPath(savePath);
		
		String sFilePath = sDownloadPath + "\\" + fileName;
		System.out.println(sFilePath);
		
		byte b[] = new byte[4096];
		
		FileInputStream in = new FileInputStream(sFilePath);
		
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		System.out.println("sMimeType>>>" + sMimeType);
		
		// octet=stream�� 8��Ʈ�� �� �Ϸ��� �����͸� ���մϴ�.
		//�������� ���� ���� ������ �ǹ��մϴ�.
		if(sMimeType == null)
			sMimeType = "application/octet-stream";
		
		response.setContentType(sMimeType);
		
		//������ ���� ã��
		String header = request.getHeader("User-Agent");
		String browser = "";
		System.out.println("header= " + header);
		if (header.indexOf("Trident") > -1) {
			browser = "MSIE";
		} else if (header.lastIndexOf("OPR") > -1) {
			browser = "Opera";
		} else if (header.indexOf("Chrome") > -1) {
			browser = "Chrome";
		} else if (header.indexOf("Firefox") > -1) {
			browser = "Firefox";
		} else if (header.indexOf("Safari") > -1) {
			browser = "Safari";
		}
		System.out.println("browser = " + browser);
		
		//�ѱ��̸��� ���� �ٿ�ε�(�� �κ��� �ѱ� ���ϸ��� ������ ���� ������ �ݴϴ�.)
		//IE�� �ٸ� ������ ó��
		String sEncoding = "";
		if(browser.equals("MSIE")){
			System.out.println("MSIE");
			sEncoding = java.net.URLEncoder.encode(fileName, "UTF-8");
			//���ϸ� ������ �ִ� ��� "+"�� ����� ���� �������� ó���մϴ�.
			sEncoding = sEncoding.replaceAll("\\+", "%20");
			
			//Firefox�� ��� ���ϸ� ������ �ִ� ��� ������ �������� ���� ���ڸ� ���ϸ�����
			//�ν��ؼ� ���ϸ� �յڿ� ("")�� �ٿ��� �ذ��߽��ϴ�.
		} else if(browser.equals("Firefox")){
			sEncoding = "\"" + new String(fileName.getBytes("utf-8"), "8859_1") + "\"";
		} else {
			sEncoding = new String(fileName.getBytes("utf-8"), "8859_1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
		
		ServletOutputStream out = response.getOutputStream();
		int numRead;
		
		while((numRead = in.read(b, 0, b.length)) != -1) {
			out.write(b, 0, numRead);
		}
		
		out.flush();
		out.close();
		in.close();
		return null;
	}

}
