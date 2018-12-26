package semi.action.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.CommentsDAO;
import semi.db.bean.CommentsBean;

public class CommentsAddAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommentsDAO cmtdao = new CommentsDAO();
		CommentsBean cmtdata = new CommentsBean();
		ActionForward forward = new ActionForward();

		request.setCharacterEncoding("euc-kr");

		boolean result = false;
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("id"));
		cmtdata.setCom_id((String)session.getAttribute("id")); // 작성자
		cmtdata.setCom_content(request.getParameter("cmtcontent")); // 댓글 내용
		cmtdata.setCom_re_ref((int) session.getAttribute("num"));

		result = cmtdao.CommentsInsert(cmtdata);

		// 글 등록에 실패할 경우 null을 반환합니다.
		if (!result) {
			System.out.println("댓글 등록 실패");
			return null;
		} else
			System.out.println("댓글 등록 완료");

		// 글 등록이 완료되면 글 목록을 단순히 보여주기만 할 것이므로
		// Redirect여부를 true로 설정합니다.
		forward.setRedirect(true);
		// 이동할 경로를 지정합니다.
		forward.setPath("./sbBoardDetailAction.bo");
		return forward;
	}
}
