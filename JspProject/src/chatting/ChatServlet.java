package chatting;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet(urlPatterns = "/chatting/ChatServlet")
public class ChatServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	String message[];
	int index = 0, size = 10;

	public void init() {
		message = new String[size];
		for (int i = 0; i < size; i++) {
			message[i] = "";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("KSC5601");
		String id = request.getParameter("id");
		String msg = request.getParameter("msg");
		if (msg != null && msg.trim().length() != 0) {
			synchronized (message) {
				message[index] = id + " : " + msg;
				index = (index + 1) % size;
			}
		}
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=KSC5601");
		String first = request.getParameter("first");
		if (first != null) {
			String id = request.getParameter("id");
			synchronized (message) {
				message[index] = "<p align=center>" + id + "님이 들어왔습니다. </p>";
				index = (index + 1) % size;
			}
		}
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<meta http-equiv='pragma' content='no-cache'>");
		out.println("<meta http-equiv='cache-control' content='no-cache'>");
		out.println("<meta http-equiv='refresh'");
		out.println("content='2'; URL='/JspProject/chatting/ChatServlet'>");
		out.println("<title>채팅</title></head>");
		out.println("<body><center><h2>채팅</h2></center><hr>");
		int i = index;
		while (true) {
			out.print(message[i]);
			out.println("<br>");
			i = ++i % size;
			if (i == index - 1)
				break;
			if (index == 0 && i == size - 1)
				break;
		}
		out.print(message[i]);
		out.println("<br>");
		out.println("</body></html>");
	}
}
