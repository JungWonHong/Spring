package ch12;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch12.db.MemberDAO;

public class Member_deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		MemberDAO mdao = new MemberDAO();
		if (id.equals("admin")) {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자는 삭제 하지 않습니다.');");
			//out.println("location.href='./member_list.net';");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		} else {
			mdao.member_delete(id);
			forward.setPath("./member_list.net");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
