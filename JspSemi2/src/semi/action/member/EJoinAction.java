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
			email = request.getParameter("e_email") + "@" + request.getParameter("email_dns"); //도메인까지 저장해야함.
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
		// 삽입이 된 경우
		if (result == 1) {
			out.println("alert('회원가입을 축하합니다.');");
			out.println("location.href='./login.com';");
		} else if (result == -1) {
			out.println("alert('아이디가 중복되었습니다. 다시 입력하세요');");
			// out.println("location.href='./join.net';"); //새로고침되어
			out.println("history.back()");// 비밀번호를 제외한 다른 데이터는 유지
		}
		out.println("</script>");
		out.close();
		return null;
	}

}
