package semi.action.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.BoardDAO;
import semi.db.bean.ReviewBoardBean;

public class rvBoardDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		BoardDAO boarddao=new BoardDAO();
		ReviewBoardBean rv=new ReviewBoardBean();
		HttpSession session = request.getSession();
		//�۹�ȣ �Ķ���� ���� num������ ����
		int boardnum;
		if(request.getParameter("num") == null){
			boardnum = (int) session.getAttribute("num"); 
		} else {
			boardnum = Integer.parseInt(request.getParameter("num"));
			session.setAttribute("num", boardnum);
		}

		
		//������ Ȯ���� ���� ��ȸ���� ���� ��ŵ�ϴ�.
		boarddao.rvsetReadCountUpdate(boardnum);
		
		//���� ������ DAO���� ���� �� ���� ����� rv ��ü�� ����
		rv=boarddao.rvgetDetail(boardnum);
		
		//DAO���� ���� ������ ���� ������ ��� null��ȯ
		if(rv==null){
			System.out.println("�󼼺��� ����");
		}
		System.out.println("�󼼺��� ����");
		
		//boarddata ��ü�� rdquest ��ü�� ����
		request.setAttribute("rv", rv);
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		
		//�� ���� ���� �������� �̵��ϱ� ���� ��� ����
		forward.setPath("./semi/reviewboard/rvboard_view.jsp");
		return forward;
	}

}
