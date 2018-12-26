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
		//글번호 파라미터 값을 num변수에 저장
		int boardnum;
		if(request.getParameter("num") == null){
			boardnum = (int) session.getAttribute("num"); 
		} else {
			boardnum = Integer.parseInt(request.getParameter("num"));
			session.setAttribute("num", boardnum);
		}

		
		//내용을 확인할 글의 조회수를 증가 시킵니다.
		boarddao.rvsetReadCountUpdate(boardnum);
		
		//글의 내용을 DAO에서 읽은 후 얻은 결과를 rv 객체에 저장
		rv=boarddao.rvgetDetail(boardnum);
		
		//DAO에서 글의 내용을 읽지 못했을 경우 null반환
		if(rv==null){
			System.out.println("상세보기 실패");
		}
		System.out.println("상세보기 성공");
		
		//boarddata 객체를 rdquest 객체에 저장
		request.setAttribute("rv", rv);
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		
		//글 내용 보기 페이지로 이동하기 위해 경로 설정
		forward.setPath("./semi/reviewboard/rvboard_view.jsp");
		return forward;
	}

}
