//�� ���� ȭ���� ������ִ� Action Ŭ����
package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;
import net.board.db.BoardBean;

public class BoardModifyView implements Action {
	 public ActionForward execute(HttpServletRequest request,
			 HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
		 	request.setCharacterEncoding("euc-kr");
	   		
			BoardDAO boarddao=new BoardDAO();
		   	BoardBean boarddata=new BoardBean();
		   	
		   	//�Ķ���ͷ� ���޹��� ������ �� ��ȣ�� num������ �����մϴ�.
			int num=Integer.parseInt(request.getParameter("num"));
			//�� ������ �ҷ��ͼ� boarddata��ü�� �����մϴ�.
		   	boarddata=boarddao.getDetail(num);
		   	
		   	//�� ���� �ҷ����� ������ ����Դϴ�.
		   	if(boarddata==null){
		   		System.out.println("(����)�󼼺��� ����");
		   		return null;
		   	}
		   	System.out.println("(����)�󼼺��� ����");
		   	
		   	//���� �� �������� �̵��� �� ���� �� ������ �����ֱ� ������ boarddata 
		   	//��ü�� Request ��ü�� �����մϴ�.
		   	request.setAttribute("boarddata", boarddata);
		   	forward.setRedirect(false);
		   	//�� ���� �� �������� �̵��ϱ����� ��θ� �����մϴ�.
	   		forward.setPath("./board/qna_board_modify.jsp");
	   		return forward;
	 }
}