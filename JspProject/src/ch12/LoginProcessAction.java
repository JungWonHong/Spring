package ch12;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch12.db.*;

public class LoginProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDAO mdao = new MemberDAO();
		
		int result = mdao.isId(id, pass);
		System.out.println("����� " + result);
		
		if (result == 1) {
			HttpSession session = request.getSession();
			//�α��� ����
			session.setAttribute("id", id);
			forward.setRedirect(false);
			forward.setPath("./ch12_db/_8.member/ex3_servlet/main.jsp");
			return forward;
		} else {
			String message = "";
			if(result == -1)
				message = "���̵� �������� �ʽ��ϴ�.";
			else
				message = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
			
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + message + "');");
			out.println("location.href='./login.net';"); //���ΰ�ħ�Ǿ �̵�
			//out.println("history.back()"); //��й�ȣ�� ������ �ٸ� �����ʹ� ����
			out.println("</script>");
			out.close();
			return null;
		}
	}
	
}
