package semi.action.recruit;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

public class RecruitAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		BoardDAO boarddao = new BoardDAO();
		RecruitBoardBean boarddata = new RecruitBoardBean();
		ActionForward forward = new ActionForward();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = format.parse(request.getParameter("rc_expire"));
		java.sql.Date expire_date = new java.sql.Date(parsed.getTime());

		boarddata.setRc_company(request.getParameter("rc_company"));
		System.out.println(request.getParameter("rc_company"));
		boarddata.setRc_hirekind(Integer.parseInt(request.getParameter("rc_hirekind")));
		boarddata.setRc_career(Integer.parseInt(request.getParameter("rc_career")));
		boarddata.setRc_sal(Integer.parseInt(request.getParameter("rc_sal")));
		boarddata.setRc_ability(request.getParameter("rc_ability"));
		boarddata.setRc_worktime(request.getParameter("rc_worktime"));
		boarddata.setRc_expire(expire_date);
		boarddata.setRc_title(request.getParameter("rc_title"));
		boarddata.setRc_content(request.getParameter("rc_content"));
		boarddata.setRc_url(request.getParameter("rc_url"));

		// 글 등록 처리를 위해 DAO의 boardInsert()메서드를 호출합니다.
		// 글 등록 폼에서 입력한 정보가 저장되어 있는 boarddata 객체를 전달합니다.
		boolean result = boarddao.recruitInsert(boarddata);

		// 글 등록에 실패할 경우 null을 반환합니다.

		if (result == false) {
			System.out.println("게시판 등록 실패");
			return null;
		}
		System.out.println("게시판 등록 완료");

		forward.setRedirect(true);
		forward.setPath("./RecruitList.bo");
		return forward;

	}

}
