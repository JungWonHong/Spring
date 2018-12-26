package semi.action.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.BoardDAO;

public class rvBoardDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("euc-kr");
		
		boolean result=false;
		//list 페이지에서 받아온 값
		int num=Integer.parseInt(request.getParameter("rv_no"));
		
		BoardDAO boarddao=new BoardDAO();
		
		result=boarddao.rvboardDelete(num);
		if(result==false){
			System.out.println("게시판 삭제 실패");
			return null;
		}
		//삭제 처리 성공- 글목록 보기 요청을 전송
		System.out.println("게시판 삭제 성공");
		forward.setRedirect(true);
		forward.setPath("./rvBoardList.bo");
		return forward;
	}

}
