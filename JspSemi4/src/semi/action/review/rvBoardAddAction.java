package semi.action.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.BoardDAO;
import semi.db.bean.ReviewBoardBean;

public class rvBoardAddAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boarddao=new BoardDAO();
		ReviewBoardBean rv=new ReviewBoardBean();
		ActionForward forward=new ActionForward();
		boolean result=false;
		request.setCharacterEncoding("euc-kr");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("rv_score"));
		try{
			rv.setRv_id(request.getParameter("id"));
			rv.setRv_title(request.getParameter("rv_title"));
			rv.setRv_score(Integer.parseInt(request.getParameter("rv_score")));
			rv.setRv_content(request.getParameter("rv_content"));
			result=boarddao.rvboardInesrt(rv);
			
			if(result==false){
				System.out.println("게시판 등록 실패");
				return null;
			}
			System.out.println("게시판 등록 완료");
			
			forward.setRedirect(true);
			forward.setPath("./rvBoardList.bo");
			return forward;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
