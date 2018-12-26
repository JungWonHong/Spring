package semi.action.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.*;
import semi.db.bean.ReviewBoardBean;

public class rvBoardModifyView implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("euc-kr");
		
		BoardDAO boarddao=new BoardDAO();
		ReviewBoardBean rv=new ReviewBoardBean();
		
		//�Ķ���ͷ� ���޹��� ������ �� ��ȣ num ������ ����
		int num=Integer.parseInt(request.getParameter("num"));
		//�� ������ �ҷ��ͼ� rv�� ����
		rv=boarddao.rvgetDetail(num);
		
		//�� ���� �ҷ����� ������ ���
		if(rv==null){
			System.out.println("(����)�󼼺��� ����");
		}
		System.out.println("(����)�󼼺��� ����");
		
		//���� ���������� �̵��� �� ���� �� ������ �����ֱ� ������
		//rv ��ü�� request ��ü�� ����
		request.setAttribute("rv", rv);
		forward.setRedirect(false);
		forward.setPath("./semi/reviewboard/rvboard_modify.jsp");
		return forward;
	}
}
