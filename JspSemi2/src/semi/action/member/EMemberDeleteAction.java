package semi.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.*;
import semi.db.MemberDAO;

public class EMemberDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("euc-kr");
		MemberDAO mdao = new MemberDAO();
		
		String E_pw=request.getParameter("e_pw");//�Է¹��� PASSWORD
		String E_id=request.getParameter("e_id");//DB�� ����Ǿ� �ִ� ID
		
		try {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			
			int check = 0;
			int checkadmin = 0;
			if(session.getAttribute("id").equals("admin")){
				checkadmin = mdao.isPId("admin", E_pw);
				if(checkadmin == 0){
					out.println("alert('��й�ȣ�� ���� �ʽ��ϴ�.');");
					out.println("history.go(-1);");
					out.println("</script>");
					out.close();
					return null;
				} else {
					check = mdao.EdeleteMember(E_id);
				}
			} else {
				check = mdao.EdeleteMember(E_pw, E_id);
			}
			
			if (check == 1) {
				out.println("alert('���������� Ż��ó�� �Ǿ����ϴ�.');");
				if(session.getAttribute("id").equals("admin")){
					out.println("location.href='./adminMemberList.com'");
				} else {
					out.println("location.href='./KHJobs.com';");
					session.invalidate();
				}
			} else {
				out.println("alert('��й�ȣ�� ���� �ʽ��ϴ�.');");
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