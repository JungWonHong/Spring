package _9.ServletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//1. ũ�ҿ��� ����
//	 http://localhost://8088/JspProject/ch3/_9.context/context
//2. ũ���� ������ �ٸ� ���������� ����
//	 http://localhost://8088/JspProject/ch3/_9.context/scope.jsp
@WebServlet("/ch3/_9.context/context")
public class ContextServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		
		//���� �������� �Ҽӵ� �� ���ø����̼��� ServletContext��ü�� ���ؿɴϴ�.
		ServletContext sc = this.getServletContext();
		//ServletContext sc = request.getSession().getServletContext();
		
		HttpSession session = request.getSession();
		request.setAttribute("food", "����1"); 
		session.setAttribute("food", "����2");
		sc.setAttribute("food", "����3");
		response.sendRedirect("scope.jsp"); 
		//���ο� ��û�� ���� request�� ���ο� ��ü�� �Ǳ⶧���� null
		//request�� ���α׷��� ����Ǳ� ������ ����ִ� ����
		//session�� ������ ������ ���������� �����ϱ������� ����ִ� ����
		//ServletContext�� ������ �����ϱ��������� ����ִ� ����
	}
}
