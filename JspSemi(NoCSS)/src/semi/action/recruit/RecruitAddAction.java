package semi.action.recruit;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.*;
import semi.db.bean.*;

public class RecruitAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		BoardDAO boarddao = new BoardDAO();
		RecruitBoardBean boarddata = new RecruitBoardBean();
		ActionForward forward = new ActionForward();
		String realFolder = "";
		// WebContent 아래에 꼭 폴더 생성하세요
		String saveFolder = "resumeupload";

		int fileSize = 5 * 1024 * 1024; // 업로드할 파일의 최대 사이즈 입니다. 5MB

		// 실제 저장 경로를 지정합니다.
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);
		// realFolder =
		// request.getSession().getServletContext().getRealPath(saveFolder);
		System.out.println("realFolder = " + realFolder);
		boolean result = false;

		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder, fileSize, "euc-kr", 
									new DefaultFileRenamePolicy());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date parsed = format.parse(multi.getParameter("rc_expire"));
	        java.sql.Date expire_date = new java.sql.Date(parsed.getTime());
			
	        boarddata.setRc_company(multi.getParameter("rc_company"));
			boarddata.setRc_hirekind(Integer.parseInt(multi.getParameter("rc_hirekind")));
			boarddata.setRc_career(Integer.parseInt(multi.getParameter("rc_career")));
			boarddata.setRc_sal(Integer.parseInt(multi.getParameter("rc_sal")));
			boarddata.setRc_ability(multi.getParameter("rc_ability"));
			boarddata.setRc_worktime(multi.getParameter("rc_worktime"));
			boarddata.setRc_expire(expire_date);
			boarddata.setRc_title(multi.getParameter("rc_title"));
			boarddata.setRc_content(multi.getParameter("rc_content"));
			boarddata.setRc_file(multi.getFilesystemName((String)multi.getFileNames().nextElement()));

			// 글 등록 처리를 위해 DAO의 boardInsert()메서드를 호출합니다.
			// 글 등록 폼에서 입력한 정보가 저장되어 있는 boarddata 객체를 전달합니다.
			result = boarddao.recruitInsert(boarddata);

			// 글 등록에 실패할 경우 null을 반환합니다.

			if (result == false) {
				System.out.println("게시판 등록 실패");
				return null;
			}
			System.out.println("게시판 등록 완료");

			forward.setRedirect(true);
			forward.setPath("./RecruitList.bo");
			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
