//@RequestParam(value="page", defaultValue="1", required=false) int page) ���
//BbsBean bbsbean (command ��ü ���)
package com.naver.myhome6.controller;

import java.io.File;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;//���� ���ε忡 ����մϴ�.
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome6.dao.BbsService;
import com.naver.myhome6.model.BbsBean;

@Controller
public class BbsAction {

	@Autowired
	private BbsService bbsService;

	private String saveFolder = "I:\\KH\\Spring\\spring6_mvc_bbs\\src\\main\\webapp\\resources\\upload";

	/* �ڷ�� �Է��� */
	@RequestMapping(value = "/bbs_write.nhn")
	public String bbs_write() {
		return "bbs/bbs_write"; // bbs ������ bbs_write.jsp �� �������� ����
	}

	/* �ڷ�� ���� */
	// ÷������ Ŭ���ؼ� �̹��� ������ �� ��� :
	// �ڵ� ���� ��ħ ����(window-> Preferencs -> workspce
	// -> Refresh using native hooks or polling üũ)
	// �ϰ� 5�� ���� ���� �� Ȯ���ϼ���
	/*
	 * CommonsMultipartResolver ���� : ���� ���ε� ����� ������ ���� Ŭ�����Դϴ�.
	 * 
	 * ������ �����̳ʴ� �Ű����� BbsBean��ü�� �����ϰ� BbsBean��ü�� setter �޼������ ȣ���Ͽ� ����� �Է°��� �����մϴ�.
	 * �Ű������� �̸��� setter�� property�� ��ġ�ϸ� �˴ϴ�.
	 */
	@RequestMapping(value = "/bbs_write_ok.nhn", method = RequestMethod.POST)
	public String bbs_write_ok(BbsBean bbsbean) throws Exception {
		MultipartFile uploadfile = bbsbean.getUploadfile();

		if (!uploadfile.isEmpty()) {
			// ���� ���ϸ� ���ؿ���
			String fileName = uploadfile.getOriginalFilename();

			// ���� ���ϸ� ����
			bbsbean.setBbs_original(fileName);

			// ������ ���� �̸� : ���� ��+��+��
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR); // ���� �⵵ ���մϴ�.
			int month = c.get(Calendar.MONTH) + 1; // ���� �� ���մϴ�.
			int date = c.get(Calendar.DATE); // ���� �� ���մϴ�.
			String homedir = saveFolder + "/" + year + "-" + month + "-" + date;
			System.out.println("homedir = " + homedir);
			File path1 = new File(homedir);

			if (!(path1.exists())) {
				path1.mkdir();// ���ο� ������ ����
			}

			// ������ ���մϴ�.
			Random r = new Random();
			int random = r.nextInt(100000000);

			/**** Ȯ���� ���ϱ� ���� ****/
			int index = fileName.lastIndexOf(".");
			// ���ڿ����� Ư�� ���ڿ��� ��ġ ��(index)�� ��ȯ�Ѵ�.
			// indexOf�� ó�� �߰ߵǴ� ���ڿ��� ���� index�� ��ȯ�ϴ� �ݸ�,
			// lastIndexOf�� ���������� �߰ߵǴ� ���ڿ��� index�� ��ȯ�մϴ�.
			// (���ϸ� ���� ������ ���� ��� �� �������� �߰ߵǴ� ���ڿ��� ��ġ�� �����մϴ�.)
			System.out.println("index = " + index);

			String fileExtension = fileName.substring(index + 1);
			System.out.println("fileExtension = " + fileExtension);
			/**** Ȯ���� ���ϱ� �� ***/

			// ���ο� ���ϸ��� ����
			String refileName = "bbs" + year + month + date + random + "." + fileExtension;
			System.out.println("refileName = " + refileName);

			// ����Ŭ ��� ����� ���ڵ� ��
			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
			System.out.println("fileDBName = " + fileDBName);

			// transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile.transferTo(new File(saveFolder + fileDBName));
			// �ٲ� ���ϸ����� ����
			bbsbean.setBbs_file(fileDBName);
		}

