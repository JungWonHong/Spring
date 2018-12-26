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
		// WebContent �Ʒ��� �� ���� �����ϼ���
		String saveFolder = "resumeupload";

		int fileSize = 5 * 1024 * 1024; // ���ε��� ������ �ִ� ������ �Դϴ�. 5MB

		// ���� ���� ��θ� �����մϴ�.
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

			// �� ��� ó���� ���� DAO�� boardInsert()�޼��带 ȣ���մϴ�.
			// �� ��� ������ �Է��� ������ ����Ǿ� �ִ� boarddata ��ü�� �����մϴ�.
			result = boarddao.recruitInsert(boarddata);

			// �� ��Ͽ� ������ ��� null�� ��ȯ�մϴ�.

			if (result == false) {
				System.out.println("�Խ��� ��� ����");
				return null;
			}
			System.out.println("�Խ��� ��� �Ϸ�");

			forward.setRedirect(true);
			forward.setPath("./RecruitList.bo");
			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
