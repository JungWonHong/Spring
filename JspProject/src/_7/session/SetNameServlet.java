package _7.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/setName")
public class SetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getSession() : ���� ��ü �����ϴ� �޼����Դϴ�.
		HttpSession session = request.getSession();
		//������ �����ֱ�� : �������� ������ ����������.
		//���� ������ name�̶�� �̸����� "ȫ�浿"�� ���� �����մϴ�.
		session.setAttribute("name", "ȫ�浿");
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<h1>�̸�����</h1>");
	}
}
