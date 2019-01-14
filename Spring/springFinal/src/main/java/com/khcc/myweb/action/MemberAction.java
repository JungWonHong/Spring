package com.khcc.myweb.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khcc.myweb.dao.MemberService;
import com.khcc.myweb.model.CardBean;
import com.khcc.myweb.model.MemberBean;

@Controller // Action 객체화 됨
			// 매핑에러 1. 컨트롤러 애노테이션 확인 2. 매핑 주소 확인
public class MemberAction {

	@Autowired
	private MemberService memberService;

	// 홈 화면
	@RequestMapping(value = "/khcc_home.nhn")
	public String khcc_home() throws Exception {
		return "member/khcc_home";
	}

	/* 로그인 폼 뷰 */
	@RequestMapping(value = "/khcc_login.nhn")
	public String khcc_login() throws Exception {
		return "member/khcc_login";
		// member 폴더의 khcc_login.jsp 뷰 페이지 실행
	}

	/* 로그아웃 폼 */
	@RequestMapping(value = "/khcc_logout.nhn")
	public void member_logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('로그아웃 되었습니다.')");
			out.println("location='khcc_home.nhn'");
			out.println("</script>");

			session.invalidate();// 세션만료

		}
	}

	/* 회원가입 폼 */
	@RequestMapping(value = "/khcc_join.nhn")
	public String khcc_join() {
		return "member/khcc_join";
		// member 폴더의 khcc_join.jsp 뷰 페이지 실행
	}

	/* 우편번호, 주소 등록 */
	@RequestMapping(value = "/addr_reg_ok.nhn", method = RequestMethod.POST)
	public ModelAndView addr_reg_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// 아이디 키값의 세션아이디를 구함
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// 세션 아이디 값이 없는 경우
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {

			String sample3_postcode = request.getParameter("sample3_postcode");
			String sample3_address = request.getParameter("sample3_address");
			String sample3_address2 = request.getParameter("sample3_address2");

			Map<String, String> ua = new HashMap<String, String>();
			ua.put("login_email", login_email);
			ua.put("sample3_postcode", sample3_postcode);
			ua.put("sample3_address", sample3_address);
			ua.put("sample3_address2", sample3_address2);

			this.memberService.addrUpdate(ua);

			MemberBean update_address = this.memberService.userCheck(login_email);

			ModelAndView mv = new ModelAndView("member/khcc_mypage");
			mv.addObject("info", update_address);

			return mv;
		}
		return null;
	}

	/* 우편번호, 주소 변경 */
	@RequestMapping(value = "/addr_edit_ok.nhn", method = RequestMethod.POST)
	public ModelAndView addr_edit_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// 아이디 키값의 세션아이디를 구함
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// 세션 아이디 값이 없는 경우
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {

			String sample3_postcode = request.getParameter("sample3_postcode");
			String sample3_address = request.getParameter("sample3_address");
			String sample3_address2 = request.getParameter("sample3_address2");

			Map<String, String> ua = new HashMap<String, String>();
			ua.put("login_email", login_email);
			ua.put("sample3_postcode", sample3_postcode);
			ua.put("sample3_address", sample3_address);
			ua.put("sample3_address2", sample3_address2);

			this.memberService.addrUpdate(ua);

			MemberBean update_address = this.memberService.userCheck(login_email);

			ModelAndView mv = new ModelAndView("member/khcc_mypage");
			mv.addObject("info", update_address);

			return mv;
		}
		return null;
	}

	// ID중복검사 ajax함수로 처리부분
	@RequestMapping(value = "/member_idcheck.nhn", method = RequestMethod.POST)
	public void member_idcheck(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PrintWriter out = response.getWriter();
		String id = request.getParameter("memid");

		Map<String, String> jm = new HashMap<String, String>();
		jm.put("check_id", id);

		int re = memberService.checkMemberId(id);
		out.print(re);

	}

	/* 비번찾기 완료 */
	@RequestMapping(value = "/pwd_find_ok.nhn", method = RequestMethod.POST)
	public ModelAndView pwd_find_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		String name = request.getParameter("name").trim();

		Map<String, String> pm = new HashMap<String, String>();
		// 컬렉션 Map에 키와 값 저장합니다.
		pm.put("id", id);
		pm.put("name", name);

		MemberBean member = this.memberService.findpwd(pm);

		if (member == null) {// 회원 아이디와 이름이 맞지 않는 경우
			out.println("<script>");
			out.println("alert('회원아이디와 이름이 맞지 않습니다!')");
			out.println("history.go(-1)");
			out.println("</script>");
		} else {
			ModelAndView pwdM = new ModelAndView("member/pwd_find");
			pwdM.addObject("pwdok", member.getM_password());
			return pwdM;
		}
		return null;
	}

	/* 회원 가입 저장 */
	// 뷰단 name 속성 값 = 자바단 Bean 필드 명 = 마이바티스 컬럼명
	@RequestMapping(value = "/member_join_ok.nhn", method = RequestMethod.POST)
	public void member_join_ok(MemberBean m, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String m_phone = m.getM_phone1() + "-" + m.getM_phone2() + "-" + m.getM_phone3();

		// 메일 아이디 : m.getM_email()
		// 메일 도메인 : m.getM_maildomain()
		String m_email = m.getM_email() + "@" + m.getM_maildomain();// 메일 주소
		m.setM_phone(m_phone);
		m.setM_email(m_email);

		this.memberService.insertMember(m);

		// 로그인 페이지로 이동
		response.sendRedirect("khcc_login.nhn");
	}

	/* 로그인 인증 */
	@RequestMapping(value = "/khcc_login_ok.nhn", method = RequestMethod.POST)
	public ModelAndView khcc_login_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// HttpSession 클래스는 세션객체를 생성해서 로그인 인증 처리를 하기 위해서입니다.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();// 출력스트림 객체 생성
		HttpSession session = request.getSession();// 세션 객체 생성

		String login_email = request.getParameter("login_email").trim();
		String login_password = request.getParameter("login_password").trim();

		MemberBean m = this.memberService.userCheck(login_email);

		if (m == null) {// 등록되지 않은 회원일때
			out.println("<script>");
			out.println("alert('등록되지 않은 회원입니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {// 등록된 회원일때
			if (m.getM_password().equals(login_password)) {// 비번이 같을때
				session.setAttribute("login_email", login_email);

				String m_name = m.getM_name();
				session.setAttribute("m_name", m_name);

				ModelAndView loginM = new ModelAndView("member/khcc_home");
				return loginM;
			} else {// 비번이 다를때
				out.println("<script>");
				out.println("alert('비밀번호가 다릅니다!')");
				out.println("history.go(-1)");
				out.println("</script>");
			}
		}
		return null;
	}

	// 관리자페이지 : 회원정보불러오기
	@RequestMapping(value = "/khcc_adminpage.nhn")
	public ModelAndView khcc_adminpage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String login_email = (String) session.getAttribute("login_email");

		MemberBean mypage = this.memberService.userCheck(login_email);

		String drivercode = (String) mypage.getM_drivercode();
		// java.util 패키지의 StringTokenizer 클래스는 첫번째 전달인자를
		// 두번째 -를 기준으로 문자열을 파싱해 줍니다.c1

		ModelAndView mm = new ModelAndView("member/khcc_adminpage");
		// 면허 번호 저장
		if (drivercode != null) {
			StringTokenizer st01 = new StringTokenizer(drivercode, "-");
			mm.addObject("d1", st01.nextToken());
			mm.addObject("d2", st01.nextToken());
			mm.addObject("d3", st01.nextToken());
			mm.addObject("d4", st01.nextToken());
		}
		mm.addObject("login_email", login_email);
		mm.addObject("info", mypage);

		MemberBean mycard = this.memberService.selectCard(login_email);

		if (mycard != null) {
			String cardNum = (String) mycard.getC_num();
			// java.util 패키지의 StringTokenizer 클래스는 첫번째 전달인자를
			// 두번째 -를 기준으로 문자열을 파싱해 줍니다.

			// 카드 정보 저장
			StringTokenizer st1 = new StringTokenizer(cardNum, "-");

			mm.addObject("c1", st1.nextToken());
			mm.addObject("c2", st1.nextToken());
			mm.addObject("c3", st1.nextToken());
			mm.addObject("c4", st1.nextToken());
			mm.addObject("c_name", mycard.getC_name());
			mm.addObject("c_expdate", mycard.getC_expdate());
		}
		mm.addObject("login_email", login_email);

		// 회원리스트
		List<MemberBean> memlist = this.memberService.getMemList();
		if (memlist != null) {
			mm.addObject("memlist", memlist);
		}

		return mm;
	}

	// 마이페이지 : 내 정보 불러오기
	@RequestMapping(value = "/khcc_mypage.nhn")
	public ModelAndView khcc_mypage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('로그인 해주세요!')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {

			MemberBean mypage = this.memberService.userCheck(login_email);

			String drivercode = (String) mypage.getM_drivercode();
			// java.util 패키지의 StringTokenizer 클래스는 첫번째 전달인자를
			// 두번째 -를 기준으로 문자열을 파싱해 줍니다.c1

			ModelAndView mm = new ModelAndView("member/khcc_mypage");
			// 면허 번호 저장
			if (drivercode != null) {
				StringTokenizer st01 = new StringTokenizer(drivercode, "-");
				mm.addObject("d1", st01.nextToken());
				mm.addObject("d2", st01.nextToken());
				mm.addObject("d3", st01.nextToken());
				mm.addObject("d4", st01.nextToken());
			}
			mm.addObject("login_email", login_email);
			mm.addObject("info", mypage);

			MemberBean mycard = this.memberService.selectCard(login_email);

			if (mycard != null) {
				String cardNum = (String) mycard.getC_num();
				// java.util 패키지의 StringTokenizer 클래스는 첫번째 전달인자를
				// 두번째 -를 기준으로 문자열을 파싱해 줍니다.

				// 카드 정보 저장
				StringTokenizer st1 = new StringTokenizer(cardNum, "-");

				mm.addObject("c1", st1.nextToken());
				mm.addObject("c2", st1.nextToken());
				mm.addObject("c3", st1.nextToken());
				mm.addObject("c4", st1.nextToken());
				mm.addObject("c_name", mycard.getC_name());
				mm.addObject("c_expdate", mycard.getC_expdate());
			}
			mm.addObject("login_email", login_email);

			// 결제 정보 저장
			List<MemberBean> paylist = this.memberService.selectPay(login_email);
			MemberBean cardinfo = this.memberService.selectCard(login_email);

			if (paylist != null) {
				// 결제일, 내역(차 위치), 카드 이름, 금액
				mm.addObject("pay", paylist);
				mm.addObject("card", cardinfo);
			}

			return mm;
		}
		return null;
	}

	/* 비밀번호 수정 폼 */
	@RequestMapping(value = "/pass_edit_ok.nhn")
	public ModelAndView pass_edit(MemberBean m, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// 아이디 키값의 세션아이디를 구함
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// 세션 아이디 값이 없는 경우
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			// 변경 창에서 입력한 새 비밀번호
			String new_pass = request.getParameter("new_pass1");

			Map<String, String> up = new HashMap<String, String>();
			// 컬렉션 Map에 키와 값 저장합니다.
			up.put("new_pass", new_pass);
			up.put("login_email", login_email);

			// 비밀번호 업데이트
			this.memberService.updatePass(up);

			MemberBean update_info = this.memberService.userCheck(login_email);

			ModelAndView mv = new ModelAndView("member/khcc_mypage");
			mv.addObject("info", update_info);

			return mv;
		}
		return null;
	}

	/* 휴대폰 번호 수정 폼 */
	@RequestMapping(value = "/phone_edit_ok.nhn")
	public ModelAndView phone_edit_ok(MemberBean m, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// 아이디 키값의 세션아이디를 구함
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// 세션 아이디 값이 없는 경우
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			String new_phone1 = request.getParameter("new_phone1");
			String new_phone2 = request.getParameter("new_phone2");
			String new_phone3 = request.getParameter("new_phone3");

			String new_phone = new_phone1 + "-" + new_phone2 + "-" + new_phone3;

			Map<String, String> up = new HashMap<String, String>();
			// 컬렉션 Map에 키와 값 저장합니다.
			up.put("new_phone", new_phone);
			up.put("login_email", login_email);

			// 비밀번호 업데이트
			this.memberService.updatePhone(up);

			MemberBean update_info = this.memberService.userCheck(login_email);

			ModelAndView mv = new ModelAndView("member/khcc_mypage");
			mv.addObject("info", update_info);

			return mv;
		}
		return null;
	}

	/* 카드번호 등록 */
	@RequestMapping(value = "/card_reg_ok.nhn")
	public void card_reg_ok(MemberBean C, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// 아이디 키값의 세션아이디를 구함
		String login_email = (String) session.getAttribute("login_email");

		if (login_email == null) {// 세션 아이디 값이 없는 경우
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			// 카드번호
			String cardNum1 = request.getParameter("cardNum1");
			String cardNum2 = request.getParameter("cardNum2");
			String cardNum3 = request.getParameter("cardNum3");
			String cardNum4 = request.getParameter("cardNum4");

			String c_num = cardNum1 + "-" + cardNum2 + "-" + cardNum3 + "-" + cardNum4;

			// 카드 이름
			String c_name = request.getParameter("cardName");

			// 카드 유효기간
			String expiryMonth = request.getParameter("expiryMonth");
			String expiryYear = request.getParameter("expiryYear");

			String c_expdate = expiryMonth + expiryYear;

			// 카드 생년월일
			String c_birth = request.getParameter("cardbirth");

			// 카드 비밀번호 앞 2자리
			String c_pass = request.getParameter("cardpass");

			// 멤버빈에 카드 정보 set
			C.setOwner(login_email);
			C.setC_name(c_name);
			C.setC_num(c_num);
			C.setC_expdate(c_expdate);
			C.setC_birth(c_birth);
			C.setC_pass(c_pass);

			this.memberService.insertCard(C);

			response.sendRedirect("khcc_mypage.nhn");

		}
	}

	/* 카드 삭제 */
	@RequestMapping(value = "/card_delete.nhn")
	public void card_delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();// 출력 스트림 객체 생성
		HttpSession session = request.getSession();// 세션 객체 생성

		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			String c1 = (String) request.getParameter("c1");
			String c2 = (String) request.getParameter("c2");
			String c3 = (String) request.getParameter("c3");
			String c4 = (String) request.getParameter("c4");

			String c_num = c1 + "-" + c2 + "-" + c3 + "-" + c4;

			String c_expdate = (String) request.getParameter("c_expdate");

			Map<String, String> dc = new HashMap<String, String>();
			dc.put("c_num", c_num);
			dc.put("c_expdate", c_expdate);

			this.memberService.deleteCard(dc);// 삭제 메서드 호출

			out.println("<script>");
			out.println("alert('선택하신 카드가 삭제되었습니다.')");
			out.println("</script>");
			response.sendRedirect("khcc_mypage.nhn");
		}
	}

	/* 면허정보 등록 */
	@RequestMapping(value = "/drivercode.nhn")
	public void drivercode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");

		String m_drivercode1 = request.getParameter("m_drivercode1");
		String m_drivercode2 = request.getParameter("m_drivercode2");
		String m_drivercode3 = request.getParameter("m_drivercode3");
		String m_drivercode4 = request.getParameter("m_drivercode4");

		String m_drivercode = m_drivercode1 + "-" + m_drivercode2 + "-" + m_drivercode3 + "-" + m_drivercode4;

		Map<String, String> up = new HashMap<String, String>();
		// 컬렉션 Map에 키와 값 저장합니다.
		up.put("m_drivercode", m_drivercode);
		up.put("login_email", login_email);

		// 면허 정보 업데이트
		this.memberService.updateDcode(up);
		response.sendRedirect("khcc_mypage.nhn");
	}

	/* 회원정보 삭제 폼 */
	@RequestMapping(value = "/member_delete.nhn")
	public ModelAndView member_del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();// 출력 스트림 객체 생성
		HttpSession session = request.getSession();// 세션 객체 생성

		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			MemberBean deleteM = this.memberService.userCheck(login_email);

			ModelAndView dm = new ModelAndView("member/member_del");
			dm.addObject("login_email", login_email);
			dm.addObject("m_name", deleteM.getM_name());
			return dm;
		}
		return null;
	}

	@RequestMapping(value = "/admin_delete.nhn")
	public String admin_del(HttpServletResponse response, @RequestParam("del_id") String del_id) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		MemberBean delm = new MemberBean();
		delm.setM_email(del_id);
		int del_ok = this.memberService.deleteMember(delm);

		if (del_ok != 0) {
			out.println("<script>");
			out.println("alert('탈퇴완료');");
			out.println("location.href='khcc_adminpage.nhn';");
			out.println("</script>");
		}
		
		return null;
	}

	/* 회원정보 삭제 완료 */
	@RequestMapping(value = "/member_del_ok.nhn", method = RequestMethod.POST)
	public void member_del_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			String pass = request.getParameter("del_password").trim();

			MemberBean member = this.memberService.userCheck(login_email);

			if (!member.getM_password().equals(pass)) {
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				MemberBean delm = new MemberBean();
				delm.setM_email(login_email);

				this.memberService.deleteMember(delm);// 삭제 메서드 호출

				session.invalidate();// 세션만료

				response.sendRedirect("khcc_home.nhn");
			}
		}
	}
}
