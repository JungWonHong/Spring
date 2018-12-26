package net.board.action;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDownload implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("여기는 다운로드");
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
		
		// octet=stream은 8비트로 된 일련의 데이터를 뜻합니다.
		//지정되지 않은 파일 형식을 의미합니다.
		if(sMimeType == null)
			sMimeType = "application/octet-stream";
		
		response.setContentType(sMimeType);
		
		//브라우저 종류 찾기
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
		
		//한글이름의 파일 다운로드(이 부분이 한글 파일명이 깨지는 것을 방지해 줍니다.)
		//IE와 다른 브라우저 처리
		String sEncoding = "";
		if(browser.equals("MSIE")){
			System.out.println("MSIE");
			sEncoding = java.net.URLEncoder.encode(fileName, "UTF-8");
			//파일명에 공백이 있는 경우 "+"가 생기는 것을 공백으로 처리합니다.
			sEncoding = sEncoding.replaceAll("\\+", "%20");
			
			//Firefox의 경우 파일명에 공백이 있는 경우 공백을 기준으로 앞의 글자만 파일명으로
			//인식해서 파일명 앞뒤에 ("")을 붙여서 해결했습니다.
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
