package _5.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch3/_5.dispatcher/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	// Dispatcher ��� - �� ������� �̵��ϸ� �ּ� ǥ������ �ּҰ� ������� �ʽ��ϴ�.
	// ��, �ϳ��� ��û�̶�� �ǹ��̸� ���� request ������ �����ϰ� �˴ϴ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher.jsp");

		// request ��ü�� "food" �Ӽ��� "����" ���� �����մϴ�.
		request.setAttribute("food", "����"); //request�� ������ �������.
		dispatcher.forward(request, response); // dispatcher.jsp�� �̵��ϸ鼭 request�� �Բ� ������.
		//������������ �ѱ涧 ���������� ������ �ʿ��Ҷ��� dispatcher.forward() ���

	}

}
