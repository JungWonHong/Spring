package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.bean.*;
import semi.db.*;

public class EModifyView implements Action{
	public ActionForward execute(HttpServletRequest request,
	         HttpServletResponse response)throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("e_id");
		MemberDAO mdao = new MemberDAO();
		EMemberBean emember = mdao.eview(id);
		forward.setRedirect(false);
		request.setAttribute("emember", emember);
		forward.setPath("./semi/member/EModify.jsp");
		return forward;
	}
}
