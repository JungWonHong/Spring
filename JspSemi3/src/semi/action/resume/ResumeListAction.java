package semi.action.resume;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

import java.util.*;

public class ResumeListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = new ActionForward();
		ResumeDAO rdao = new ResumeDAO();
		List<ResumeBean> resumelist = new ArrayList<ResumeBean>();
		String id = request.getParameter("p_id");
		
		resumelist = rdao.getResumeList(id);
		
		request.setAttribute("resumelist", resumelist);
		
		forward.setPath("./semi/resume/Resume_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
