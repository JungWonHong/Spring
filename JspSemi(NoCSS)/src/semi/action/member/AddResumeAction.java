package semi.action.member;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.*;
import semi.db.bean.*;

public class AddResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String url = (String)session.getAttribute("movepage");
		MemberDAO memdao = new MemberDAO();
		PMemberBean pmem = new PMemberBean();
		ActionForward forward = new ActionForward();

		String realFolder = "";
		String saveFolder = "portupload";
		int fileSize = 5 * 1024 * 1024;

		// 실제 저장 경로 지정
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);
		System.out.println("realFolder=" + realFolder);
		boolean result = false;
		
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder, fileSize, "euc-kr", new DefaultFileRenamePolicy());
			pmem.setP_id(multi.getParameter("p_id"));
			pmem.setP_resume(1);
			pmem.setP_comment(multi.getParameter("comment"));
			if(multi.getParameter("certi").equals("1"))
				pmem.setP_certi(1);
			else
				pmem.setP_certi(0);
			pmem.setP_portpolio(multi.getFilesystemName((String) multi.getFileNames().nextElement()));

			result = memdao.resumeUpdate(pmem);

			if (result == false) {
				System.out.println("이력서 등록 실패");
				return null;
			}
			System.out.println("이력서 등록 완료");

			forward.setRedirect(true);
			forward.setPath("." + url);
			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
