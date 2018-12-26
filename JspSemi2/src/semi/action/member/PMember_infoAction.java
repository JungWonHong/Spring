package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.*;
import semi.db.MemberDAO;
import semi.db.bean.*;


public class PMember_infoAction implements Action{
	public ActionForward execute(HttpServletRequest request,
	         HttpServletResponse response)throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("euc-kr");
		String id = (String)session.getAttribute("id");
		MemberDAO mdao = new MemberDAO();
		PMemberBean m = mdao.Pmember_info(id);
		
		forward.setRedirect(false);
		request.setAttribute("pmember", m);
		forward.setPath("./semi/pinfo.jsp");
		return forward;
	}
}
