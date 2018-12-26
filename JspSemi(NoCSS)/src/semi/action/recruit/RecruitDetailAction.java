package semi.action.recruit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.*;
import semi.db.bean.RecruitBoardBean;

public class RecruitDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		BoardDAO boarddao = new BoardDAO();
		RecruitBoardBean boarddata = new RecruitBoardBean();
		HttpSession session = request.getSession();
		int no;
		if(request.getParameter("no") == null){
			no = (int) session.getAttribute("no"); 
		} else {
			no = Integer.parseInt(request.getParameter("no"));
			session.setAttribute("no", no);
		}
		
		boarddata = boarddao.getDetail(no);
		
		if(boarddata == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		
		System.out.println("상세보기 성공");
		
		request.setAttribute("boarddata", boarddata);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./semi/recruitboard/recruit_board_view.jsp");
		
		return forward;
	}

}
