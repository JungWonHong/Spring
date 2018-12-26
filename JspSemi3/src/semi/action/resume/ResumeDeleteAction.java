package semi.action.resume;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.ResumeDAO;

public class ResumeDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = new ActionForward();
		ResumeDAO rdao = new ResumeDAO();
		String id = request.getParameter("p_id");
		String company = request.getParameter("r_company");
		System.out.println(company);
		System.out.println(id);
		boolean result = rdao.deleteResume(id, company);
		
		if(!result){
			System.out.println("이력서 삭제 실패");
			return null;
		}
		
		forward.setRedirect(false);
		forward.setPath("./ResumeList.re?p_id=" + id);
		return forward;
	}

}
