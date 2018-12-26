package semi.action.recruit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

public class RecruitWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		List<EListBean> elist = new ArrayList<EListBean>();
		BoardDAO bdao = new BoardDAO();
		
		elist = bdao.getEList();
		
		request.setAttribute("elist", elist);
		
		forward.setRedirect(false);
		forward.setPath("./semi/recruitboard/recruit_board_write.jsp");
		
		return forward;
	}

}
