package _8.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch3/_8.session/login_ok")
public class LoginOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginOkServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������ ������ ���� : ĳ���� �� ����
		response.setContentType("text/html;charset=euc-kr");
		
		//post��� ��û �ѱ� ó��
		request.setCharacterEncoding("euc-kr");
		
		//��� ��Ʈ�� ����
		PrintWriter out = response.getWriter();
		
		//�Ķ���� id�� passwd�� �� ��������
		String id = request.getParameter("id");
		String pw = request.getParameter("passwd");
		
		//�Է� ���� ���� ��
		//�Է� ���� ���� ��ġ�� ���
		if (id.equals("java") && pw.equals("java")) {
			//���� ����
			HttpSession session = request.getSession();
			
			//���� ��ü�� id��� �Ӽ����� id���� ����
			session.setAttribute("id", id);
			
			response.sendRedirect("loginSuccess.jsp");
		} else if(id.equals("java")) { //�Է� ���� ���� ��ġ���� ���� ���
			out.println("<script>");
			out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');");
			out.println("history.back();"); //�ٷ� �� �������� �̵�
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('���̵� ��ġ���� �ʽ��ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
	}

}
