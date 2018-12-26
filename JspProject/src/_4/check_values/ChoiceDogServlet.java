package _4.check_values;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//"http://localhost:8088/JspProject/JspProject/ch3/_4.check_values/choiceDog
@WebServlet(urlPatterns = "/ch3/_4.check_values/choiceDog")
public class ChoiceDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChoiceDogServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();

		// request.getParameterValues("dog")
		// �ϳ��� �Ķ���� �̸�(dog)���� ���� ���� �� ���۵Ǿ� �� ��쿡 ���
		// ���� �̸����� ���� ���� �Ķ���� ���� �����ϱ� ���ؼ� ����ϰ� �ִ� üũ �ڽ��� �̸���
		// ���������� dog�� �����Ǿ� �����Ƿ�
		// �� üũ �ڽ��� ������ ������ �̹��� ���ϸ��� �����Ͽ� �Ķ���� ������
		// ������ �̹��� �̸��� ���۵ǵ��� �ϰ� �ֽ��ϴ�.
		String[] dog = request.getParameterValues("dog");

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body bgcolor='black'>");
		out.println("<table align='center' bgcolor='yellow'>");
		out.println("<tr align='center'>");
		for (int i = 0; i < dog.length; i++) {
			out.println("<td style='color: red'>" + dog[i] + "</td>");
		}
		out.println("</tr>");

		out.println("<tr>");
		for (int i = 0; i < dog.length; i++) {
			out.println("<td><img src = '../../image/" + dog[i] + "'></td>");
		}
		out.println("</tr>");
		out.println("</table>");
		
		//����
/*		out.write("<style> body{background: black; margin: 0 auto; text-align:center; color: white;} "
				+ "table {text-align:center; margin: 0 auto; padding:5em; background: pink; border: thick dotted white;} "
				+ "thead{background : black} </style>");

		out.write("<table><thead>");
		for (int i = 0; i < dog.length; i++)
			out.write("<td>" + dog[i] + "</td>");
		out.write("</thead><tr>");
		for (int j = 0; j < dog.length; j++) {
			out.write("<td><img src = " + dog[j] + "></td>");
		}
		out.write("</tr></table>");*/
		
		out.close();
	}
}
