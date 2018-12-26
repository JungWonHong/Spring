package semi.action.resume;

import javax.servlet.http.*;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

public class ManageResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		PMemberBean pmember = new PMemberBean();
		MemberDAO mdao = new MemberDAO();
		
		pmember = mdao.Pmember_info(id);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		request.setAttribute("pmember", pmember);
		forward.setPath("./semi/resume/Resume_write.jsp");
		return forward;
	}

}
