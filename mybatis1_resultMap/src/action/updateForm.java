package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.Member;

public class updateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String id = request.getParameter("id");
		MemberDao md = new MemberDao();
		Member mem = md.select(id);
		
		request.setAttribute("mem", mem);
		forward.setRedirect(false);
		forward.setPath("./jsp/updateForm.jsp");
		return forward;
	}

}
