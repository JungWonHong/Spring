package semi.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.MemberDAO;
import semi.db.bean.PMemberBean;

public class PJoinAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PMemberBean pmember = new PMemberBean();

		request.setCharacterEncoding("euc-kr");

		String name = request.getParameter("p_name");
		String id = request.getParameter("p_id");
		String pass = request.getParameter("p_pw");
		String email = "";
		if(request.getParameter("email_dns") != null)
			email = request.getParameter("p_email") + "@" + request.getParameter("email_dns"); //�����α��� �����ؾ���.
		else
			email = request.getParameter("p_email") + "@" + request.getParameter("emailaddr");
		String phone = request.getParameter("p_hp") + request.getParameter("p_hp2") + request.getParameter("p_hp3");
		int age = Integer.parseInt(request.getParameter("p_age"));

		pmember.setP_id(id);
		pmember.setP_pw(pass);
		pmember.setP_name(name);
		pmember.setP_email(email);
		pmember.setP_hp(phone);
		pmember.setP_age(age);

		MemberDAO mdao = new MemberDAO();
		int result = mdao.insert(pmember);

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
