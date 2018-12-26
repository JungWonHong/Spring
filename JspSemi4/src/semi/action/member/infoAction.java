package semi.action.member;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.MemberDAO;
import semi.db.bean.EMemberBean;
import semi.db.bean.PMemberBean;

public class infoAction implements Action{
	   public ActionForward execute(HttpServletRequest request,
	            HttpServletResponse response)throws Exception {
	      ActionForward forward = new ActionForward();
	      request.setCharacterEncoding("euc-kr");
	      
	      MemberDAO mdao = new MemberDAO();
	      List<EMemberBean> ememlist = new ArrayList<EMemberBean>();
	      List<PMemberBean> pmemlist = new ArrayList<PMemberBean>();
	      
	      ememlist = mdao.ememlist();
	      pmemlist = mdao.pmemlist();
	      
	      request.setAttribute("ememlist", ememlist);
	      request.setAttribute("pmemlist", pmemlist);
	      
	      forward.setPath("./semi/member/adminPage.jsp");
	      forward.setRedirect(false);
	      
	      return forward;
   }
}