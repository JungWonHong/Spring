package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logout implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		session.invalidate();
		
		out.println("<script>");
		out.println("alert('로그아웃 성공입니다.');");
		out.println("location.href='loginForm.net'");
		out.println("</script>");
		out.close();
		
		return null;
	}

}
