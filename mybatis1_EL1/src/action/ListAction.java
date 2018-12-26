package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.Member;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		MemberDao md = new MemberDao();
		List<Member> list = md.list();
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setPath("./jsp/list.jsp");
		return forward;
	}

}
