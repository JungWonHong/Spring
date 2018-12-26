package ch12;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch12.db.MemberDAO;

public class Idcheckajax implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberdao = new MemberDAO();
		int result = -1; //�������� ���� ��
						 //result = 1(���̵� �����Ҷ�)
		
		String id = request.getParameter("id");
		
		result = memberdao.isId(id);
		PrintWriter out = response.getWriter();
		response.setHeader("cache-control", "no-cache,no-store");
		out.println(result);
		
		return null;
	}

}
