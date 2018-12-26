package semi.action.resume;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

public class ApplyCompanyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = new ActionForward();
		ResumeBean resume = new ResumeBean();
		ResumeDAO rdao = new ResumeDAO();
		HttpSession session = request.getSession();
		String url = (String)session.getAttribute("movepage");
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
			
			Enumeration certi = multi.getParameterNames();
			String certiName = "";
			String certiSave = "";
			while(certi.hasMoreElements()){
				certiName = (String)certi.nextElement();
				
				if(certiName.equals("test1") || certiName.equals("test2") || certiName.equals("test3")){
					certiSave += (multi.getParameter(certiName) + ",");
				}
			}
			
			resume.setR_id(multi.getParameter("p_id"));
			resume.setR_company(multi.getParameter("cmpname"));
			resume.setR_content(multi.getParameter("comment"));
			resume.setR_file(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
			resume.setR_certi(certiSave);
			
			result = rdao.resumeApply(resume);

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
