package semi.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.*;
import semi.db.bean.*;
import semi.db.*;

public class PModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		MemberDAO mdao = new MemberDAO();
		PMemberBean pmember = new PMemberBean();
		int result;

		pmember.setP_id(request.getParameter("p_id"));
		pmember.setP_pw(request.getParameter("p_pw"));
		pmember.setP_hp(request.getParameter("p_hp"));
		pmember.setP_email(request.getParameter("p_email"));

		result = mdao.PModify(pmember);

		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if (result == 1) {
			if (id.equals("admin")) {
				out.println("alert('ȸ������ ������ �����Ͽ����ϴ�.');");
				out.println("location.href='./adminPinfo.com?id=" + request.getParameter("p_id") + "';");
			} else {
				out.println("alert('ȸ������ ������ �����Ͽ����ϴ�.');");
				out.println("location.href='./PMyPage.com';");
			}
		} else if (result == -1) {
			out.println("alert('ȸ������ ������ �����Ͽ����ϴ�.');");
			out.println("history.back()");// ��й�ȣ�� ������ �ٸ� �����ʹ� ����
		}
		out.println("</script>");
		out.close();
		return null;
	}

}
