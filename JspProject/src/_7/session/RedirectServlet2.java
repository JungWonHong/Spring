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

    //Redirect 방식 : 포워딩될 때 브라우저의 주소 표시줄의 URL이 변경되므로
    //요청이 바뀌게 됩니다.
    //포워딩된 jsp페이지에서는 서블릿에서 request 영역의 공유한 속성 값에
    //접근할 수 없습니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("food", "초코렛");
		session.setAttribute("food", "초코렛");
		response.sendRedirect("redirect.jsp"); //redirect.jsp 로 이동해줘!(새로운 요청)
		//다음페이지로 이동시 이전페이지의 정보가 필요없으면 sendRedirect()
	}

}
