package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.MemberDAO;

//회원가입시 아이디 중복 검사를 위해 호출되는 Action 클래스
public class MemberIdCheckAction implements Action {
	 public ActionForward execute(HttpServletRequest request,
	            HttpServletResponse response)throws Exception {
		 
		 
		 ActionForward forward = new ActionForward();
		 
		 String p_id = request.getParameter("p_id");
		 String e_id = request.getParameter("e_id");
		 
		 MemberDAO mdao = new MemberDAO();
		 
		 int p_check = mdao.confirmId(p_id);
		 int e_check = mdao.confirmId(e_id);
		 
		 System.out.println(p_check);
		 System.out.println(e_check);
		 
		 request.setAttribute("p_id", p_id);
		 request.setAttribute("e_id", e_id);
		 
		 request.setAttribute("p_check", p_check);
		 request.setAttribute("e_check", e_check);
		 
		 forward.setPath("./semi/member/member_Idchk.jsp");
		 return forward;
		 
	 }
}
