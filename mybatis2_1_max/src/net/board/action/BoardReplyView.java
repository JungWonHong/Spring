package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO_max;

public class BoardReplyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardDAO_max boarddao = new BoardDAO_max();
		BoardBean boarddata = new BoardBean();

		// 파라미터로 전달받은 답변할 글 번호를 num변수에 저장합니다.
		int num = Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		// 글 번호 num에 해당하는 내용을 가져와서 boarddata 객체에 저장합니다.
		boarddata = boarddao.getDetail(num);

		// 글 내용이 없는 경우
		if (boarddata == null) {
			System.out.println("답장 페이지 이동 실패");
			return null;
		}

		System.out.println("답장 페이지 이동 완료");

		// 답변 폼 페이지로 이동할 때 원본 글 내용을 보여주기 위해 boarddata객체를 Request에 저장
		request.setAttribute("boarddata", boarddata);
		request.setAttribute("page", page);
		forward.setRedirect(false);

		// 글 답변 페이지 경로 지정합니다.
		forward.setPath("./board/qna_board_reply.jsp");

		return forward;
	}

}
