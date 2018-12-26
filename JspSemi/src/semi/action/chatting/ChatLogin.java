package semi.action.chatting;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/chatting/ChatLogin")
public class ChatLogin extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id"); //������ ����� ID�� �޾ƿɴϴ�.

		out.println("<html>");
		out.println("<frameset rows='85%, 15%'>");      //ä�ó��� ������ �� - Get������� id ����
		out.println("<frame src='/JspSemi/semi/chatting/ChatServlet?id=" + id + "' name='main' scrolling='auto'>");
		out.println("<frame src='/JspSemi/semi/chatting/ChatInput?id=" + id + "'>");
		out.println("</frameset>");						//ä���Է��� �� - Get������� id ����
		out.println("</html>");
	}
}
