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
		cmtdata.setCom_id((String)session.getAttribute("id")); // �ۼ���
		cmtdata.setCom_content(request.getParameter("cmtcontent")); // ��� ����
		cmtdata.setCom_re_ref((int) session.getAttribute("num"));

		result = cmtdao.CommentsInsert(cmtdata);

		// �� ��Ͽ� ������ ��� null�� ��ȯ�մϴ�.
		if (!result) {
			System.out.println("��� ��� ����");
			return null;
		} else
			System.out.println("��� ��� �Ϸ�");

		// �� ����� �Ϸ�Ǹ� �� ����� �ܼ��� �����ֱ⸸ �� ���̹Ƿ�
		// Redirect���θ� true�� �����մϴ�.
		forward.setRedirect(true);
		// �̵��� ��θ� �����մϴ�.
		forward.setPath("./sbBoardDetailAction.bo");
		return forward;
	}
}
