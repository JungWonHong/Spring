package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.bean.*;
import semi.db.*;

public class PModifyView implements Action{
	public ActionForward execute(HttpServletRequest request,
	         HttpServletResponse response)throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("p_id");
		MemberDAO mdao = new MemberDAO();
		PMemberBean pmember = mdao.pview(id);
		
		
		forward.setRedirect(false);
		request.setAttribute("pmember", pmember);
		forward.setPath("./semi/member/PModify.jsp");
		return forward;
	}
}
