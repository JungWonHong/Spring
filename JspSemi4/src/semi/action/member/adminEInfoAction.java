package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

//관리자페이지 - 기업회원 아이디 클릭 시 기본정보 상세 페이지로 이동하는 부분
public class adminEInfoAction implements Action{
	   public ActionForward execute(HttpServletRequest request,
	            HttpServletResponse response)throws Exception {
	      ActionForward forward = new ActionForward();
	      request.setCharacterEncoding("euc-kr");
	      String id = request.getParameter("id");
	      
	      MemberDAO mdao = new MemberDAO();
	      
	      EMemberBean emember = new EMemberBean();
	      emember = mdao.eview(id);
	      
	      request.setAttribute("emember", emember);
	      
	      
	      forward.setPath("./semi/member/einfo.jsp");
	      forward.setRedirect(false);
	      
	      
	      return forward;
   }
}