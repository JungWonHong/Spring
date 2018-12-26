package semi.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.*;
import semi.db.bean.*;
import semi.db.*;

public class EModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		request.setCharacterEncoding("euc-kr");
		MemberDAO mdao = new MemberDAO();
		EMemberBean emember = new EMemberBean();
		int result;

		emember.setE_id(request.getParameter("e_id"));
		emember.setE_pw(request.getParameter("e_pw"));
		emember.setE_phone(request.getParameter("e_hp"));
		emember.setE_email(request.getParameter("e_email"));
		emember.setE_company(request.getParameter("e_company"));

		result = mdao.EModify(emember);

		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if (result == 1) {
			if (id.equals("admin")) {
				out.println("alert('회원정보 수정에 성공하였습니다.');");
				out.println("location.href='./adminEinfo.com?id=" + request.getParameter("e_id") + "';");
			} else {
				out.println("alert('회원정보 수정에 성공하였습니다.');");
				out.println("location.href='./EMyPage.com';");
			}
		} else if (result == -1) {
			out.println("alert('회원정보 수정에 실패하였습니다.');");
			out.println("history.back()");// 비밀번호를 제외한 다른 데이터는 유지
		}
		out.println("</script>");
		out.close();
		return null;
	}

}
