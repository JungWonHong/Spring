<%@ page language="java" contentType="text/html; charset=EUC-KR"
		pageEncoding="EUC-KR"%>
<%@ page import="java.awt.Graphics2D" %>
<%@ page import="java.awt.image.renderable.ParameterBlock" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.media.jai.JAI" %>
<%@ page import="javax.media.jai.RenderedOp" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%
	request.setCharacterEncoding("euc-kr");
	//실제로 업로드 될 폴더의 경로를 설정합니다.
	String imagePath = application.getRealPath("image");
	System.out.print(imagePath);
	
	//이미지 업로드 제한을 10MB로 설정합니다.
	int size = 10*1024*1024;
	String filename = "";
	
	try{
		//이미지를 업로드 합니다.
		MultipartRequest multi = new MultipartRequest(request,
													imagePath,
													size,
													"euc-kr",
													new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();
		String file = (String)files.nextElement();
		
		//업로드된 이미지 파일의 이름을 얻어옵니다.
		filename = multi.getFilesystemName(file);
	} catch(Exception e) { //이미지 제한 용량을 넘거나 기타 Exception이 발생할 경우 처리합니다.
		//e.printStackTrace();
		out.print("에러입니다.");
	}
	
	//ParameterBlock 클래스에 변환할 이미지를 담기 위해 객체 생성합니다.
	ParameterBlock pb = new ParameterBlock();
	
	//ParameterBlock에 변환할 이미지를 담습니다.
	pb.add(imagePath + "/" + filename);
	
	//fileload-파일을 불러옵니다.
	RenderedOp rOp = JAI.create("fileload", pb);
	
	//불러온 이미지를 bi로 생성한 BufferedImage에 담습니다.
	BufferedImage bi = rOp.getAsBufferedImage();
	
	//100 x 100 사이즈의 RGB 색상을 이용하는 BufferedImage 객체를 생성합니다.
	BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
	
	//그림을 그리기 위해 Graphics2D를 얻어옵니다.
	Graphics2D g = thumb.createGraphics();
	
	//원본(bi)을 100 x 100으로 맞추어 드로우합니다.
	g.drawImage(bi, 0, 0, 100, 100, null);
	
	//출력할 위치와 파일 이름을 설정하고 파일을 생성합니다.
	File file = new File(imagePath + "/sm_" + filename);
	
	//jpb타입으로 섬네일 이미지를 생성합니다. 즉, 버퍼의 내용을 파일에 씁니다.
	ImageIO.write(thumb, "jpg", file);
%>

<!DOCTYPE html>
<html>
	<head>
		<title>이미지 썸네일 예제</title>
	</head>
	<body>
		-원본 이미지-<br>
		<img src="/JspProject/image/<%=filename %>"><p>
		-썸네일 이미지-<br>
		<img src="/JspProject/image/sm_<%=filename %>">
	</body>
</html>