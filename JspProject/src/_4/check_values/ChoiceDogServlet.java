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
		// 하나의 파라미터 이름(dog)으로 값이 여러 개 전송되어 올 경우에 사용
		// 같은 이름으로 여러 개의 파라미터 값을 전송하기 위해서 사용하고 있는 체크 박스의 이름은
		// 공통적으로 dog로 지정되어 있으므로
		// 각 체크 박스의 값으로 강아지 이미지 파일명을 지정하여 파라미터 값으로
		// 강아지 이미지 이름이 전송되도록 하고 있습니다.
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
		
		//재인
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
