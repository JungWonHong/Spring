package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

//관리자페이지 - 개인회원 아이디 클릭 시 기본정보 상세 페이지로 이동하는 부분
public class adminPInfoAction implements Action{
	   public ActionForward execute(HttpServletRequest request,
	            HttpServletResponse response)throws Exception {
	      ActionForward forward = new ActionForward();
	      request.setCharacterEncoding("euc-kr");
	      MemberDAO mdao = new MemberDAO();
	      String id = request.getParameter("id");
	      
	      PMemberBean pmember = new PMemberBean();
	      pmember = mdao.pview(id);
	      
	      request.setAttribute("pmember", pmember);
	      
	      forward.setPath("./semi/member/pinfo.jsp");
	      forward.setRedirect(false);
	      
	      return forward;
   }
}