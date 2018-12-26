package semi.action.comments;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.CommentsDAO;
import semi.db.bean.CommentsBean;

public class CommentsModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");

		int com_no = Integer.parseInt(request.getParameter("com_no"));
		boolean result = false;

		CommentsDAO cmtdao = new CommentsDAO();
		CommentsBean cmtdata = new CommentsBean();

		cmtdata.setCom_no(com_no);
		cmtdata.setCom_content(request.getParameter("cmtcontent"));

		// DAO에서 수정메서드 호출하여 수정
		result = cmtdao.CommentsModify(cmtdata);

		// 수정실패
		if (result == false) {
			System.out.println("댓글 수정 실패");
			return null;
		}
		// 수정성공
		System.out.println("댓글 수정 완료");

		PrintWriter out = response.getWriter();

		out.println("<script>");
		out.println("alert('수정완료');");
		out.println("self.close();");
		out.println("opener.location.reload();");
		out.println("</script>");

		return null;
	}

}
