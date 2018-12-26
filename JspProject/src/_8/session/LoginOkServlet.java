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
		//응답의 컨텐츠 형식 : 캐릭터 셋 설정
		response.setContentType("text/html;charset=euc-kr");
		
		//post방식 요청 한글 처리
		request.setCharacterEncoding("euc-kr");
		
		//출력 스트림 생성
		PrintWriter out = response.getWriter();
		
		//파라미터 id와 passwd의 값 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("passwd");
		
		//입력 받은 값과 비교
		//입력 받은 값과 일치한 경우
		if (id.equals("java") && pw.equals("java")) {
			//세셩 생성
			HttpSession session = request.getSession();
			
			//세션 객체에 id라는 속성으로 id값을 저장
			session.setAttribute("id", id);
			
			response.sendRedirect("loginSuccess.jsp");
		} else if(id.equals("java")) { //입력 받은 값과 일치하지 않은 경우
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.back();"); //바로 전 페이지로 이동
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('아이디가 일치하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
	}

}
