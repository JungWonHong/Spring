package semi.action.source;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.BoardDAO;
import semi.db.bean.SourceBoardBean;

public class sbBoardModifyView implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("euc-kr");
		
		BoardDAO boarddao=new BoardDAO();
		SourceBoardBean sb=new SourceBoardBean();
		
		//�Ķ���ͷ� ���޹��� ������ �� ��ȣ num ������ ����
		int num=Integer.parseInt(request.getParameter("num"));
		//�� ������ �ҷ��ͼ� sb�� ����
		sb=boarddao.sbgetDetail(num);
		
		//�� ���� �ҷ����� ������ ���
		if(sb==null){
			System.out.println("(����)�󼼺��� ����");
		}
		System.out.println("(����)�󼼺��� ����");
		
		//���� ���������� �̵��� �� ���� �� ������ �����ֱ� ������
		//sb ��ü�� request ��ü�� ����
		request.setAttribute("sb", sb);
		forward.setRedirect(false);
		forward.setPath("./semi/sourceboard/sbboard_modify.jsp");
		return forward;
	}
}
