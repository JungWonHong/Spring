package semi.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.*;
import semi.db.MemberDAO;

public class PMemberDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("euc-kr");
		MemberDAO mdao = new MemberDAO();
		
		String P_pw=request.getParameter("p_pw");//입력받은 PASSWORD
		String P_id=request.getParameter("p_id");
		System.out.println(P_id);
		try {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			
			int check = 0;
			int checkadmin = 0;
			if(session.getAttribute("id").equals("admin")){
				checkadmin = mdao.isPId("admin", P_pw);
				if(checkadmin == 0){
					out.println("alert('비밀번호가 맞지 않습니다.');");
					out.println("history.go(-1);");
					out.println("</script>");
					out.close();
					return null;
				} else {
					check = mdao.PdeleteMember(P_id);
				}
			} else {
				check = mdao.PdeleteMember(P_pw, P_id);
			}
			
			if (check == 1) {
				out.println("alert('정상적으로 탈퇴처리 되었습니다.');");
				if(session.getAttribute("id").equals("admin")){
					out.println("location.href='./adminMemberList.com'");
				} else {
					out.println("location.href='./KHJobs.com';");
					session.invalidate();
				}
			} else {
				out.println("alert('비밀번호가 맞지 않습니다.');");
				out.println("history.go(-1);");
			}
			out.println("</script>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}