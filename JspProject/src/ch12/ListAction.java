package ch12;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch12.db.*;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		List<Member> list = mdao.getList();
		
		forward.setPath("./ch12_db/_8.member/ex3_servlet/member_list.jsp");
		forward.setRedirect(false);
		request.setAttribute("totallist", list);
		
		return forward;
	}

}
