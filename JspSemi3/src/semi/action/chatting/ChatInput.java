package semi.action.chatting;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/semi/chatting/ChatInput")
public class ChatInput extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	response.setContentType("text/html;charset=euc-kr");
	PrintWriter out = response.getWriter();
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");

	out.println("<html><head>");
	
	out.println("<script language='JavaScript'>");
	out.println("function send(form){");
	out.println("	form.msg.value = form.temp.value;");
	out.println("	form.temp.value = '';");
	out.println("	form.temp.focus();");
	out.println("	return true;");
	out.println("}");
	out.println("</script>");
	out.println("<title>채팅 로그인</title></head>");
	out.println("<body  bgcolor=#ccc>");
	out.println("<form method=post action=/JspSemi/semi/chatting/ChatServlet");
	out.println("onSubmit='return send(this)' target='main'>");
	out.println("메시지 : <input type=text size=50 name=temp  bgcolor=#353535>");
	out.println("<input type=hidden name=msg>");
	out.println("<input type=hidden name=id value="+id+"'>");
	out.println("</form>");
	out.println("</body></html>");
	}
}
