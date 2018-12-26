package semi.action.resume;

import java.io.PrintWriter;

import javax.servlet.http.*;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

public class ApplyViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String cmp = request.getParameter("cmp");
		
		PMemberBean pmember = new PMemberBean();
		MemberDAO mdao = new MemberDAO();
		ResumeDAO rdao = new ResumeDAO();
		if(!rdao.checkResume(id) || id == null){ //��ϵ� �̷¼��� 3���� false
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(id == null)
				out.println("alert('�α��� ���ּ���');");
			else
				out.println("alert('�̷¼��� �ִ� 3������ �ۼ������մϴ�');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		//���� 3������ Ȯ��
		pmember = mdao.Pmember_info(id);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		request.setAttribute("pmember", pmember);
		request.setAttribute("cmpname", cmp);
		forward.setPath("./semi/resume/Resume_apply.jsp");
		return forward;
	}

}
