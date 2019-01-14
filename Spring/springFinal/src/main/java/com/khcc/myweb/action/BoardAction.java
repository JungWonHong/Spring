package com.khcc.myweb.action;

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
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.khcc.myweb.dao.BoardService;
import com.khcc.myweb.model.QaBean;
import com.khcc.myweb.model.QnaBean;
import com.khcc.myweb.model.FaqBean;
import com.khcc.myweb.model.NtBean;

@Controller
public class BoardAction {

	@Autowired
	private BoardService qaService, ntService, faqService, qnaService;

	/*
	 * private String saveFolder=
	 * "D:\\1.JAVA\\FinalProject\\springFinal\\src\\main\\webapp\\resources\\upload";
	 */

	/* REVIEW 占쎈쾻嚥∽옙 */
	@RequestMapping(value = "/qa_write.nhn")
	public String qa_write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");

		if (login_email == "") {
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다!(action)')");
			out.println("location='khcc_login.nhn'");
			/* out.println("location='qa_list.nhn'"); */
			out.println("</script>");
		}
		return "qa/qa_write";
	}

	@RequestMapping(value = "/qa_write_ok.nhn", method = RequestMethod.POST)
	public String qa_write_ok(QaBean qabean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");
		String login_email = (String) session.getAttribute("login_email");
		MultipartFile uploadfile = qabean.getUploadfile();
		
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			
			if (!uploadfile.isEmpty()) {
				String fileName = uploadfile.getOriginalFilename();

				qabean.setQa_original(fileName);

				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1;
				int date = c.get(Calendar.DATE);
				String homedir = saveFolder + "/" + year + "-" + month + "-" + date;
				System.out.println("homedir = " + homedir);
				File path1 = new File(homedir);

				if (!(path1.exists())) {
					path1.mkdir();
				}

				Random r = new Random();
				int random = r.nextInt(100000000);

				int index = fileName.lastIndexOf(".");
				System.out.println("index = " + index);

				String fileExtension = fileName.substring(index + 1);
				System.out.println("fileExtension = " + fileExtension);

				String refileName = "qa" + year + month + date + random + "." + fileExtension;
				System.out.println("refileName = " + refileName);

				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
				System.out.println("fileDBName = " + fileDBName);

				uploadfile.transferTo(new File(saveFolder + fileDBName));
				qabean.setQa_file(fileDBName);
				qabean.setQa_name(login_email);
			}

			this.qaService.insertQa(qabean);

			out.println("<script>");
			out.println("opener.document.location.reload();");
			out.println("self.close()");
			out.println("</script>");
			/* return "redirect:qa_list.nhn"; */
		}
		return null;

	}

	/* nt占쎈쾻嚥∽옙 */
	@RequestMapping(value = "/nt_write.nhn")
	public String nt_write() {
		return "nt/nt_write";
	}

	@RequestMapping(value = "/nt_write_ok.nhn", method = RequestMethod.POST)
	public String nt_write_ok(NtBean ntbean, 
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		MultipartFile uploadfile = ntbean.getUploadfile();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");

		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		if (login_email == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			if (!uploadfile.isEmpty()) {
				String fileName = uploadfile.getOriginalFilename();

				ntbean.setNt_original(fileName);

				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1;
				int date = c.get(Calendar.DATE);
				String homedir = saveFolder + "/" + year + "-" + month + "-" + date;
				System.out.println("homedir = " + homedir);
				File path1 = new File(homedir);

				if (!(path1.exists())) {
					path1.mkdir();
				}

				Random r = new Random();
				int random = r.nextInt(100000000);

				int index = fileName.lastIndexOf(".");
				System.out.println("index = " + index);

				String fileExtension = fileName.substring(index + 1);
				System.out.println("fileExtension = " + fileExtension);

				String refileName = "qa" + year + month + date + random + "." + fileExtension;
				System.out.println("refileName = " + refileName);

				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
				System.out.println("fileDBName = " + fileDBName);

				uploadfile.transferTo(new File(saveFolder + fileDBName));
				ntbean.setNt_file(fileDBName);
				ntbean.setNt_name(login_email);
				// ntbean.setNt_pass(login_email);
			}

			this.ntService.insertNt(ntbean);

			out.println("<script>");
			//out.println("opener.document.location.reload();");
		
			
			out.println("self.close()");
			out.println("opener.list()");
			out.println("</script>");
			/* return "redirect:qa_list.nhn"; */
		}
		return null;
	}

	/* faq占쎈쾻嚥∽옙 */
	@RequestMapping(value = "/faq_write.nhn")
	public String faq_write() {
		return "faq/faq_write";
	}

	@RequestMapping(value = "/faq_write_ok.nhn", method = RequestMethod.POST)
	public String faq_write_ok(FaqBean faqbean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MultipartFile uploadfile = faqbean.getUploadfile();

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");

		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		if (login_email == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			if (!uploadfile.isEmpty()) {
				String fileName = uploadfile.getOriginalFilename();

				faqbean.setFaq_original(fileName);

				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1;
				int date = c.get(Calendar.DATE);
				String homedir = saveFolder + "/" + year + "-" + month + "-" + date;
				System.out.println("homedir = " + homedir);
				File path1 = new File(homedir);

				if (!(path1.exists())) {
					path1.mkdir();
				}

				Random r = new Random();
				int random = r.nextInt(100000000);

				int index = fileName.lastIndexOf(".");
				System.out.println("index = " + index);

				String fileExtension = fileName.substring(index + 1);
				System.out.println("fileExtension = " + fileExtension);

				String refileName = "faq" + year + month + date + random + "." + fileExtension;
				System.out.println("refileName = " + refileName);

				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
				System.out.println("fileDBName = " + fileDBName);

				uploadfile.transferTo(new File(saveFolder + fileDBName));
				faqbean.setFaq_file(fileDBName);
				faqbean.setFaq_name(login_email);
			}

			this.faqService.insertFaq(faqbean);

			out.println("<script>");
			out.println("opener.document.location.reload();");
			out.println("self.close()");
			out.println("</script>");
			/* return "redirect:qa_list.nhn"; */
		}
		return null;
	}

	/* qna 占쎈쾻嚥∽옙 */
	@RequestMapping(value = "/qna_write.nhn")
	public String qna_write() {
		return "qna/qna_write";
	}

	@RequestMapping(value = "/qna_write_ok.nhn", method = RequestMethod.POST)
	public String qna_write_ok(QnaBean qnabean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MultipartFile uploadfile = qnabean.getUploadfile();

		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");
		qnabean.setQna_name(login_email);
		
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			if (!uploadfile.isEmpty()) {
				String fileName = uploadfile.getOriginalFilename();

				qnabean.setQna_original(fileName);

				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1;
				int date = c.get(Calendar.DATE);
				String homedir = saveFolder + "/" + year + "-" + month + "-" + date;
				System.out.println("homedir = " + homedir);
				File path1 = new File(homedir);

				if (!(path1.exists())) {
					path1.mkdir();
				}

				Random r = new Random();
				int random = r.nextInt(100000000);

				int index = fileName.lastIndexOf(".");
				System.out.println("index = " + index);

				String fileExtension = fileName.substring(index + 1);
				System.out.println("fileExtension = " + fileExtension);

				String refileName = "qna" + year + month + date + random + "." + fileExtension;
				System.out.println("refileName = " + refileName);

				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
				System.out.println("fileDBName = " + fileDBName);

				uploadfile.transferTo(new File(saveFolder + fileDBName));
				qnabean.setQna_file(fileDBName);
				qnabean.setQna_name(login_email);
			}

			this.qnaService.insertQna(qnabean);

			out.println("<script>");
			out.println("self.close()");
			out.println("opener.dellist();");
			
			out.println("</script>");
		}
		return null;
	}

	/* REVIEW �뵳�딅뮞占쎈뱜 */
	@RequestMapping(value = "/qa_list.nhn")
	public ModelAndView qa_list(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int limit = 10;

		int listcount = qaService.getListCount();

		int maxpage = (listcount + limit - 1) / limit;

		int startpage = ((page - 1) / 10) * 10 + 1;

		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;

		if (endpage < page)
			page = endpage;

		List<QaBean> qalist = qaService.getQaList(page);
		QaBean qamax1 = qaService.qaReadFirst();
		QaBean qamax2 = qaService.qaReadSecond();
		QaBean qamax3 = qaService.qaReadThird();
		QaBean qaimage1 = qaService.qaImageFirst();
		QaBean qaimage2 = qaService.qaImageSecond();
		QaBean qaimage3 = qaService.qaImageThird();

		ModelAndView model = new ModelAndView("qa/qa_list");
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("qalist", qalist);
		model.addObject("qamax1", qamax1);
		model.addObject("qamax2", qamax2);
		model.addObject("qamax3", qamax3);
		model.addObject("qaimage1", qaimage1);
		model.addObject("qaimage2", qaimage2);
		model.addObject("qaimage3", qaimage3);
		return model;
	}

	@RequestMapping(value = "/nt_list.nhn")
	public ModelAndView nt_list(@RequestParam(value = "ntpage", defaultValue = "1", required = false) int ntpage)
			throws Exception {

		int ntlimit = 10;

		int ntlistcount = ntService.getntListCount();

		int ntmaxpage = (ntlistcount + ntlimit - 1) / ntlimit;

		int ntstartpage = ((ntpage - 1) / 10) * 10 + 1;

		int ntendpage = ntstartpage + 10 - 1;

		if (ntendpage > ntmaxpage)
			ntendpage = ntmaxpage;

		if (ntendpage < ntpage)
			ntpage = ntendpage;

		List<NtBean> ntlist = ntService.getNtList(ntpage);

		ModelAndView ntmodel = new ModelAndView("nt/nt_list");
		ntmodel.addObject("ntpage", ntpage);
		ntmodel.addObject("ntmaxpage", ntmaxpage);
		ntmodel.addObject("ntstartpage", ntstartpage);
		ntmodel.addObject("ntendpage", ntendpage);
		ntmodel.addObject("ntlistcount", ntlistcount);
		ntmodel.addObject("ntlist", ntlist);
		return ntmodel;
	}

	@RequestMapping(value = "/faq_list.nhn")
	public ModelAndView faq_list(@RequestParam(value = "faqpage", defaultValue = "1", required = false) int faqpage)
			throws Exception {

		int faqlimit = 10;

		int faqlistcount = faqService.getfaqListCount();

		int faqmaxpage = (faqlistcount + faqlimit - 1) / faqlimit;

		int faqstartpage = ((faqpage - 1) / 10) * 10 + 1;

		int faqendpage = faqstartpage + 10 - 1;

		if (faqendpage > faqmaxpage)
			faqendpage = faqmaxpage;

		if (faqendpage < faqpage)
			faqpage = faqendpage;

		List<FaqBean> faqlist = faqService.getFaqList(faqpage);

		ModelAndView faqmodel = new ModelAndView("faq/faq_list");
		faqmodel.addObject("faqpage", faqpage);
		faqmodel.addObject("faqmaxpage", faqmaxpage);
		faqmodel.addObject("faqstartpage", faqstartpage);
		faqmodel.addObject("faqendpage", faqendpage);
		faqmodel.addObject("faqlistcount", faqlistcount);
		faqmodel.addObject("faqlist", faqlist);
		return faqmodel;
	}

	@RequestMapping(value = "/qna_list.nhn")
	public ModelAndView qna_list(HttpServletRequest request,
			@RequestParam(value = "qnapage", defaultValue = "1", required = false) int qnapage) throws Exception {

		int qnalimit = 10;

		int qnalistcount = qnaService.getqnaListCount();

		int qnamaxpage = (qnalistcount + qnalimit - 1) / qnalimit;

		int qnastartpage = ((qnapage - 1) / 10) * 10 + 1;

		int qnaendpage = qnastartpage + 10 - 1;

		if (qnaendpage > qnamaxpage)
			qnaendpage = qnamaxpage;

		if (qnaendpage < qnapage)
			qnapage = qnaendpage;

		System.out.println(qnapage);
		List<QnaBean> qnalist = qnaService.getQnaList(qnapage);
         System.out.println(qnalist.size());
		ModelAndView qnamodel = new ModelAndView("qna/qna_list");
		qnamodel.addObject("qnapage", qnapage);
		qnamodel.addObject("qnamaxpage", qnamaxpage);
		qnamodel.addObject("qnastartpage", qnastartpage);
		qnamodel.addObject("qnaendpage", qnaendpage);
		qnamodel.addObject("qnalistcount", qnalistcount);
		qnamodel.addObject("qnalist", qnalist);
		return qnamodel;
	}

	@RequestMapping(value = "/qa_cont.nhn")
	public ModelAndView qa_cont(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam("num") int num,
			@RequestParam("state") String state) throws Exception {

		if (state.equals("cont")) {
			this.qaService.qaHit(num);
		}

		QaBean qabean = this.qaService.getQaCont(num);

		ModelAndView contM = new ModelAndView();

		if (state.equals("cont")) {
			contM.setViewName("qa/qa_cont");

			String qa_cont = qabean.getQa_content().replace("\n", "<br/>");

			contM.addObject("qa_cont", qa_cont);
		} else if (state.equals("edit")) {
			contM.setViewName("qa/qa_edit");
		} else if (state.equals("del")) {
			contM.setViewName("qa/qa_delete");
		} else if (state.equals("reply")) {
			contM.setViewName("qa/qa_reply");
		}
		contM.addObject("qabean", qabean);
		contM.addObject("page", page);
		return contM;
	}

	@RequestMapping(value = "/qa_cont_ajax.nhn")
	public ModelAndView qa_cont_ajax(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam("num") int num,
			@RequestParam("state") String state) throws Exception {
      
	
			this.qaService.qaHit(num);
		

		QaBean qabean = this.qaService.getQaCont(num);

		ModelAndView contM = new ModelAndView();

	
			contM.setViewName("qa/qa_cont");

			String qa_cont = qabean.getQa_content().replace("\n", "<br/>");

			contM.addObject("qa_cont", qa_cont);
	
		contM.addObject("qabean", qabean);
		contM.addObject("page", page);
		return contM;
	}

	@RequestMapping(value = "/nt_cont.nhn")
	public ModelAndView nt_cont(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, 
			@RequestParam("num") int num,
			@RequestParam("state") String state) throws Exception {

		if (state.equals("cont")) {
			this.ntService.ntHit(num);
		}

		NtBean ntbean = this.ntService.getNtCont(num);

		ModelAndView contM = new ModelAndView();

		if (state.equals("cont")) {
			contM.setViewName("nt/nt_cont");

			String nt_cont = ntbean.getNt_content().replace("\n", "<br/>");

			contM.addObject("nt_cont", nt_cont);
		} else if (state.equals("edit")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("self.close();");
			out.println("alert('�닔�젙 �셿猷�!');");
			out.println("opener.document.location.reload();");
			out.println("</script>");
			out.close();
			return null;
		} else if (state.equals("del")) {
			response.sendRedirect("nt_delete_ok.nhn?nt_num=" + num + "&page=" + page);
			return null;
		} else if (state.equals("reply")) {
			contM.setViewName("nt/nt_reply");
		}
		contM.addObject("ntbean", ntbean);
		contM.addObject("page", page);
		return contM;
	}

	@RequestMapping(value = "/nt_cont_ajax.nhn")
	public ModelAndView nt_cont_ajax(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam("num") int num)
			throws Exception {

		this.ntService.ntHit(num);

		NtBean ntbean = this.ntService.getNtCont(num);

		ModelAndView contM = new ModelAndView();

		contM.setViewName("nt/nt_cont");

		String nt_cont = ntbean.getNt_content().replace("\n", "<br/>");

		contM.addObject("nt_cont", nt_cont);

		contM.addObject("ntbean", ntbean);
		contM.addObject("page", page);
		return contM;
	}

	/* faq占쎄땀占쎌뒠癰귣떯由� */
	@RequestMapping(value = "/faq_cont.nhn")
	public ModelAndView faq_cont(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam("num") int num,
			@RequestParam("state") String state) throws Exception {

		if (state.equals("cont")) {
			this.faqService.faqHit(num);
		}

		FaqBean faqbean = this.faqService.getFaqCont(num);

		ModelAndView contM = new ModelAndView();

		if (state.equals("cont")) {
			contM.setViewName("faq/faq_cont");

			String faq_cont = faqbean.getFaq_content().replace("\n", "<br/>");

			contM.addObject("faq_cont", faq_cont);
		} else if (state.equals("edit")) {
			contM.setViewName("faq/faq_edit");
		} else if (state.equals("del")) {
			contM.setViewName("faq/faq_delete");
		} else if (state.equals("reply")) {
			contM.setViewName("faq/faq_reply");
		}
		contM.addObject("faqbean", faqbean);
		contM.addObject("page", page);
		return contM;
	}

	/* qna占쎄땀占쎌뒠癰귣떯由� */
	@RequestMapping(value = "/qna_cont.nhn")
	public ModelAndView qna_cont(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam("num") int num,
			@RequestParam("state") String state) throws Exception {

		if (state.equals("cont")) {
			this.qnaService.qnaHit(num);
		}

		QnaBean qnabean = this.qnaService.getQnaCont(num);

		ModelAndView contM = new ModelAndView();

		if (state.equals("cont")) {
			contM.setViewName("qna/qna_cont");

			String qna_cont = qnabean.getQna_content().replace("\n", "<br/>");

			contM.addObject("qna_cont", qna_cont);
		} else if (state.equals("edit")) {
			contM.setViewName("qna/qna_edit");
		} else if (state.equals("del")) {
			contM.setViewName("qna/qna_delete");
		} else if (state.equals("reply")) {
			contM.setViewName("qna/qna_reply");
		}
		contM.addObject("qnabean", qnabean);
		contM.addObject("page", page);
		return contM;
	}
	
	/*qna_cont ajax*/
	@RequestMapping(value = "/qna_cont_ajax.nhn")
	public ModelAndView qna_cont_ajax(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, 
			@RequestParam("num") int num
			/*@RequestParam("state") String state*/) throws Exception {

			this.qnaService.qnaHit(num);
	

		QnaBean qnabean = this.qnaService.getQnaCont(num);

		ModelAndView contM = new ModelAndView();

		
			contM.setViewName("qna/qna_cont");

			String qna_cont = qnabean.getQna_content().replace("\n", "<br/>");

			contM.addObject("qna_cont", qna_cont);
	
		contM.addObject("qnabean", qnabean);
		contM.addObject("page", page);
		return contM;
	}

	/*qna_form*/
	@RequestMapping(value = "/qa_edit.nhn")
	public ModelAndView qa_edit(
			@RequestParam("qa_num") int qa_num,
			@RequestParam("page") int page,
			@RequestParam("state") String state) throws Exception {

		ModelAndView model = new ModelAndView("qa/qa_edit");
		QaBean qabean = this.qaService.getQaCont(qa_num);
		model.addObject("qabean", qabean);
		model.addObject("page", page);
		model.addObject("state", state);
		return model;
	}
	
	/* REVIEW占쎈땾占쎌젟 */
	@RequestMapping(value = "/qa_edit_ok.nhn", method = RequestMethod.POST)
	public ModelAndView qa_edit_ok(
			QaBean qabean,
			@RequestParam int page,
			@RequestParam("qa_num") int qa_num,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(page);

		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		 qa_num = qabean.getQa_num();

		QaBean bcont = this.qaService.getQaCont(qa_num);

		if (login_email == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!(action_rvlist)')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
		} else {
			if (!bcont.getQa_pass().equals(qabean.getQa_pass())) {
				out.println("<script>");
				out.println("alert('비밀 번호가 다릅니다!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				MultipartFile uploadfile = qabean.getUploadfile();

				String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

				if (!uploadfile.isEmpty()) {
					File DelFile = new File(saveFolder + bcont.getQa_file());
					if (DelFile.exists()) {
						DelFile.delete();
					}
					String fileName = uploadfile.getOriginalFilename();
					qabean.setQa_original(fileName);
					Calendar c = Calendar.getInstance();
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH) + 1;
					int date = c.get(Calendar.DATE);
					String homedir = saveFolder + "/" + year + "-" + month + "-" + date;

					File path1 = new File(homedir);
					if (!(path1.exists())) {
						path1.mkdir();
					}

					Random r = new Random();
					int random = r.nextInt(100000000);

					int index = fileName.lastIndexOf(".");
					System.out.println("index = " + index);

					String fileExtension = fileName.substring(index + 1);
					System.out.println("fileExtension = " + fileExtension);

					String refileName = "qa" + year + month + date + random + "." + fileExtension;
					System.out.println("refileName = " + refileName);

					String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
					System.out.println("fileDBName = " + fileDBName);

					uploadfile.transferTo(new File(saveFolder + fileDBName));
					qabean.setQa_file(fileDBName);
					qabean.setQa_name(login_email);
				}

				this.qaService.editQa(qabean);

				//response.sendRedirect("qa_cont.nhn?state=cont&page=" + page + "&num=" + qa_num);
			}
		}
		out.println("<script>");
		//out.println("opener.document.location.reload();");
	
		
		out.println("self.close()");
		out.println("opener.qaeditcont()");
		out.println("</script>");
		return null;
	}

	@RequestMapping(value = "/nt_edit.nhn")
	public ModelAndView nt_edit(@RequestParam("nt_num") int nt_num,
			@RequestParam("page") int page,
			@RequestParam("state") String state) throws Exception {

		ModelAndView model = new ModelAndView("nt/nt_edit");
		NtBean ntbean = this.ntService.getNtCont(nt_num);
		model.addObject("ntbean", ntbean);
		model.addObject("page", page);
		model.addObject("state", state);
		return model;
	}

	/* nt占쎈땾占쎌젟 */
	@RequestMapping(value = "/nt_edit_ok.nhn", method = RequestMethod.POST)
	public ModelAndView nt_edit_ok(NtBean ntbean, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("page") int page, @RequestParam("nt_num") int nt_num, @RequestParam("state") String state)
			throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		nt_num = ntbean.getNt_num();

		NtBean bcont = this.ntService.getNtCont(nt_num);

		MultipartFile uploadfile = ntbean.getUploadfile();

		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		if (!uploadfile.isEmpty()) {
			File DelFile = new File(saveFolder + bcont.getNt_file());
			if (DelFile.exists()) {
				DelFile.delete();
			}
			String fileName = uploadfile.getOriginalFilename();
			ntbean.setNt_original(fileName);
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int date = c.get(Calendar.DATE);
			String homedir = saveFolder + "/" + year + "-" + month + "-" + date;

			File path1 = new File(homedir);
			if (!(path1.exists())) {
				path1.mkdir();
			}

			Random r = new Random();
			int random = r.nextInt(100000000);

			int index = fileName.lastIndexOf(".");
			System.out.println("index = " + index);

			String fileExtension = fileName.substring(index + 1);
			System.out.println("fileExtension = " + fileExtension);

			String refileName = "nt" + year + month + date + random + "." + fileExtension;
			System.out.println("refileName = " + refileName);

			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
			System.out.println("fileDBName = " + fileDBName);

			uploadfile.transferTo(new File(saveFolder + fileDBName));
			ntbean.setNt_file(fileDBName);
		}

		this.ntService.editNt(ntbean);

		//response.sendRedirect("nt_cont.nhn?state=" + state + "&page=" + page + "&num=" + nt_num);
		out.println("<script>");
		//out.println("opener.document.location.reload();");
	
		
		out.println("self.close()");
		out.println("opener.editcont()");
		out.println("</script>");
		return null;
	}

	/* faq占쎈땾占쎌젟 */
	@RequestMapping(value = "/faq_edit_ok.nhn", method = RequestMethod.POST)
	public ModelAndView faq_edit_ok(FaqBean faqbean, @RequestParam int page, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(page);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int faq_num = faqbean.getFaq_num();

		FaqBean bcont = this.faqService.getFaqCont(faq_num);

		if (!bcont.getFaq_pass().equals(faqbean.getFaq_pass())) {
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			MultipartFile uploadfile = faqbean.getUploadfile();

			String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

			if (!uploadfile.isEmpty()) {
				File DelFile = new File(saveFolder + bcont.getFaq_file());
				if (DelFile.exists()) {
					DelFile.delete();
				}
				String fileName = uploadfile.getOriginalFilename();
				faqbean.setFaq_original(fileName);
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1;
				int date = c.get(Calendar.DATE);
				String homedir = saveFolder + "/" + year + "-" + month + "-" + date;

				File path1 = new File(homedir);
				if (!(path1.exists())) {
					path1.mkdir();
				}

				Random r = new Random();
				int random = r.nextInt(100000000);

				int index = fileName.lastIndexOf(".");
				System.out.println("index = " + index);

				String fileExtension = fileName.substring(index + 1);
				System.out.println("fileExtension = " + fileExtension);

				String refileName = "nt" + year + month + date + random + "." + fileExtension;
				System.out.println("refileName = " + refileName);

				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
				System.out.println("fileDBName = " + fileDBName);

				uploadfile.transferTo(new File(saveFolder + fileDBName));
				faqbean.setFaq_file(fileDBName);
			}

			this.faqService.editFaq(faqbean);

			response.sendRedirect("faq_cont.nhn?state=cont&page=" + page + "&num=" + faq_num);
		}
		return null;
	}

	/*qna_form*/
	@RequestMapping(value = "/qna_edit.nhn")
	public ModelAndView qna_edit(
			@RequestParam("qna_num") int qna_num,
			@RequestParam("page") int page,
			@RequestParam("state") String state) throws Exception {

		ModelAndView model = new ModelAndView("qna/qna_edit");
		QnaBean qnabean = this.qnaService.getQnaCont(qna_num);
		model.addObject("qnabean", qnabean);
		model.addObject("page", page);
		model.addObject("state", state);
		return model;
	}
	
	/* qna占쎈땾占쎌젟 */
	@RequestMapping(value = "/qna_edit_ok.nhn", method = RequestMethod.POST)
	public ModelAndView qna_edit_ok(QnaBean qnabean,
			@RequestParam("qna_num") int qna_num,
			@RequestParam int page,
			HttpServletRequest request,
			HttpServletResponse response
			
			) throws Exception {
		System.out.println(page);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		 qna_num = qnabean.getQna_num();

		QnaBean bcont = this.qnaService.getQnaCont(qna_num);

		if (!bcont.getQna_pass().equals(qnabean.getQna_pass())) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			MultipartFile uploadfile = qnabean.getUploadfile();

			String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

			if (!uploadfile.isEmpty()) {
				File DelFile = new File(saveFolder + bcont.getQna_file());
				if (DelFile.exists()) {
					DelFile.delete();
				}
				String fileName = uploadfile.getOriginalFilename();
				qnabean.setQna_original(fileName);
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1;
				int date = c.get(Calendar.DATE);
				String homedir = saveFolder + "/" + year + "-" + month + "-" + date;

				File path1 = new File(homedir);
				if (!(path1.exists())) {
					path1.mkdir();
				}

				Random r = new Random();
				int random = r.nextInt(100000000);

				int index = fileName.lastIndexOf(".");
				System.out.println("index = " + index);

				String fileExtension = fileName.substring(index + 1);
				System.out.println("fileExtension = " + fileExtension);

				String refileName = "qna" + year + month + date + random + "." + fileExtension;
				System.out.println("refileName = " + refileName);

				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
				System.out.println("fileDBName = " + fileDBName);

				uploadfile.transferTo(new File(saveFolder + fileDBName));
				qnabean.setQna_file(fileDBName);
			}

			this.qnaService.editQna(qnabean);

			//response.sendRedirect("qna_cont.nhn?state=cont&page=" + page + "&num=" + qna_num);
		}
		out.println("<script>");
		//out.println("opener.document.location.reload();");
	
		
		out.println("self.close()");
		out.println("opener.qnaeditcont()");
		out.println("</script>");
		return null;
	}

	/*qnadelete_form*/
	@RequestMapping(value = "/qa_delete.nhn")
	public ModelAndView qa_delete(
			@RequestParam("qa_num") int qa_num,
			@RequestParam("page") int page,
			@RequestParam("state") String state) throws Exception {

		ModelAndView model = new ModelAndView("qa/qa_delete");
		QaBean qabean = this.qaService.getQaCont(qa_num);
		model.addObject("qabean", qabean);
		model.addObject("page", page);
		model.addObject("state", state);
		return model;
	}
	
	/* REVIEW占쎄텣占쎌젫 */
	@RequestMapping(value = "/qa_delete_ok.nhn", method = RequestMethod.POST)
	public ModelAndView qa_delete_ok(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("qa_num") int qa_num,
			@RequestParam("page") int page) throws Exception {

		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String pwd = request.getParameter("pwd").trim();

		QaBean qabean = this.qaService.getQaCont(qa_num);

		String fname = qabean.getQa_file();

		if (!qabean.getQa_pass().equals(pwd)) {
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			if (fname != null) {
				File file = new File(saveFolder + fname);
				file.delete();
			}
			this.qaService.deleteQa(qa_num);
			//response.sendRedirect("qa_list.nhn?page=" + page);
		}
		out.println("<script>");
		out.println("self.close()");
		out.println("opener.qadellist()");
		out.println("</script>");
		return null;
	}

	/* nt占쎄텣占쎌젫 */
	@RequestMapping(value = "/nt_delete_ok.nhn", method = RequestMethod.GET)
	public ModelAndView nt_delete_ok(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("num") int nt_num, @RequestParam("page") int page) throws Exception {

		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		NtBean ntbean = this.ntService.getNtCont(nt_num);

		String fname = ntbean.getNt_file();

		if (fname != null) {
			File file = new File(saveFolder + fname);
			file.delete();
		}
		this.ntService.deleteNt(nt_num);
		response.sendRedirect("nt_list.nhn?page=" + page);		
		
		return null;
	}

	/* faq占쎄텣占쎌젫 */
	@RequestMapping(value = "/faq_delete_ok.nhn", method = RequestMethod.POST)
	public ModelAndView faq_delete_ok(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("faq_num") int faq_num, @RequestParam("page") int page) throws Exception {

		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String pwd = request.getParameter("pwd").trim();

		FaqBean faqbean = this.faqService.getFaqCont(faq_num);

		String fname = faqbean.getFaq_file();

		if (!faqbean.getFaq_pass().equals(pwd)) {
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			if (fname != null) {
				File file = new File(saveFolder + fname);
				file.delete();
			}
			this.faqService.deleteFaq(faq_num);
			response.sendRedirect("faq_list.nhn?page=" + page);
		}
		return null;
	}

	

	/*qnadelete_form*/
	@RequestMapping(value = "/qna_delete.nhn")
	public ModelAndView qna_delete(
			@RequestParam("qna_num") int qna_num,
			@RequestParam("page") int page,
			@RequestParam("state") String state) throws Exception {

		ModelAndView model = new ModelAndView("qna/qna_delete");
		QnaBean qnabean = this.qnaService.getQnaCont(qna_num);
		model.addObject("qnabean", qnabean);
		model.addObject("page", page);
		model.addObject("state", state);
		return model;
	}
		
	/* qna占쎄텣占쎌젫 */
	@RequestMapping(value = "/qna_delete_ok.nhn", method = RequestMethod.POST)
	public ModelAndView qna_delete_ok(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("qna_num") int qna_num, @RequestParam("page") int page) throws Exception {

		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String pwd = request.getParameter("pwd").trim();

		QnaBean qnabean = this.qnaService.getQnaCont(qna_num);

		String fname = qnabean.getQna_file();

		if (!qnabean.getQna_pass().equals(pwd)) {
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			if (fname != null) {
				File file = new File(saveFolder + fname);
				file.delete();
			}
			this.qnaService.deleteQna(qna_num);
			//response.sendRedirect("qna_list.nhn?page=" + page);
		}
		out.println("<script>");
		out.println("self.close()");
		out.println("opener.dellist()");
		out.println("</script>");
		return null;
	}

	/*qna_form*/
	@RequestMapping(value = "/qa_reply.nhn")
	public ModelAndView qa_reply(
			@RequestParam("num") int num,
			@RequestParam("page") int page,
			@RequestParam("state") String state) throws Exception {

		ModelAndView model = new ModelAndView("qa/qa_reply");
		QaBean qabean = this.qaService.getQaCont(num);
		model.addObject("qabean", qabean);
		model.addObject("page", page);
		model.addObject("state", state);
		return model;
	}
	
	
	/* qa占쎈뼗癰귨옙 */
	@RequestMapping(value = "/qa_reply_ok.nhn", method = RequestMethod.POST)
	public ModelAndView qa_reply_ok(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute QaBean qabean, 
			@RequestParam("page") int page) throws Exception {
		HttpSession session = request.getSession();

		String login_email = (String) session.getAttribute("login_email");
		PrintWriter out = response.getWriter();
		this.qaService.refEdit(qabean);

		qabean.setQa_re_lev(qabean.getQa_re_lev() + 1);
		qabean.setQa_re_seq(qabean.getQa_re_seq() + 1);
		qabean.setQa_name(login_email);

		this.qaService.qaReplyOk(qabean);

		//response.sendRedirect("qa_list.nhn?page=" + page);
		out.println("<script>");
		out.println("self.close()");
		out.println("opener.qadellist()");
		out.println("</script>");
		return null;
	}

	@RequestMapping(value = "/download.file", method = { RequestMethod.GET })
	public void downloadFile(HttpServletResponse response, @RequestParam("path") String storedFileName,
			@RequestParam("original") String originalFileName, HttpServletRequest request) throws Exception {

		System.out.println("original = " + originalFileName);
		/*
		 * static byte[] readFileToByteArray(File file) Reads the contents of a file
		 * into a byte array.
		 */
		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		byte fileByte[] = FileUtils.readFileToByteArray(new File(saveFolder + storedFileName));

		String header = request.getHeader("User-Agent");
		String browser = "";
		System.out.println("header= " + header);
		if (header.contains("MSIE") || header.contains("Trident")) {
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

		String sEncoding = "";
		if (browser.equals("MSIE")) {
			System.out.println("MSIE");
			// sEncoding = java.net.URLEncoder.encode(originalFileName, "UTF-8");
			sEncoding = URLEncoder.encode(originalFileName, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
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
	/*qna_form*/
	@RequestMapping(value = "/qna_reply.nhn")
	public ModelAndView qna_reply(
			@RequestParam("num") int num,
			@RequestParam("page") int page,
			@RequestParam("state") String state) throws Exception {

		ModelAndView model = new ModelAndView("qna/qna_reply");
		QnaBean qnabean = this.qnaService.getQnaCont(num);
		model.addObject("qnabean", qnabean);
		model.addObject("page", page);
		model.addObject("state", state);
		return model;
	}
	

	/* qna占쎈뼗癰귨옙 */
	@RequestMapping(value = "/qna_reply_ok.nhn", method = RequestMethod.POST)
	public ModelAndView qna_reply_ok(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute QnaBean qnabean, @RequestParam("page") int page) throws Exception {

		this.qnaService.refqnaEdit(qnabean);
	

		PrintWriter out = response.getWriter();
		qnabean.setQna_re_lev(qnabean.getQna_re_lev() + 1);
		qnabean.setQna_re_seq(qnabean.getQna_re_seq() + 1);
		
		HttpSession session = request.getSession();
		this.qnaService.qnaReplyOk(qnabean);
		String login_email = (String) session.getAttribute("login_email");
		qnabean.setQna_name(login_email);
		
		//response.sendRedirect("qna_list.nhn?page=" + page);
		out.println("<script>");
		out.println("self.close()");
		out.println("opener.dellist()");
		out.println("</script>");
		return null;
	}

	/* REVIEW野껓옙占쎄퉳 */
	@RequestMapping(value = "/qa_find_ok.nhn", method = RequestMethod.GET)
	public ModelAndView qa_find_ok(HttpServletRequest request,
			/* HttpServletResponse response, */
			@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam("find_name") String find_name,
			@RequestParam("find_field") String find_field) throws Exception {
		int limit = 10;

		Map m = new HashMap();
		m.put("page", page);
		m.put("find_field", find_field);
		m.put("find_name", "%" + find_name + "%");
		int listcount = this.qaService.getListCount3(m);
		int maxpage = (listcount + limit - 1) / limit;

		int startpage = ((page - 1) / 10) * 10 + 1;

		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;

		List<QaBean> qalist = qaService.getQaList3(m);

		ModelAndView model = new ModelAndView("qa/qa_find");
		model.addObject("find_name", find_name);
		model.addObject("find_field", find_field);
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("qalist", qalist);

		/*
		 * PrintWriter out = response.getWriter(); out.println("<script>");
		 * out.println("opener.document.location.reload();");
		 * out.println("self.close()"); out.println("</script>");
		 */
		/* return "redirect:qa_list.nhn"; */
		return model;
	}

	/* nt野껓옙占쎄퉳 */
	@RequestMapping(value = "/nt_find_ok.nhn", method = RequestMethod.GET)
	public ModelAndView nt_find_ok(HttpServletRequest request,
			/* HttpServletResponse response, */
			@RequestParam(value = "ntpage", defaultValue = "1") int ntpage,
			@RequestParam("ntfind_name") String ntfind_name, @RequestParam("ntfind_field") String ntfind_field)
			throws Exception {
		int ntlimit = 10;

		Map ntm = new HashMap();
		ntm.put("ntpage", ntpage);
		ntm.put("ntfind_field", ntfind_field);
		ntm.put("ntfind_name", "%" + ntfind_name + "%");
		int ntlistcount = this.ntService.getntListCount3(ntm);
		int ntmaxpage = (ntlistcount + ntlimit - 1) / ntlimit;

		int ntstartpage = ((ntpage - 1) / 10) * 10 + 1;

		int ntendpage = ntstartpage + 10 - 1;

		if (ntendpage > ntmaxpage)
			ntendpage = ntmaxpage;

		List<NtBean> ntlist = ntService.getNtList3(ntm);

		ModelAndView ntmodel = new ModelAndView("nt/nt_find");
		ntmodel.addObject("ntfind_name", ntfind_name);
		ntmodel.addObject("ntfind_field", ntfind_field);
		ntmodel.addObject("ntpage", ntpage);
		ntmodel.addObject("ntmaxpage", ntmaxpage);
		ntmodel.addObject("ntstartpage", ntstartpage);
		ntmodel.addObject("ntendpage", ntendpage);
		ntmodel.addObject("ntlistcount", ntlistcount);
		ntmodel.addObject("ntlist", ntlist);

		/*
		 * PrintWriter out = response.getWriter(); out.println("<script>");
		 * out.println("opener.document.location.reload();");
		 * out.println("self.close()"); out.println("</script>");
		 */
		/* return "redirect:qa_list.nhn"; */
		return ntmodel;
	}

	@RequestMapping(value = "/nt_find_okajax.nhn", method = RequestMethod.GET)
	public ModelAndView nt_find_okajax(HttpServletRequest request,
			/* HttpServletResponse response, */
			@RequestParam(value = "ntpage", defaultValue = "1") int ntpage,
			@RequestParam("ntfind_name") String ntfind_name, @RequestParam("ntfind_field") String ntfind_field)
			throws Exception {
		int ntlimit = 10;

		Map ntm = new HashMap();
		ntm.put("ntpage", ntpage);
		ntm.put("ntfind_field", ntfind_field);
		ntm.put("ntfind_name", "%" + ntfind_name + "%");
		int ntlistcount = this.ntService.getntListCount3(ntm);

		System.out.println(ntfind_name + " : " + ntfind_field + " : " + ntlistcount);
		int ntmaxpage = (ntlistcount + ntlimit - 1) / ntlimit;

		int ntstartpage = ((ntpage - 1) / 10) * 10 + 1;

		int ntendpage = ntstartpage + 10 - 1;

		if (ntendpage > ntmaxpage)
			ntendpage = ntmaxpage;

		List<NtBean> ntlist = ntService.getNtList3(ntm);
		System.out.println(ntlist.size());

		ModelAndView ntmodel = new ModelAndView("nt/nt_find");
		ntmodel.addObject("ntfind_name", ntfind_name);
		ntmodel.addObject("ntfind_field", ntfind_field);
		ntmodel.addObject("ntpage", ntpage);
		ntmodel.addObject("ntmaxpage", ntmaxpage);
		ntmodel.addObject("ntstartpage", ntstartpage);
		ntmodel.addObject("ntendpage", ntendpage);
		ntmodel.addObject("ntlistcount", ntlistcount);
		ntmodel.addObject("ntlist", ntlist);

		/*
		 * PrintWriter out = response.getWriter(); out.println("<script>");
		 * out.println("opener.document.location.reload();");
		 * out.println("self.close()"); out.println("</script>");
		 */
		/* return "redirect:qa_list.nhn"; */
		return ntmodel;
	}

	/* faq野껓옙占쎄퉳 */
	@RequestMapping(value = "/faq_find_ok.nhn", method = RequestMethod.GET)
	public ModelAndView faq_find_ok(HttpServletRequest request,
			/* HttpServletResponse response, */
			@RequestParam(value = "faqpage", defaultValue = "1") int faqpage,
			@RequestParam("faqfind_name") String faqfind_name, @RequestParam("faqfind_field") String faqfind_field)
			throws Exception {
		int faqlimit = 10;

		Map faqm = new HashMap();
		faqm.put("faqpage", faqpage);
		faqm.put("faqfind_field", faqfind_field);
		faqm.put("faqfind_name", "%" + faqfind_name + "%");
		int faqlistcount = this.faqService.getfaqListCount3(faqm);
		int faqmaxpage = (faqlistcount + faqlimit - 1) / faqlimit;

		int faqstartpage = ((faqpage - 1) / 10) * 10 + 1;

		int faqendpage = faqstartpage + 10 - 1;

		if (faqendpage > faqmaxpage)
			faqendpage = faqmaxpage;

		List<FaqBean> faqlist = faqService.getFaqList3(faqm);

		ModelAndView faqmodel = new ModelAndView("faq/faq_find");
		faqmodel.addObject("faqfind_name", faqfind_name);
		faqmodel.addObject("faqfind_field", faqfind_field);
		faqmodel.addObject("faqpage", faqpage);
		faqmodel.addObject("faqmaxpage", faqmaxpage);
		faqmodel.addObject("faqstartpage", faqstartpage);
		faqmodel.addObject("faqendpage", faqendpage);
		faqmodel.addObject("faqlistcount", faqlistcount);
		faqmodel.addObject("faqlist", faqlist);

		return faqmodel;
	}

	/* qna野껓옙占쎄퉳 */
	@RequestMapping(value = "/qna_find_ok.nhn", method = RequestMethod.GET)
	public ModelAndView qna_find_ok(HttpServletRequest request,
			/* HttpServletResponse response, */
			@RequestParam(value = "qnapage", defaultValue = "1") int qnapage,
			@RequestParam("qnafind_name") String qnafind_name, @RequestParam("qnafind_field") String qnafind_field)
			throws Exception {
		int qnalimit = 10;

		Map qnam = new HashMap();
		qnam.put("qnapage", qnapage);
		qnam.put("qnafind_field", qnafind_field);
		qnam.put("qnafind_name", "%" + qnafind_name + "%");
		int qnalistcount = this.qnaService.getqnaListCount3(qnam);
		int qnamaxpage = (qnalistcount + qnalimit - 1) / qnalimit;

		int qnastartpage = ((qnapage - 1) / 10) * 10 + 1;

		int qnaendpage = qnastartpage + 10 - 1;

		if (qnaendpage > qnamaxpage)
			qnaendpage = qnamaxpage;

		List<QnaBean> qnalist = qnaService.getQnaList3(qnam);

		ModelAndView qnamodel = new ModelAndView("qna/qna_find");
		qnamodel.addObject("qnafind_name", qnafind_name);
		qnamodel.addObject("qnafind_field", qnafind_field);
		qnamodel.addObject("qnapage", qnapage);
		qnamodel.addObject("qnamaxpage", qnamaxpage);
		qnamodel.addObject("qnastartpage", qnastartpage);
		qnamodel.addObject("qnaendpage", qnaendpage);
		qnamodel.addObject("qnalistcount", qnalistcount);
		qnamodel.addObject("qnalist", qnalist);

		return qnamodel;
	}

}
