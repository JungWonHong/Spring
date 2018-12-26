package semi.action.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.CommentsDAO;
import semi.db.bean.CommentsBean;

public class CommentsModifyView implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		
		CommentsDAO cmtdao = new CommentsDAO();
		CommentsBean cmtdata = new CommentsBean();
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		cmtdata=cmtdao.getDetail(com_no);
		
		//글 내용 불러오기 실패한 경우
	 	if(cmtdata==null){
	   		System.out.println("(수정)상세보기 실패");
	   		return null;
	   	}
	   	System.out.println("(수정)상세보기 성공");
	   	request.setAttribute("cmtdata", cmtdata);
	   	forward.setRedirect(false);
	   	
   		forward.setPath("./semi/comments/Comments_Modify.jsp");
   		return forward;
	}
}
