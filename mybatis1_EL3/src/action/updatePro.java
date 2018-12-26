package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.Member;

public class updatePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem = new Member();
		MemberDao md = new MemberDao();
		
		mem.setId(request.getParameter("id"));
		mem.setPassword(request.getParameter("password"));
		int result = md.update(mem);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result == 1) {
			out.println("<script>");
			out.println("alert('수정 성공입니다.');");
			out.println("location.href='list.net'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('수정 실패입니다.');");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
		}
		return null;
	}

}
