package _7.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//localhost:8088/JspProject/getName
@WebServlet("/getName")
public class GetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session������ �����ϴ� name �Ӽ� ���� ��ȯ�޽��ϴ�.
		//��ȯ���� Object���̱� ������ String���� ��ȯ�� �־�� �մϴ�.
		String name = (String)session.getAttribute("name");
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<h1>name=" + name + "</h1>");
	}
}
