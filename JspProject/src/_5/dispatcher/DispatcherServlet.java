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

	// Dispatcher 방식 - 이 방식으로 이동하면 주소 표시줄의 주소가 변경되지 않습니다.
	// 즉, 하나의 요청이라는 의미이며 같은 request 영역을 공유하게 됩니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher.jsp");

		// request 객체에 "food" 속성에 "과자" 값을 저장합니다.
		request.setAttribute("food", "과자"); //request에 정보가 들어있음.
		dispatcher.forward(request, response); // dispatcher.jsp로 이동하면서 request도 함께 보내줌.
		//다음페이지로 넘길때 이전페이지 정보가 필요할때는 dispatcher.forward() 사용

	}

}
