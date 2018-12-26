package semi.action.pool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.MemberDAO;
import semi.db.bean.PMemberBean;

public class PoolViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PMemberBean pmem = new PMemberBean();
		MemberDAO mdao = new MemberDAO();
		String p_id = request.getParameter("p_id");
		
		pmem = mdao.Pmember_info(p_id);
		request.setAttribute("pmember", pmem);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./semi/pool/pool_view.jsp");
		
		return forward;
	}

}
