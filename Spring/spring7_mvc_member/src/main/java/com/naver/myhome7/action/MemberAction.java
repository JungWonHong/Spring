package com.naver.myhome7.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome7.dao.MemberService;
import com.naver.myhome7.model.MemberBean;
import com.naver.myhome7.model.ZipcodeBean;
import com.naver.myhome7.model.ZipcodeBean2;

@Controller
public class MemberAction {

	//MemberService�� �����ؼ� ������� ������ ã�Ƽ� �����Ѵ� -> �������� ���� MemberServiceImpl�� ã�ư���.
	@Autowired
	private MemberService memberService;
	
	// ������ �ʿ��� ���
	// private String saveFolder="C:/Program Files/Apache Software Foundation/Tomcat
	// 8.5/webapps/myhome7/resources/upload";
	private String saveFolder = "I:\\KH\\Spring\\spring7_mvc_member\\src\\main\\webapp\\resources\\upload";

	//ID�ߺ��˻� ajax�Լ��� ÷���κ�
	@RequestMapping(value="/member_idcheck.nhn", method=RequestMethod.POST)
	public void member_idcheck(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("memid");
		
		int re = memberService.checkMemberId(id);
		out.print(re);
	}
	
	/* �α��� �� �� */
	@RequestMapping(value = "/member_login.nhn")
	public String member_login() throws Exception {
		return "member/member_login";
		// member ������ member_login.jsp �� ������ ����
	}

	/* �α׾ƿ� �� */
	@RequestMapping(value = "/member_logout.nhn")
	public String member_logout() {
		return "member/member_logout";
		// member ������ member_logout.jsp �� ������ ����
	}

	/*
	 * servlet-contex.xml���� �����߱� ������ �Ʒ��� ������ ���� �����մϴ�. <view-controller
	 * path="/pwd_find.nhn" view-name="member/pwd_find"/>
	 */
	/* ���ã�� �� */
	/*
	 * @RequestMapping(value="/pwd_find.nhn") public String pwd_find(){ return
	 * "member/pwd_find"; //member ������ pwd_find.jsp �� ������ ���� }
	 */

	/* ȸ������ �� */
	@RequestMapping(value = "/member_join.nhn")
	public String member_join() {
		return "member/member_join";
		// member ������ member_join.jsp �� ������ ����
	}

	/* ����˻� �� */
	@RequestMapping(value = "/zipcode_find.nhn")
	public String zipcode_find() {
		return "member/zipcode_find";
		// member ������ zipcode_find.jsp �� ������ ����
	}

	/* �����ȣ DB�� ���� �˻� */
	@RequestMapping(value = "/zipcode_find_ok.nhn", method = RequestMethod.POST)
	public ModelAndView zicode_find_ok(@RequestParam String dong, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println(dong);
		List<ZipcodeBean2> zipcodeList = new ArrayList<ZipcodeBean2>();

		// ���� �������� �ּҸ� �˻��ؼ� �÷��ǿ� �����մϴ�.
		zipcodeList = this.memberService.findZipcode("%" + dong + "%");

		List<ZipcodeBean> zipcodeList2 = new ArrayList<ZipcodeBean>();

		for (int i = 0; i < zipcodeList.size(); i++) {
			ZipcodeBean2 zipcode_addr = zipcodeList.get(i);

			String zipcode = zipcode_addr.getZipcode();// �����ȣ ����
			String sido = zipcode_addr.getSido(); // �����,��⵵ ����
			String gugun = zipcode_addr.getGugun();// ��,��
			String dong2 = zipcode_addr.getDong(); // ��
			String bunji = zipcode_addr.getBunji(); //����
			
			String addr = sido + " " + gugun + " " + dong2 + " " + bunji;// ����� ���ʱ� ���ʵ�
 
			ZipcodeBean zip = new ZipcodeBean();
			zip.setZipcode(zipcode);
			zip.setAddr(addr);

			// �÷��ǿ� �ּҸ� �����մϴ�.
			zipcodeList2.add(zip);
		}

		ModelAndView zipcodeM = new ModelAndView("member/zipcode_find");
		zipcodeM.addObject("zipcodelist", zipcodeList2);
		zipcodeM.addObject("dong", dong);

		return zipcodeM;
	}

