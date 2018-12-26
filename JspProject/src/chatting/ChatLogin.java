package chatting;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/chatting/ChatLogin")
public class ChatLogin extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("KSC5601");
		response.setContentType("text/html;charset=KSC5601");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		if (id == null || id.trim().length() == 0) {
			response.sendRedirect("/chat.html");
			return;
		}
		out.println("<html>");
		out.println("<frameset rows='85%, 15%'>");
		out.println("<frame src='/JspProject/chatting/ChatServlet?id=" + id + "&first=true' name='main'>");
		out.println("<frame src='/JspProject/chatting/ChatInput?id=" + id + "'>");
		out.println("</frameset>");
		out.println("</html>");
	}
}
