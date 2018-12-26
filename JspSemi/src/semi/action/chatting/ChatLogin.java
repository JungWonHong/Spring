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
		String id = (String)session.getAttribute("id"); //접속한 사람의 ID를 받아옵니다.

		out.println("<html>");
		out.println("<frameset rows='85%, 15%'>");      //채팅내용 보여줄 곳 - Get방식으로 id 전송
		out.println("<frame src='/JspSemi/semi/chatting/ChatServlet?id=" + id + "' name='main' scrolling='auto'>");
		out.println("<frame src='/JspSemi/semi/chatting/ChatInput?id=" + id + "'>");
		out.println("</frameset>");						//채팅입력할 곳 - Get방식으로 id 전송
		out.println("</html>");
	}
}
