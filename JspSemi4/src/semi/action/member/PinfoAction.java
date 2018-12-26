package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.*;
import semi.db.bean.*;
import semi.db.*;

public class PinfoAction implements Action{
	public ActionForward execute(HttpServletRequest request,
	         HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("euc-kr");
		String id = (String)session.getAttribute("id");
		MemberDAO mdao = new MemberDAO();
		PMemberBean pmember = mdao.pinfo(id);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		request.setAttribute("pmember", pmember);
		forward.setPath("./semi/member/pinfo.jsp");
		return forward;
	}
}
