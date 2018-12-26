package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.*;
import semi.db.bean.*;
import semi.db.*;

public class EinfoAction implements Action{
	public ActionForward execute(HttpServletRequest request,
	         HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		String id = (String)session.getAttribute("id");
		MemberDAO mdao = new MemberDAO();
		EMemberBean emember = mdao.einfo(id);
		
		
		forward.setRedirect(false);
		request.setAttribute("emember", emember);
		forward.setPath("./semi/member/einfo.jsp");
		return forward;
	}
}
