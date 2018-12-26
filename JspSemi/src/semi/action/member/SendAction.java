package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.*;
import semi.db.bean.*;
import semi.db.*;

public class SendAction implements Action{
	public ActionForward execute(HttpServletRequest request,
	         HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("euc-kr");
		String id = (String)session.getAttribute("id");
		String memkind=(String)session.getAttribute("memkind");
		MemberDAO mdao = new MemberDAO();
		
		if(memkind != null) {
			if(memkind.equals("1")){//개인
				PMemberBean pmember = mdao.pinfo(id);
				request.setAttribute("pmember", pmember);
			}else if(memkind.equals("2")){//기업
				EMemberBean emember = mdao.einfo(id);
				request.setAttribute("emember", emember);
			}
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./semi/email/mailform.jsp");
		return forward;
	}
}
