package semi.action.recruit;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.*;
import semi.db.bean.RecruitBoardBean;

public class RecruitListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		BoardDAO boarddao = new BoardDAO();
		List<RecruitBoardBean> recruitlist = new ArrayList<RecruitBoardBean>();
		
		recruitlist = boarddao.getBoardList();
		
		request.setAttribute("recruitlist", recruitlist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./semi/recruitboard/recruit_board_list.jsp");
		return forward;
	}

}
