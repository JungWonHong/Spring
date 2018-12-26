package semi.action.source;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.*;
import semi.db.bean.CommentsBean;
import semi.db.bean.SourceBoardBean;

public class sbBoardDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		BoardDAO boarddao = new BoardDAO();
		SourceBoardBean sb = new SourceBoardBean();
		HttpSession session = request.getSession();

		// �۹�ȣ �Ķ���� ���� num������ ����
		// int num = Integer.parseInt((String)session.getAttribute("boardnum"));
		// //���⼭����
		int boardnum;
		if(request.getParameter("num") == null){
			boardnum = (int) session.getAttribute("num"); 
		} else {
			boardnum = Integer.parseInt(request.getParameter("num"));
			session.setAttribute("num", boardnum);
		}
		 
		// ������ Ȯ���� ���� ��ȸ���� ���� ��ŵ�ϴ�.
		boarddao.sbsetReadCountUpdate(boardnum);

		// ���� ������ DAO���� ���� �� ���� ����� sb ��ü�� ����
		sb = boarddao.sbgetDetail(boardnum);

		// DAO���� ���� ������ ���� ������ ��� null��ȯ
		if (sb == null) {
			System.out.println("�󼼺��� ����");
		}
		System.out.println("�󼼺��� ����");

		CommentsDAO commentsdao = new CommentsDAO();
		List<CommentsBean> commentslist = new ArrayList<CommentsBean>();

		int cmtpage = 1;
		int limit = 10;

		if (request.getParameter("cmtpage") != null) {
			cmtpage = Integer.parseInt(request.getParameter("cmtpage"));
		}
		System.out.println("�Ѿ�� ������ = " + cmtpage);
		int cmtlistcount = commentsdao.getCommentsListCount(boardnum); // �� ����Ʈ ����
																// �޾ƿɴϴ�.
		commentslist = commentsdao.getCommentsList(cmtpage, limit, boardnum); // ����Ʈ��
																	// �޾ƿɴϴ�.

		int cmtmaxpage = (cmtlistcount + limit - 1) / limit;
		System.out.println("�� ������ �� = " + cmtmaxpage);

		int cmtstartpage = ((cmtpage - 1) / 10) * 10 + 1; // ����������
		System.out.println("���� �������� ������ ���� ������ �� = " + cmtstartpage);

		int cmtendpage = cmtstartpage + 10 - 1; // ������������
		System.out.println("���� �������� ������ ������ ������ �� = " + cmtendpage);

		if (cmtendpage > cmtmaxpage)
			cmtendpage = cmtmaxpage;

		request.setAttribute("cmtpage", cmtpage);
		request.setAttribute("cmtmaxpage", cmtmaxpage);

		request.setAttribute("cmtstartpage", cmtstartpage);

		request.setAttribute("cmtendpage", cmtendpage);

		request.setAttribute("cmtlistcount", cmtlistcount); // �� ���� ��

		request.setAttribute("commentslist", commentslist);

		// boarddata ��ü�� rdquest ��ü�� ����
		request.setAttribute("sb", sb);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		// �� ���� ���� �������� �̵��ϱ� ���� ��� ����
		forward.setPath("./semi/sourceboard/sbboard_view.jsp");
		return forward;
	}

}
