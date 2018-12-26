package _6.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch3/_6.redirect/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirectServlet() {
        super();
    }

    //Redirect ��� : �������� �� �������� �ּ� ǥ������ URL�� ����ǹǷ�
    //��û�� �ٲ�� �˴ϴ�.
    //�������� jsp������������ �������� request ������ ������ �Ӽ� ����
    //������ �� �����ϴ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("food", "���ڷ�");
		response.sendRedirect("redirect.jsp"); //redirect.jsp �� �̵�����!(���ο� ��û)
		//������������ �̵��� ������������ ������ �ʿ������ sendRedirect()
	}

}
