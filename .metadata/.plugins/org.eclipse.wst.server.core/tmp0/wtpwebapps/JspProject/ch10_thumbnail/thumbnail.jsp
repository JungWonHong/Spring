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
	//������ ���ε� �� ������ ��θ� �����մϴ�.
	String imagePath = application.getRealPath("image");
	System.out.print(imagePath);
	
	//�̹��� ���ε� ������ 10MB�� �����մϴ�.
	int size = 10*1024*1024;
	String filename = "";
	
	try{
		//�̹����� ���ε� �մϴ�.
		MultipartRequest multi = new MultipartRequest(request,
													imagePath,
													size,
													"euc-kr",
													new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();
		String file = (String)files.nextElement();
		
		//���ε�� �̹��� ������ �̸��� ���ɴϴ�.
		filename = multi.getFilesystemName(file);
	} catch(Exception e) { //�̹��� ���� �뷮�� �Ѱų� ��Ÿ Exception�� �߻��� ��� ó���մϴ�.
		//e.printStackTrace();
		out.print("�����Դϴ�.");
	}
	
	//ParameterBlock Ŭ������ ��ȯ�� �̹����� ��� ���� ��ü �����մϴ�.
	ParameterBlock pb = new ParameterBlock();
	
	//ParameterBlock�� ��ȯ�� �̹����� ����ϴ�.
	pb.add(imagePath + "/" + filename);
	
	//fileload-������ �ҷ��ɴϴ�.
	RenderedOp rOp = JAI.create("fileload", pb);
	
	//�ҷ��� �̹����� bi�� ������ BufferedImage�� ����ϴ�.
	BufferedImage bi = rOp.getAsBufferedImage();
	
	//100 x 100 �������� RGB ������ �̿��ϴ� BufferedImage ��ü�� �����մϴ�.
	BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
	
	//�׸��� �׸��� ���� Graphics2D�� ���ɴϴ�.
	Graphics2D g = thumb.createGraphics();
	
	//����(bi)�� 100 x 100���� ���߾� ��ο��մϴ�.
	g.drawImage(bi, 0, 0, 100, 100, null);
	
	//����� ��ġ�� ���� �̸��� �����ϰ� ������ �����մϴ�.
	File file = new File(imagePath + "/sm_" + filename);
	
	//jpbŸ������ ������ �̹����� �����մϴ�. ��, ������ ������ ���Ͽ� ���ϴ�.
	ImageIO.write(thumb, "jpg", file);
%>

<!DOCTYPE html>
<html>
	<head>
		<title>�̹��� ����� ����</title>
	</head>
	<body>
		-���� �̹���-<br>
		<img src="/JspProject/image/<%=filename %>"><p>
		-����� �̹���-<br>
		<img src="/JspProject/image/sm_<%=filename %>">
	</body>
</html>