		this.bbsService.insertBbs(bbsbean); // ����޼��� ȣ��

		return "redirect:bbs_list.nhn";
	}

	/* �ڷ�� ��� */
	@RequestMapping(value = "/bbs_list.nhn")
	public ModelAndView bbs_list(@RequestParam(value = "page", defaultValue = "1", required = false) int page)
			throws Exception {
		// value="page" : ��û �Ķ���� page
		// defaultValue="1" ; ��û �Ķ���Ͱ� �������� ���� �� 1�� ���� ����
		// required=false : ��û �Ķ���Ͱ� �ʼ��� �ƴ� ���

		int limit = 10; // �� ȭ�鿡 ����� ���ڵ� ����

		int listcount = bbsService.getListCount(); // �� ����Ʈ ���� �޾ƿ�

		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

		// ���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// ���� �������� ������ ������ ������ ��(10, 20, 30 ��...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;

		if (endpage < page)
			page = endpage;

		List<BbsBean> bbslist = bbsService.getBbsList(page);

		ModelAndView model = new ModelAndView("bbs/bbs_list");
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("bbslist", bbslist);
		return model;
	}

	/* �ڷ�� ���뺸��, ������, �亯����, ������ */
	@RequestMapping(value = "/bbs_cont.nhn")
	public ModelAndView bbs_cont(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam("num") int num,
			@RequestParam("state") String state) throws Exception {

		if (state.equals("cont")) {
			this.bbsService.bbsHit(num);// ��ȸ�� ����
		}

		// ��ȣ�� �������� DB ������ �����ɴϴ�.
		BbsBean bbsbean = this.bbsService.getBbsCont(num);

		ModelAndView contM = new ModelAndView();

		if (state.equals("cont")) {// ���뺸��
			contM.setViewName("bbs/bbs_cont");

			// �۳��� �� ����Ű ģ�κ��� �����ٷ� ���� ó��
			String bbs_cont = bbsbean.getBbs_content().replace("\n", "<br/>");

			contM.addObject("bbs_cont", bbs_cont);
		} else if (state.equals("edit")) {
			contM.setViewName("bbs/bbs_edit");
		} else if (state.equals("del")) {// �����϶�
			contM.setViewName("bbs/bbs_delete");
		} else if (state.equals("reply")) {// �亯��
			contM.setViewName("bbs/bbs_reply");
		}
		contM.addObject("bbsbean", bbsbean);
		contM.addObject("page", page);
		return contM;
	}

	/* �ڷ�� ���� */
	@RequestMapping(value = "/bbs_edit_ok.nhn", method = RequestMethod.POST)
	public ModelAndView bbs_edit_ok(BbsBean bbsbean, @RequestParam int page, HttpServletResponse response)
			throws Exception {
		System.out.println("�Ѿ�� ��й�ȣ = " + bbsbean.getBbs_pass());
		System.out.println(page);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int bbs_num = bbsbean.getBbs_num();

		// ���� ���� ������ ������
		BbsBean bcont = this.bbsService.getBbsCont(bbs_num);

		if (!bcont.getBbs_pass().equals(bbsbean.getBbs_pass())) {// ����� �ٸ��ٸ�
			out.println("<script>");
			out.println("alert('����� �ٸ��ϴ�!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			MultipartFile uploadfile = bbsbean.getUploadfile();

			if (!uploadfile.isEmpty()) {
				File DelFile = new File(saveFolder + bcont.getBbs_file());
				if (DelFile.exists()) {
					DelFile.delete();// ���� ���������� ����
				}
				String fileName = uploadfile.getOriginalFilename();
				bbsbean.setBbs_original(fileName);
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR); // ���� �⵵ ���մϴ�.
				int month = c.get(Calendar.MONTH) + 1; // ���� �� ���մϴ�.
				int date = c.get(Calendar.DATE); // ���� �� ���մϴ�.
				String homedir = saveFolder + "/" + year + "-" + month + "-" + date;

				File path1 = new File(homedir);
				if (!(path1.exists())) {
					path1.mkdir();// ���ο� ������ ����
				}

				// ������ ���մϴ�.
				Random r = new Random();
				int random = r.nextInt(100000000);

				/**** Ȯ���� ���ϱ� ���� ****/
				int index = fileName.lastIndexOf(".");
				// ���ڿ����� Ư�� ���ڿ��� ��ġ ��(index)�� ��ȯ�Ѵ�.
				// indexOf�� ó�� �߰ߵǴ� ���ڿ��� ���� index�� ��ȯ�ϴ� �ݸ�,
				// lastIndexOf�� ���������� �߰ߵǴ� ���ڿ��� index�� ��ȯ�մϴ�.
				// (���ϸ� ���� ������ ���� ��� �� �������� �߰ߵǴ� ���ڿ��� ��ġ�� �����մϴ�.)
				System.out.println("index = " + index);

				String fileExtension = fileName.substring(index + 1);
				System.out.println("fileExtension = " + fileExtension);
				/**** Ȯ���� ���ϱ� �� ***/

				// ���ο� ���ϸ��� ����
				String refileName = "bbs" + year + month + date + random + "." + fileExtension;
				System.out.println("refileName = " + refileName);

				// ����Ŭ ��� ����� ���ڵ� ��
				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
				System.out.println("fileDBName = " + fileDBName);

				uploadfile.transferTo(new File(saveFolder + fileDBName));// transferTo(File path) : ���ε��� ������ �Ű������� ��ο�
																			// �����մϴ�.
				// �ٲ� ���ϸ����� ����
				bbsbean.setBbs_file(fileDBName);
			}

			this.bbsService.editBbs(bbsbean);// �����޼��� ȣ��

			// get������� 3���� �Ķ���� ���� �Ѿ�ϴ�.
			response.sendRedirect("bbs_cont.nhn?state=cont&page=" + page + "&num=" + bbs_num);
		}
		return null;
	}

	/* �ڷ�� ���� */
	@RequestMapping(value = "/bbs_delete_ok.nhn", method = RequestMethod.POST)
	public ModelAndView bbs_delete_ok(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("bbs_num") int bbs_num, @RequestParam("page") int page) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String pwd = request.getParameter("pwd").trim();

		// �۹�ȣ�� �ش��ϴ� ��� ������ �����ɴϴ�.
		BbsBean bbsbean = this.bbsService.getBbsCont(bbs_num);

		// ���� ���ϸ� �����ɴϴ�.
		String fname = bbsbean.getBbs_file();

		if (!bbsbean.getBbs_pass().equals(pwd)) {// ����� ���� �ʴٸ�
			out.println("<script>");
			out.println("alert('����� �ٸ��ϴ�!')");
			out.println("history.back()");
			out.println("</script>");
		} else {// ����� ���ٸ�
			if (fname != null) {// ���� ���������� �����Ѵٸ�
				File file = new File(saveFolder + fname);
				file.delete();// ���� ������ ���� ���� �������� �����մϴ�.
			}
			this.bbsService.deleteBbs(bbs_num);// ���� ���� ���ڵ� �����մϴ�.
			response.sendRedirect("bbs_list.nhn?page=" + page);
		}
		return null;
	}

	/* �ڷ�� �亯���� */
	@RequestMapping(value = "/bbs_reply_ok.nhn", method = RequestMethod.POST)
	public ModelAndView bbs_reply_ok(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute BbsBean bbsbean, @RequestParam("page") int page) throws Exception {

		this.bbsService.refEdit(bbsbean);

		bbsbean.setBbs_re_lev(bbsbean.getBbs_re_lev() + 1);
		bbsbean.setBbs_re_seq(bbsbean.getBbs_re_seq() + 1);

		this.bbsService.bbsReplyOk(bbsbean); // ���� �޼��� ȣ��

		response.sendRedirect("bbs_list.nhn?page=" + page); // �ش� �ʹ�ȣ ������� �̵�
		return null;
	}

	/* server.xml �ѱ� ó�� ���ڵ� ���� - get ��� ���� 
	<Connector connectionTimeout="20000" port="8088" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/> */
	/* �ڷ�� �˻� ��� */
	@RequestMapping(value="/bbs_find_ok.nhn", method=RequestMethod.GET)
	public ModelAndView bbs_find_ok(
			HttpServletRequest request, 
			HttpServletResponse response, 
			@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam("find_name") String find_name, 
			@RequestParam("find_field") String find_field) throws Exception {
		
		int limit = 10;
		
		Map m = new HashMap();
		m.put("page", page);
		m.put("find_field", find_field);
		m.put("find_name", "%" + find_name + "%");
		int listcount = this.bbsService.getListCount3(m);
		//�� ������ ��
		int maxpage = (listcount + limit - 1) / limit;
		
		//���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
		int startpage = ((page - 1) / 10) * 10 + 1;
		
		//���� �������� ������ ������ ������ �� (10, 20, 30 �� ...)
		int endpage = startpage + 10 - 1;
		
		if (endpage > maxpage) endpage = maxpage;
		
		List<BbsBean> bbslist = bbsService.getBbsList3(m);
		
		ModelAndView model = new ModelAndView("bbs/bbs_find");
		model.addObject("find_name", find_name);
		model.addObject("find_field", find_field);
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("bbslist", bbslist);
		
		return model;
		//return null;
	}
	
	@RequestMapping(value = "/download.file", method = { RequestMethod.GET })
	public void downloadFile(HttpServletResponse response, @RequestParam("path") String storedFileName,
			@RequestParam("original") String originalFileName, HttpServletRequest request) throws Exception {

		System.out.println("original = " + originalFileName);
		/*
		 * static byte[] readFileToByteArray(File file) Reads the contents of a file
		 * into a byte array.
		 */
		byte fileByte[] = FileUtils.readFileToByteArray(new File(saveFolder + storedFileName));

		// ������ ���� ã��
		String header = request.getHeader("User-Agent");
		String browser = "";
		System.out.println("header= " + header);
		if (header.contains("MSIE") || header.contains("Trident")) {// 11�����̻� : "Trident"
			browser = "MSIE";
			// }else if (header.lastIndexOf("OPR") > -1) {
		} else if (header.contains("OPR")) {
			browser = "Opera";
		} else if (header.contains("Chrome")) {
			browser = "Chrome";
		} else if (header.contains("Firefox")) {
			browser = "Firefox";
		} else if (header.contains("Safari")) {
			browser = "Safari";
		}
		System.out.println("browser = " + browser);

		// �ѱ��̸��� ���� �ٿ�ε� (�� �κ��� �ѱ� ���ϸ��� ������ ���� ������ �ݴϴ�.)
		// IE�� �ٸ� ������ ó��
		String sEncoding = "";
		if (browser.equals("MSIE")) {
			System.out.println("MSIE");
			// sEncoding = java.net.URLEncoder.encode(originalFileName, "UTF-8");
			sEncoding = URLEncoder.encode(originalFileName, "UTF-8").replaceAll("\\+", "%20");
			// ���ϸ� ������ �ִ� ��� "+"�� ����� ���� �������� ó���մϴ�.
			// sEncoding = sEncoding.replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {// Firefox�� ��� ���ϸ� ������ �ִ� ��� ������ �������� ���� ���ڸ� ���ϸ����� �ν��ؼ� ���ϸ� �յڿ� ("")��
												// �ٿ��� �ذ��߽��ϴ�.
			sEncoding = "\"" + new String(originalFileName.getBytes("UTF-8"), "8859_1") + "\"";
		} else {
			sEncoding = new String(originalFileName.getBytes("UTF-8"), "8859_1");
		}
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
