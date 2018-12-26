package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		BoardDAO boarddao = new BoardDAO();
		BoardBean boarddata = new BoardBean();
		
		//�۹�ȣ �Ķ���� ���� num������ �����մϴ�.
		int num = Integer.parseInt(request.getParameter("num"));
		
		//������ Ȯ���� ���� ��ȸ���� ������ŵ�ϴ�.
		boarddao.setReadCountUpdate(num);
		
		//���� ������ DAO���� ���� �� ���� ����� boarddata ��ü�� �����մϴ�.
		boarddata = boarddao.getDetail(num);
		
		//DAO���� ���� ������ ���� ������ ��� null�� ��ȯ�մϴ�.
		if(boarddata == null){
			System.out.println("�󼼺��� ����");
			return null;
		}
		
		System.out.println("�󼼺��� ����");
		
		//boarddata ��ü�� Request��ü�� �����մϴ�.
		request.setAttribute("boarddata", boarddata);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		//�� ���� ���� �������� �̵��ϱ� ���� ��θ� �����մϴ�.
		forward.setPath("./ch14/_1.Model2/board/qna_board_view.jsp");
		
		return forward;
	}

}
