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
		
		//글번호 파라미터 값을 num변수에 저장합니다.
		int num = Integer.parseInt(request.getParameter("num"));
		
		//내용을 확인할 글의 조회수를 증가시킵니다.
		boarddao.setReadCountUpdate(num);
		
		//글의 내용을 DAO에서 읽은 후 얻은 결과를 boarddata 객체에 저장합니다.
		boarddata = boarddao.getDetail(num);
		
		//DAO에서 글의 내용을 읽지 못했을 경우 null을 반환합니다.
		if(boarddata == null){
			System.out.println("상세보기 실패");
			return null;
		}
		
		System.out.println("상세보기 성공");
		
		//boarddata 객체를 Request객체에 저장합니다.
		request.setAttribute("boarddata", boarddata);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		//글 내용 보기 페이지로 이동하기 위해 경로를 설정합니다.
		forward.setPath("./ch14/_1.Model2/board/qna_board_view.jsp");
		
		return forward;
	}

}
