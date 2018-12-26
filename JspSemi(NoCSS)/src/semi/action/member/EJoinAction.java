package semi.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.MemberDAO;
import semi.db.bean.EMemberBean;

public class EJoinAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EMemberBean emember = new EMemberBean();

		request.setCharacterEncoding("euc-kr");

		String memname = request.getParameter("e_memname");
		String id = request.getParameter("e_id");
		String pass = request.getParameter("e_pw");
		String email = "";
		if(request.getParameter("email_dns") != null)
			email = request.getParameter("e_email") + "@" + request.getParameter("email_dns"); //�����α��� �����ؾ���.
		else
			email = request.getParameter("e_email") + "@" + request.getParameter("emailaddr");
		String company = request.getParameter("e_company");
		String phone = request.getParameter("e_hp") + request.getParameter("e_hp2") + request.getParameter("e_hp3");
		
		emember.setE_memname(memname);
		emember.setE_id(id);
		emember.setE_pw(pass);
		emember.setE_company(company);
		emember.setE_email(email);
		emember.setE_phone(phone);
		
		MemberDAO mdao = new MemberDAO();
		int result = mdao.insert2(emember);

		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		// ������ �� ���
		if (result == 1) {
			out.println("alert('ȸ�������� �����մϴ�.');");
			out.println("location.href='./login.com';");
		} else if (result == -1) {
			out.println("alert('���̵� �ߺ��Ǿ����ϴ�. �ٽ� �Է��ϼ���');");
			// out.println("location.href='./join.net';"); //���ΰ�ħ�Ǿ�
			out.println("history.back()");// ��й�ȣ�� ������ �ٸ� �����ʹ� ����
		}
		out.println("</script>");
		out.close();
		return null;
	}

}
