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
		
		//파라미터로 전달받은 수정할 글 번호 num 변수에 저장
		int num=Integer.parseInt(request.getParameter("num"));
		//글 내용을 불러와서 rv에 저장
		rv=boarddao.rvgetDetail(num);
		
		//글 내용 불러오기 실패한 경우
		if(rv==null){
			System.out.println("(수정)상세보기 실패");
		}
		System.out.println("(수정)상세보기 성공");
		
		//수정 폼페이지로 이동할 때 원문 글 내용을 보여주기 때문에
		//rv 객체를 request 객체에 저장
		request.setAttribute("rv", rv);
		forward.setRedirect(false);
		forward.setPath("./semi/reviewboard/rvboard_modify.jsp");
		return forward;
	}
}
