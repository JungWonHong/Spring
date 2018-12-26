package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO_max;

public class BoardReplyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardDAO_max boarddao = new BoardDAO_max();
		BoardBean boarddata = new BoardBean();

		// �Ķ���ͷ� ���޹��� �亯�� �� ��ȣ�� num������ �����մϴ�.
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		// �� ��ȣ num�� �ش��ϴ� ������ �����ͼ� boarddata ��ü�� �����մϴ�.
		boarddata = boarddao.getDetail(num);

		// �� ������ ���� ���
		if (boarddata == null) {
			System.out.println("���� ������ �̵� ����");
			return null;
		}

		System.out.println("���� ������ �̵� �Ϸ�");

		// �亯 �� �������� �̵��� �� ���� �� ������ �����ֱ� ���� boarddata��ü�� Request�� ����
		request.setAttribute("boarddata", boarddata);
		request.setAttribute("page", page);
		forward.setRedirect(false);

		// �� �亯 ������ ��� �����մϴ�.
		forward.setPath("./board/qna_board_reply.jsp");

		return forward;
	}

}
