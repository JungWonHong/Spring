package semi.action.chatting;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/semi/chatting/ChatServlet")
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
		request.setCharacterEncoding("euc-kr"); 
		String id = request.getParameter("id");  //채팅입력창으로부터 Post방식으로 받아온 ID
		String msg = request.getParameter("msg");//채팅입력창으로부터 Post방식으로 받아온 메세지
		if (msg != null && msg.trim().length() != 0) {
			synchronized (message) { //동기화 블럭을 통해 한개의 쓰레드만 실행
				message[index] = id + " : " + msg;
				index = (index + 1) % size;
			}
		}
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<meta http-equiv='pragma' content='no-cache'>");
		out.println("<meta http-equiv='cache-control' content='no-cache'>");
		out.println("<meta http-equiv='refresh'");
		out.println("content='2'; URL='/JspSemi/semi/chatting/ChatServlet'>");  //URL을 2초 간격으로 새로고침해줍니다
		out.println("<title>채팅</title></head>");
		out.println("<body  bgcolor=#ccc><center><h2>실시간 채팅</h2></center><hr>");
		int i = index; 
		while (true) {
			out.print(message[i]);  // 앞서 진행된 채팅내용을 보여줍니다.
			out.println("<br>");
			i = ++i % size;
			if (i == index - 1) 	// 가장 최근에 올라온 채팅내용일 경우
				break;
			if (index == 0 && i == size - 1) // 첫번째 채팅내용일 경우 
				break;
		}
		out.print(message[i]);  //입력한 메세지를 보여줍니다. 
		out.println("<br>");
		out.println("</body></html>");
	}
}
