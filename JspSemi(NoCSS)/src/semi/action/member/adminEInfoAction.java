package semi.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

//������������ - ���ȸ�� ���̵� Ŭ�� �� �⺻���� �� �������� �̵��ϴ� �κ�
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