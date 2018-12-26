package semi.action.resume;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

public class ResumeDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = new ActionForward();
		ResumeDAO rdao = new ResumeDAO();
		MemberDAO mdao = new MemberDAO();
		ResumeBean resume = new ResumeBean();
		PMemberBean pmember = new PMemberBean();
		String id = request.getParameter("r_id");
		String company = request.getParameter("r_company");
		
		resume = rdao.getResumeDetail(id, company);
		pmember = mdao.Pmember_info(id);
		
		request.setAttribute("resume", resume);
		request.setAttribute("pmember", pmember);
		forward.setPath("./semi/resume/Resume_view.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
