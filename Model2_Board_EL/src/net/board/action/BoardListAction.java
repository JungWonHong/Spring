package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import net.board.db.*;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		BoardDAO boarddao = new BoardDAO();
		List<BoardBean> boardlist = new ArrayList<BoardBean>();
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("�Ѿ�� ������ = " + page);
		
		int listcount = boarddao.getListCount();	//�� ����Ʈ ���� �޾ƿɴϴ�.
		boardlist = boarddao.getBoardList(page, limit); //����Ʈ�� �޾ƿɴϴ�.
		
		/* �� ������ �� =
		   (DB�� ����� �� ����Ʈ�� �� + �� ���������� �����ִ� ����Ʈ�� �� - 1)/�� ���������� �����ִ� ����Ʈ�� ��
		   
		   *  ���� ��� �� ���������� �����ִ� ����Ʈ�� ���� 10���� ���
		   ��1) DB�� ����� �� ����Ʈ�� ���� 0�̸� �� ���������� 0������
		   ��2) DB�� ����� �� ����Ʈ�� ���� ( 1~10)�̸� �� ���������� 1������
		   ��3) DB�� ����� �� ����Ʈ�� ���� (11~20)�̸� �� ���������� 2������
		   ��4) DB�� ����� �� ����Ʈ�� ���� (21~30)�̸� �� ���������� 3������
		 */
		
		int maxpage = (listcount + limit -1) / limit;
		System.out.println("�� �������� = " + maxpage);
		
		/*
			startpage : ���� ������ �׷쿡�� �� ó���� ǥ�õ� ������ ���� �ǹ��մϴ�.
						([1], [11], [21] �� ...)
			������ �������� 30���� ��� [1][2][3]....[30]���� �� ǥ�õǱ� �ʹ� ���� ������
			���� �� ���������� 10������ �������� �̵��� �� �ְ� ǥ���մϴ�.
		     ��) ������ �׷��� �Ʒ��� ���� ���
		      [1][2][3][4][5][6][7][8][9][10]
			    ������ �׷��� ���� �������� startpage�� ������ �������� endpage�� ���մϴ�.
		    
		    ���� 1~10�������� ������ ��Ÿ������ ������ �׷��� [1][2][3]..[10]�� ǥ�õǰ�
		     11~20�������� ������ ��Ÿ������ ������ �׷��� [11][12][13]..[20]���� ǥ�õ˴ϴ�.
		 */
		int startpage = ((page - 1) / 10) * 10 + 1;
		System.out.println("���� �������� ������ ���� ������ �� = " + startpage);
		
		//endpage : ���� ������ �׷쿡�� ������ ������ ������ ��([10], [20], [30] ��...)
		int endpage = startpage + 10 - 1;
		System.out.println("���� �������� ������ ������ ������ �� = " + endpage);
		
		/*
		 * ������ �׷��� ������ ������ ���� �ִ� ������ �Դϴ�.
		     ���� ������ ������ �׷��� [21]~[30]�� ��� 
		     ����������(startpage=>21)�� ������������(endpage=>30)
		     ������ �ִ� ������(maxpage)�� 25��� [21]~[25]������ ǥ�õǵ��� �մϴ�. 
		 */
		if (endpage > maxpage) 
			endpage = maxpage;
		
		//�� ����Ʈ�� ������ jsp�������� ������ ����
		request.setAttribute("page", page); //���� ������ ��
		request.setAttribute("maxpage", maxpage); //�ִ� ������ ��
		
		//���� �������� ǥ�õ� ù ������ ��
		request.setAttribute("startpage", startpage);
		
		//���� �������� ǥ���� �� ������
		request.setAttribute("endpage", endpage);
		
		request.setAttribute("listcount", listcount); //�� ���� ��
		
		//�ش� �������� �� ����� ���� �ִ� ����Ʈ
		request.setAttribute("boardlist", boardlist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		//�� ��� �������� �̵��ϱ� ���� ��θ� �����մϴ�.
		forward.setPath("./board/qna_board_list.jsp");
		
		return forward; //BoardFrontController.java�� �����մϴ�.
	}

}