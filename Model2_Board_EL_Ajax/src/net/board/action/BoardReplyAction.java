//�亯���� ���̺��� ������ �ִ� Action Ŭ����
//�� �亯 �� ���������� �亯 ������ �Է��ϰ� �亯�� Ŭ������ ��� �亯���� ���̺���
//�������ִ� ������ �ϴ� �׼� Ŭ�����Դϴ�.
package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//�Ķ���ͷ� ������ �� �ѱ��� ������ �ʵ��� �ϱ� ���� �����Դϴ�.
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		BoardDAO boarddao = new BoardDAO();
		BoardBean boarddata = new BoardBean();
		int result = 0;
		String page = request.getParameter("page");
		
		//�Ķ���ͷ� �Ѿ�� ������ boarddata ��ü�� �����մϴ�.
		boarddata.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
		boarddata.setBOARD_NAME(request.getParameter("BOARD_NAME"));
		boarddata.setBOARD_PASS(request.getParameter("BOARD_PASS"));
		boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
		boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
		boarddata.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
		boarddata.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
		boarddata.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));
		
		//�亯�� DB�� �����ϱ����� boarddata ��ü�� �Ķ���ͷ�
		//DAO�� �޼��� boardReply�� ȣ���մϴ�.
		result = boarddao.boardReply(boarddata);
		
		//�亯 ���忡 ������ ���
		if(result == 0){
			System.out.println("���� ����");
			return null;
		}
		
		//�亯 ������ ����� �� ���
		System.out.println("���� �Ϸ�");
		forward.setRedirect(true);
		//�亯 �� ������ Ȯ���ϱ� ���� �� ���� ���� �������� ��η� �����մϴ�.
		forward.setPath("./BoardDetailAction.bo?num=" + result + "&page=" + page);
		
		return forward;
	}

}