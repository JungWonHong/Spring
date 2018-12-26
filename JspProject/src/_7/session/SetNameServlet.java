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
		//request.getSession() : 세션 객체 생성하는 메서드입니다.
		HttpSession session = request.getSession();
		//세션의 생명주기는 : 브라우저가 켜져서 꺼질때까지.
		//세션 영역에 name이라는 이름으로 "홍길동"의 값을 저장합니다.
		session.setAttribute("name", "홍길동");
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<h1>이름저장</h1>");
	}
}
