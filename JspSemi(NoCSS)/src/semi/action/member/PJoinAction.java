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
			email = request.getParameter("p_email") + "@" + request.getParameter("email_dns"); //도메인까지 저장해야함.
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
