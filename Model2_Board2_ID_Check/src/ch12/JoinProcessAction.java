package ch12;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch12.db.*;

public class JoinProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		Member m = new Member();
		m.setAge(age);
		m.setEmail(email);
		m.setGender(gender);
		m.setId(id);
		m.setName(name);
		m.setPassword(pass);
		
		MemberDAO mdao = new MemberDAO();
		int result = mdao.insert(m);
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		//삽입이 된 경우
		if(result == 1) {
/*			forward.setPath("./ch12_db/_8.member/ex3_servlet/loginForm.jsp");
			forward.setRedirect(false);*/
			out.println("alert('회원 가입을 축하합니다.');");
			out.println("location.href='./login.net';");
/*			forward.setPath("login.net");
			forward.setRedirect(true);*/
		} 
		out.println("</script>");
		out.close();
		return null;
		
		//return forward;
	}
	
}
