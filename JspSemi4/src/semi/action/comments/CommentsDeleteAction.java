//댓글 삭제
package semi.action.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.CommentsDAO;

public class CommentsDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		boolean result=false;
		int com_no =Integer.parseInt(request.getParameter("com_no"));
		
		
		CommentsDAO cmtdao = new CommentsDAO();
		System.out.println(com_no);
		result = cmtdao.CommentsDelete(com_no);
		
		//삭제실패시
		if(result==false){
			System.out.println("댓글삭제 실패");
			return null;
			
		}
		//삭제 성공시
		System.out.println("댓글삭제 성공");
		forward.setRedirect(true);
		forward.setPath("./sbBoardDetailAction.bo");
		return forward;
	}

}
