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
		
		//파라미터로 전달받은 수정할 글 번호 num 변수에 저장
		int num=Integer.parseInt(request.getParameter("num"));
		//글 내용을 불러와서 sb에 저장
		sb=boarddao.sbgetDetail(num);
		
		//글 내용 불러오기 실패한 경우
		if(sb==null){
			System.out.println("(수정)상세보기 실패");
		}
		System.out.println("(수정)상세보기 성공");
		
		//수정 폼페이지로 이동할 때 원문 글 내용을 보여주기 때문에
		//sb 객체를 request 객체에 저장
		request.setAttribute("sb", sb);
		forward.setRedirect(false);
		forward.setPath("./semi/sourceboard/sbboard_modify.jsp");
		return forward;
	}
}
