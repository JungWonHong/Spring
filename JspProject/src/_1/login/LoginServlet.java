package _1.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * jsp 2.2�� ���� ������ web.xml���ٴ� Annotation(�ּ�-Ư���� �ǹ� �ο�)
      ������� �����մϴ�.
 * @WebServlet �ֳ����̼��� urlPattern �Ӽ��� ������ ���µ� �� �Ӽ���
      �ش� ������ ���ε� URL ������ ������ �� ���˴ϴ�.
      �Ʒ��� ��� '/ch3/_1.login/login'�� ������ URL��
   LoginServlet�� ó���ϵ��� �����ϰ� �ֽ��ϴ�.
   web.xml ���Ͽ� ������ ������ ���� �ʴ��� LoginServlet�� ������ �� �ְ� �˴ϴ�.
 */
@WebServlet(urlPatterns = "/ch3/_1.login/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//�����ϴ� ������ Ÿ���� htmlŸ���̰� charset=euc-kr�� �����ϸ鼭 
		//����Ǵ� �����͵��� �ѱ� ó���� �� �κ��Դϴ�. 
		response.setContentType("text/html;charset=euc-kr");
		
		//getContextPath() : �� ���ø����̼� ��� ������ ��ȯ�մϴ�.
		//URL���� ��Ʈ��ȣ�� ������ ���� �� ���ø����̼� �̸��� �����մϴ�.
		//�� ���� �����ϴ� �޼ҵ� �Դϴ�.
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//getParameter() �޼��� : name���� ���۵Ǿ� �� �Ķ���� ���� ��ȯ�� �ִ� �޼���
		//Ŭ���̾�Ʈ���� ���۵Ǿ� ���� id��� �̸��� �Ķ���� ����
		//passwd��� �̸��� �Ķ���� ���� �޴� �κ��Դϴ�.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//���ڿ� ������ response��ü�� ������ ����� �� �ִ� ��� ��Ʈ���� ������ �κ��Դϴ�.
		PrintWriter out = response.getWriter();
		
		//���信 id���� ���� passwd���� ���� ����ϴ� �κ��Դϴ�.
		out.println("<br>" + "���̵�=" + id + "<br>");
		out.println("��й�ȣ=" + passwd + "<br>");
		out.close();
	}
}