	/* ���ã�� �Ϸ� */
	@RequestMapping(value = "/pwd_find_ok.nhn", method = RequestMethod.POST)
	public ModelAndView pwd_find_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id").trim();
		String name = request.getParameter("name").trim();

		Map pm = new HashMap();
		// �÷��� Map�� Ű�� �� �����մϴ�.
		pm.put("id", id);
		pm.put("name", name);

		MemberBean member = this.memberService.findpwd(pm);

		if (member == null) {// ȸ�� ���̵�� �̸��� ���� �ʴ� ���
			out.println("<script>");
			out.println("alert('ȸ�����̵�� �̸��� ���� �ʽ��ϴ�!')");
			out.println("history.go(-1)");
			out.println("</script>");
		} else {
			ModelAndView pwdM = new ModelAndView("member/pwd_find");
			pwdM.addObject("pwdok", member.getJoin_pwd());
			return pwdM;
		}
		return null;
	}

	/* ȸ�� ���� ���� */
	@RequestMapping(value = "/member_join_ok.nhn", method = RequestMethod.POST)
	public void member_join_ok(MemberBean m, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String join_tel = m.getJoin_tel1() + "-" + m.getJoin_tel2() + "-" + m.getJoin_tel3();

		String join_phone = m.getJoin_phone1() + "-" + m.getJoin_phone2() + "-" + m.getJoin_phone3();

		// ���� ���̵� : m.getJoin_mailid()
		// ���� ������ : m.getJoin_maildomain()
		String join_email = m.getJoin_mailid() + "@" + m.getJoin_maildomain();// ���� �ּ�
		m.setJoin_tel(join_tel);
		m.setJoin_phone(join_phone);
		m.setJoin_email(join_email);

		MultipartFile UpFile = m.getJoin_profile();

		if (!UpFile.isEmpty()) {// ÷���� ���������� �ִٸ�
			String fileName = UpFile.getOriginalFilename();// �������ϸ� ����
			m.setJoin_original(fileName);
			Calendar c = Calendar.getInstance();// �߻�Ŭ�����μ� ����� �ú��� ��ȯ
			int year = c.get(Calendar.YEAR);// �⵵��
			int month = c.get(Calendar.MONTH) + 1;// ����.+1�� �� ������ 1���� 0
			int date = c.get(Calendar.DATE);

			String homedir = saveFolder + "/" + year + "-" + month + "-" + date;// ���ο� ���� ����
			File path1 = new File(homedir);
			if (!path1.exists()) {// ���ο� ������ ��������������
				path1.mkdir();// ���ο� ������ ����
			}

			Random r = new Random();
			int random = r.nextInt(100000000);// 1������� ������ ������ �߻�

			/**** Ȯ���� ���ϱ� ���� ****/
			int index = fileName.lastIndexOf(".");
			// lastIndexOf("����")�� StringŬ������ �޼���� �ش繮��
			// �� ���ڿ� �� �� �������� ��Ʒ� ������ ��ġ��ȣ�� ��ȯ�Ѵ�.
			String fileExtension = fileName.substring(index + 1);
			// ������ Ȯ���ڸ� ���Ѵ�.
			/**** Ȯ���� ���ϱ� �� ***/

			// ���ο� ���ϸ� ����
			String refileName = "MEMBER" + year + month + date + random + "." + fileExtension;// ���ο� ���ϸ��� ����

			// ����Ŭ ��� ����� ���� �̸�
			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;

			UpFile.transferTo(new File(saveFolder + fileDBName));

			// ����� ���ϸ����� ����
			m.setJoin_file(fileDBName);
		}

		this.memberService.insertMember(m);

		// �α��� �������� �̵�
		response.sendRedirect("member_login.nhn");
	}

	/* �α��� ���� */
	@RequestMapping(value = "/member_login_ok.nhn", method = RequestMethod.POST)
	public ModelAndView member_login_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// HttpSession Ŭ������ ���ǰ�ü�� �����ؼ� �α��� ���� ó���� �ϱ� ���ؼ��Դϴ�.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();// ��½�Ʈ�� ��ü ����
		HttpSession session = request.getSession();// ���� ��ü ����

		String id = request.getParameter("id").trim();
		String pwd = request.getParameter("pwd").trim();

		MemberBean m = this.memberService.userCheck(id);

		if (m == null) {// ��ϵ��� ���� ȸ���϶�
			out.println("<script>");
			out.println("alert('��ϵ��� ���� ȸ���Դϴ�!')");
			out.println("history.back()");
			out.println("</script>");
		} else {// ��ϵ� ȸ���϶�
			if (m.getJoin_pwd().equals(pwd)) {// ����� ������
				session.setAttribute("id", id);

				String join_name = m.getJoin_name();
				String join_file = m.getJoin_file();
				session.setAttribute("join_name", join_name);
				session.setAttribute("join_file", join_file);

				// jsp������ view.jsp�� �̵�
				ModelAndView loginM = new ModelAndView("view");
				return loginM;
			} else {// ����� �ٸ���
				out.println("<script>");
				out.println("alert('����� �ٸ��ϴ�!')");
				out.println("history.go(-1)");
				out.println("</script>");
			}
		}
		return null;
	}

	/* ȸ������ ���� �� */
	@RequestMapping(value = "/member_edit.nhn")
	public ModelAndView member_edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		// ���̵� Ű���� ���Ǿ��̵� ����
		String id = (String) session.getAttribute("id");

		if (id == null) {// ���� ���̵� ���� ���� ���
			out.println("<script>");
			out.println("alert('�ٽ� �α��� ���ּ���!')");
			out.println("location='member_login.nhn'");
			out.println("</script>");
		} else {
			MemberBean editm = this.memberService.userCheck(id);

			String join_tel = editm.getJoin_tel();
			// java.util ��Ű���� StringTokenizer Ŭ������ ù��° �������ڸ�
			// �ι�° -�� �������� ���ڿ��� �Ľ��� �ݴϴ�.
			// �� ��ȭ��ȣ ����
			StringTokenizer st01 = new StringTokenizer(join_tel, "-");
			String join_tel1 = st01.nextToken();// ù��°(���� ����ȭ��ȣ ����)
			String join_tel2 = st01.nextToken(); // �ι�°(��� �ڸ�)
			String join_tel3 = st01.nextToken();// ����°(�� �ڸ�)

			String join_phone = editm.getJoin_phone();
			// java.util ��Ű���� StringTokenizer Ŭ������ ù��° �������ڸ�
			// �ι�° -�� �������� ���ڿ��� �Ľ��� �ݴϴ�.
			// �޴��� ��ȣ ����
			StringTokenizer st02 = new StringTokenizer(join_phone, "-");
			String join_phone1 = st02.nextToken();// ù��° �ڸ�
			String join_phone2 = st02.nextToken(); // �ι�° �ڸ�
			String join_phone3 = st02.nextToken();// ����° �ڸ�

			String join_email = editm.getJoin_email();
			// java.util ��Ű���� StringTokenizer Ŭ������ ù��° �������ڸ�
			// �ι�° @�� �������� ���ڿ��� �Ľ��� �ݴϴ�.
			StringTokenizer st03 = new StringTokenizer(join_email, "@");
			String join_mailid = st03.nextToken();
			String join_maildomain = st03.nextToken();

			ModelAndView m = new ModelAndView("member/member_edit");
			m.addObject("editm", editm);
			m.addObject("join_tel1", join_tel1);
			m.addObject("join_tel2", join_tel2);
			m.addObject("join_tel3", join_tel3);
			m.addObject("join_phone1", join_phone1);
			m.addObject("join_phone2", join_phone2);
			m.addObject("join_phone3", join_phone3);
			m.addObject("join_mailid", join_mailid);
			m.addObject("join_maildomain", join_maildomain);

			return m;
		}
		return null;
	}

	/* ȸ������ ���� */
	@RequestMapping(value = "/member_edit_ok.nhn", method = RequestMethod.POST)
	public ModelAndView member_edit_ok(MemberBean m, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();// ���ǰ�ü�� ����

		String id = (String) session.getAttribute("id");
		// ���Ǿ��̵��� ���
		if (id == null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� ���ּ���!')");
			out.println("location='member_login.nhn'");
			out.println("</script>");
		} else {
			String join_tel = m.getJoin_tel1() + "-" + m.getJoin_tel2() + "-" + m.getJoin_tel3();
			String join_phone = m.getJoin_phone1() + "-" + m.getJoin_phone2() + "-" + m.getJoin_phone3();

			// ���� ���̵� : m.getJoin_mailid()
			// ���� ������ : m.getJoin_maildomain()
			String join_email = m.getJoin_mailid() + "@" + m.getJoin_maildomain();// ���� �ּ�
			m.setJoin_tel(join_tel);
			m.setJoin_phone(join_phone);
			m.setJoin_email(join_email);
			m.setJoin_id(id);

			// ���̵� �������� ���� ���� ȸ�������� �����ɴϴ�.
			MemberBean editm = this.memberService.userCheck(id);

			MultipartFile UpFile = m.getJoin_profile();// ÷���� ���� ����

			if (!UpFile.isEmpty()) {// ÷���� ���������� �ִٸ�
				File DelFile = new File(saveFolder + editm.getJoin_file());
				if (DelFile.exists()) {// �������������� �����ϸ�
					DelFile.delete();// ���� �������ϸ��� ����
				}

				String fileName = UpFile.getOriginalFilename();// �������ϸ� ����
				Calendar c = Calendar.getInstance();// �߻�Ŭ�����μ� ����� �ú��� ��ȯ
				int year = c.get(Calendar.YEAR);// �⵵��
				int month = c.get(Calendar.MONTH) + 1;// ����.+1�� �� ������ 1���� 0
				int date = c.get(Calendar.DATE);

				String homedir = saveFolder + "/" + year + "-" + month + "-" + date;// ���ο� ���� ����
				File path1 = new File(homedir);
				if (!path1.exists()) {// ���ο� ������ ��������������
					path1.mkdir();// ���ο� ������ ����
				}

				Random r = new Random();
				int random = r.nextInt(100000000);

				/**** Ȯ���� ���ϱ� ���� ****/
				int index = fileName.lastIndexOf(".");
				String fileExtension = fileName.substring(index + 1);
				/**** Ȯ���� ���ϱ� �� ***/

				// ���ο� ���ϸ� ����
				String refileName = "MEMBER" + year + month + date + random + "." + fileExtension;// ���ο� ���ϸ��� ����
				// ����Ŭ ��� ����� ���� �̸�
				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;

				UpFile.transferTo(new File(saveFolder + fileDBName));

				// ����� ���ϸ����� ����
				m.setJoin_file(fileDBName);
			}

			this.memberService.updateMember(m);// ���� �޼��� ȣ��

			// �̹��� ������ �ٷ� ���� �ȵ˴ϴ�.
			ModelAndView mv = new ModelAndView("view");
			mv.addObject("join_name", m.getJoin_name());
			mv.addObject("join_file", m.getJoin_file());
			mv.addObject("state", "edit");
			return mv;
		}
		return null;
	}

	/* ȸ������ ���� �� */
	@RequestMapping(value = "/member_del.nhn")
	public ModelAndView member_del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();// ��� ��Ʈ�� ��ü ����
		HttpSession session = request.getSession();// ���� ��ü ����

		String id = (String) session.getAttribute("id");
		if (id == null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� ���ּ���!')");
			out.println("location='member_login.nhn'");
			out.println("</script>");
		} else {
			MemberBean deleteM = this.memberService.userCheck(id);

			ModelAndView dm = new ModelAndView("member/member_del");
			dm.addObject("d_id", id);
			dm.addObject("d_name", deleteM.getJoin_name());
			return dm;
		}
		return null;
	}

	/* ȸ������ ���� �Ϸ� */
	@RequestMapping(value = "/member_del_ok.nhn", method = RequestMethod.POST)
	public void member_del_ok(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		if (id == null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� ���ּ���!')");
			out.println("location='member_login.nhn'");
			out.println("</script>");
		} else {
			String pass = request.getParameter("pwd").trim();
			String del_cont = request.getParameter("del_cont").trim();

			MemberBean member = this.memberService.userCheck(id);

			if (!member.getJoin_pwd().equals(pass)) {
				out.println("<script>");
				out.println("alert('����� �ٸ��ϴ�!')");
				out.println("history.back()");
				out.println("</script>");
			} else {// ����� ���� ���
				String fname = member.getJoin_file();

				if (fname != null) {// ���� ���������� �����ϸ�
					File delFile = new File(saveFolder + fname);
					delFile.delete();// ���� ���������� ����
				}
				MemberBean delm = new MemberBean();
				delm.setJoin_id(id);
				delm.setJoin_delcont(del_cont);

				this.memberService.deleteMember(delm);// ���� �޼��� ȣ��

				session.invalidate();// ���Ǹ���

				response.sendRedirect("member_login.nhn");
			}
		}
	}
}
