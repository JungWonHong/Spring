package _9.ServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context")
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		//���� �������� �Ҽӵ� �� ���ø����̼��� ServletContext��ü�� ���ؿɴϴ�.
		ServletContext sc = this.getServletContext();
		//ServletContext sc = request.getSession().getServletContext();
		
		//getMajorVersion() : ���� WAS���� �����ϰ� �ִ� ������ Major ���������� ��ȯ�մϴ�.
		//getMinorVersion() : ���� WAS���� �����ϰ� �ִ� ������ Minor ���������� ��ȯ�մϴ�.
		out.print("���� ���� : " + sc.getMajorVersion() + "." 
								+ sc.getMinorVersion() + "<br>");
		
		//���� ������� ���� �����̳��� �̸��� ���� ������ ��ȯ�մϴ�.
		out.print("���� ���� : " + sc.getServerInfo() + "<br>");
		
		//getContextPath() : �� ���ø����̼��� ã�ư��� ���� ����ϴ� ��θ� ��ȯ�մϴ�.
		out.print("�� ���ø����̼� ��� : " + sc.getContextPath() + "<br>");
		
		//getServletContextName() : web.xml�� <display-name> �±� ������
		//���� �����ϴ� �޼��� �Դϴ�.
		out.print("�� ���ø����̼� �̸� : " + sc.getServletContextName() + "<br>");
		
		//�ܼ� â�� ��Ÿ���ϴ�.
		sc.log("�α� ���");
		
		out.close();
	}
}
