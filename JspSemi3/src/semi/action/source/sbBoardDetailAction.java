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

		// 글번호 파라미터 값을 num변수에 저장
		// int num = Integer.parseInt((String)session.getAttribute("boardnum"));
		// //여기서부터
		int boardnum;
		if(request.getParameter("num") == null){
			boardnum = (int) session.getAttribute("num"); 
		} else {
			boardnum = Integer.parseInt(request.getParameter("num"));
			session.setAttribute("num", boardnum);
		}
		 
		// 내용을 확인할 글의 조회수를 증가 시킵니다.
		boarddao.sbsetReadCountUpdate(boardnum);

		// 글의 내용을 DAO에서 읽은 후 얻은 결과를 sb 객체에 저장
		sb = boarddao.sbgetDetail(boardnum);

		// DAO에서 글의 내용을 읽지 못했을 경우 null반환
		if (sb == null) {
			System.out.println("상세보기 실패");
		}
		System.out.println("상세보기 성공");

		CommentsDAO commentsdao = new CommentsDAO();
		List<CommentsBean> commentslist = new ArrayList<CommentsBean>();

		int cmtpage = 1;
		int limit = 10;

		if (request.getParameter("cmtpage") != null) {
			cmtpage = Integer.parseInt(request.getParameter("cmtpage"));
		}
		System.out.println("넘어온 페이지 = " + cmtpage);
		int cmtlistcount = commentsdao.getCommentsListCount(boardnum); // 총 리스트 수를
																// 받아옵니다.
		commentslist = commentsdao.getCommentsList(cmtpage, limit, boardnum); // 리스트를
																	// 받아옵니다.

		int cmtmaxpage = (cmtlistcount + limit - 1) / limit;
		System.out.println("총 페이지 수 = " + cmtmaxpage);

		int cmtstartpage = ((cmtpage - 1) / 10) * 10 + 1; // 시작페이지
		System.out.println("현재 페이지에 보여줄 시작 페이지 수 = " + cmtstartpage);

		int cmtendpage = cmtstartpage + 10 - 1; // 마지막페이지
		System.out.println("현재 페이지에 보여줄 마지막 페이지 수 = " + cmtendpage);

		if (cmtendpage > cmtmaxpage)
			cmtendpage = cmtmaxpage;

		request.setAttribute("cmtpage", cmtpage);
		request.setAttribute("cmtmaxpage", cmtmaxpage);

		request.setAttribute("cmtstartpage", cmtstartpage);

		request.setAttribute("cmtendpage", cmtendpage);

		request.setAttribute("cmtlistcount", cmtlistcount); // 총 글의 수

		request.setAttribute("commentslist", commentslist);

		// boarddata 객체를 rdquest 객체에 저장
		request.setAttribute("sb", sb);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		// 글 내용 보기 페이지로 이동하기 위해 경로 설정
		forward.setPath("./semi/sourceboard/sbboard_view.jsp");
		return forward;
	}

}
