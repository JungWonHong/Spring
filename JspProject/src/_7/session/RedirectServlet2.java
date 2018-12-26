package _7.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch3/_7.session/SessionServlet")
public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirectServlet2() {
        super();
    }

    //Redirect ��� : �������� �� �������� �ּ� ǥ������ URL�� ����ǹǷ�
    //��û�� �ٲ�� �˴ϴ�.
    //�������� jsp������������ �������� request ������ ������ �Ӽ� ����
    //������ �� �����ϴ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("food", "���ڷ�");
		session.setAttribute("food", "���ڷ�");
		response.sendRedirect("redirect.jsp"); //redirect.jsp �� �̵�����!(���ο� ��û)
		//������������ �̵��� ������������ ������ �ʿ������ sendRedirect()
	}

}
