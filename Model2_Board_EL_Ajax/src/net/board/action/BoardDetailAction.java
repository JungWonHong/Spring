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
		String page = request.getParameter("page");
		System.out.println(num + ", " + page);
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
		request.setAttribute("page", page);
		
		if(boarddata.getBOARD_FILE()!=null){
			//IE���� �ν��ϱ� ���� ����մϴ�.
			String filename = java.net.URLEncoder.encode(boarddata.getBOARD_FILE(), "utf-8");
			System.out.println(filename);
			//String filename = boarddata.getBOARD_FILE();
			request.setAttribute("filename", filename);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/qna_board_view.jsp");
		
		return forward;
	}

}
