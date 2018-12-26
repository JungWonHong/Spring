package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import model.Member;

public class AddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Member mem = new Member();
		mem.setId(id);
		mem.setPassword(password);
		
		MemberDao md = new MemberDao();
		int result = md.chk(mem);
		
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result == 1){
			session.setAttribute("id", mem.getId());
			out.println("<script>");
			out.println("alert('환영합니다~." + id +"님~');");
			out.println("location.href='main.net'");
			out.println("</script>");
			out.close();
		} else if(result == -1){
			out.println("<script>");
			out.println("alert('비번이 다릅니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		} else if(result == 0){
			out.println("<script>");
			out.println("alert('그런 ID가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return null;
	}

}
