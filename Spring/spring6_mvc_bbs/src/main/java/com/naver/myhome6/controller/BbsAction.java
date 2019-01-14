//@RequestParam(value="page", defaultValue="1", required=false) int page) 사용
//BbsBean bbsbean (command 객체 사용)
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
import org.springframework.web.multipart.MultipartFile;//파일 업로드에 사용합니다.
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome6.dao.BbsService;
import com.naver.myhome6.model.BbsBean;

@Controller
public class BbsAction {

	@Autowired
	private BbsService bbsService;

	private String saveFolder = "I:\\KH\\Spring\\spring6_mvc_bbs\\src\\main\\webapp\\resources\\upload";

	/* 자료실 입력폼 */
	@RequestMapping(value = "/bbs_write.nhn")
	public String bbs_write() {
		return "bbs/bbs_write"; // bbs 폴더의 bbs_write.jsp 뷰 페이지가 실행
	}

	/* 자료실 저장 */
	// 첨부파일 클릭해서 이미지 보고자 할 경우 :
	// 자동 새로 고침 설정(window-> Preferencs -> workspce
	// -> Refresh using native hooks or polling 체크)
	// 하고 5초 정도 지난 뒤 확인하세요
	/*
	 * CommonsMultipartResolver 역할 : 파일 업로드 기능을 구현해 놓은 클래스입니다.
	 * 
	 * 스프링 컨테이너는 매개변수 BbsBean객체를 생성하고 BbsBean객체의 setter 메서드들을 호출하여 사용자 입력값을 설정합니다.
	 * 매개변수의 이름과 setter의 property가 일치하면 됩니다.
	 */
	@RequestMapping(value = "/bbs_write_ok.nhn", method = RequestMethod.POST)
	public String bbs_write_ok(BbsBean bbsbean) throws Exception {
		MultipartFile uploadfile = bbsbean.getUploadfile();

		if (!uploadfile.isEmpty()) {
			// 원래 파일명 구해오기
			String fileName = uploadfile.getOriginalFilename();

			// 원래 파일명 저장
			bbsbean.setBbs_original(fileName);

			// 생성할 폴더 이름 : 오늘 년+월+일
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR); // 오늘 년도 구합니다.
			int month = c.get(Calendar.MONTH) + 1; // 오늘 월 구합니다.
			int date = c.get(Calendar.DATE); // 오늘 일 구합니다.
			String homedir = saveFolder + "/" + year + "-" + month + "-" + date;
			System.out.println("homedir = " + homedir);
			File path1 = new File(homedir);

			if (!(path1.exists())) {
				path1.mkdir();// 새로운 폴더를 생성
			}

			// 난수를 구합니다.
			Random r = new Random();
			int random = r.nextInt(100000000);

			/**** 확장자 구하기 시작 ****/
			int index = fileName.lastIndexOf(".");
			// 문자열에서 특정 문자열의 위치 값(index)를 반환한다.
			// indexOf가 처음 발견되는 문자열에 대한 index를 반환하는 반면,
			// lastIndexOf는 마지막으로 발견되는 문자열의 index를 반환합니다.
			// (파일명에 점에 여러개 있을 경우 맨 마지막에 발견되는 문자열의 위치를 리턴합니다.)
			System.out.println("index = " + index);

			String fileExtension = fileName.substring(index + 1);
			System.out.println("fileExtension = " + fileExtension);
			/**** 확장자 구하기 끝 ***/

			// 새로운 파일명을 저장
			String refileName = "bbs" + year + month + date + random + "." + fileExtension;
			System.out.println("refileName = " + refileName);

			// 오라클 디비에 저장될 레코드 값
			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
			System.out.println("fileDBName = " + fileDBName);

			// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile.transferTo(new File(saveFolder + fileDBName));
			// 바뀐 파일명으로 저장
			bbsbean.setBbs_file(fileDBName);
		}

		this.bbsService.insertBbs(bbsbean); // 저장메서드 호출

		return "redirect:bbs_list.nhn";
	}

	/* 자료실 목록 */
	@RequestMapping(value = "/bbs_list.nhn")
	public ModelAndView bbs_list(@RequestParam(value = "page", defaultValue = "1", required = false) int page)
			throws Exception {
		// value="page" : 요청 파라미터 page
		// defaultValue="1" ; 요청 파라미터가 존재하지 않을 때 1의 값을 설정
		// required=false : 요청 파라미터가 필수가 아닌 경우

		int limit = 10; // 한 화면에 출력할 레코드 갯수

		int listcount = bbsService.getListCount(); // 총 리스트 수를 받아옴

		// 총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;

		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30 등...)
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

	/* 자료실 내용보기, 수정폼, 답변글폼, 삭제폼 */
	@RequestMapping(value = "/bbs_cont.nhn")
	public ModelAndView bbs_cont(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam("num") int num,
			@RequestParam("state") String state) throws Exception {

		if (state.equals("cont")) {
			this.bbsService.bbsHit(num);// 조회수 증가
		}

		// 번호를 기준으로 DB 내용을 가져옵니다.
		BbsBean bbsbean = this.bbsService.getBbsCont(num);

		ModelAndView contM = new ModelAndView();

		if (state.equals("cont")) {// 내용보기
			contM.setViewName("bbs/bbs_cont");

			// 글내용 중 엔터키 친부분을 다음줄로 개행 처리
			String bbs_cont = bbsbean.getBbs_content().replace("\n", "<br/>");

			contM.addObject("bbs_cont", bbs_cont);
		} else if (state.equals("edit")) {
			contM.setViewName("bbs/bbs_edit");
		} else if (state.equals("del")) {// 삭제일때
			contM.setViewName("bbs/bbs_delete");
		} else if (state.equals("reply")) {// 답변글
			contM.setViewName("bbs/bbs_reply");
		}
		contM.addObject("bbsbean", bbsbean);
		contM.addObject("page", page);
		return contM;
	}

	/* 자료실 수정 */
	@RequestMapping(value = "/bbs_edit_ok.nhn", method = RequestMethod.POST)
	public ModelAndView bbs_edit_ok(BbsBean bbsbean, @RequestParam int page, HttpServletResponse response)
			throws Exception {
		System.out.println("넘어온 비밀번호 = " + bbsbean.getBbs_pass());
		System.out.println(page);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int bbs_num = bbsbean.getBbs_num();

		// 디비로 부터 내용을 가져옴
		BbsBean bcont = this.bbsService.getBbsCont(bbs_num);

		if (!bcont.getBbs_pass().equals(bbsbean.getBbs_pass())) {// 비번이 다르다면
			out.println("<script>");
			out.println("alert('비번이 다릅니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			MultipartFile uploadfile = bbsbean.getUploadfile();

			if (!uploadfile.isEmpty()) {
				File DelFile = new File(saveFolder + bcont.getBbs_file());
				if (DelFile.exists()) {
					DelFile.delete();// 기존 이진파일을 삭제
				}
				String fileName = uploadfile.getOriginalFilename();
				bbsbean.setBbs_original(fileName);
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR); // 오늘 년도 구합니다.
				int month = c.get(Calendar.MONTH) + 1; // 오늘 월 구합니다.
				int date = c.get(Calendar.DATE); // 오늘 일 구합니다.
				String homedir = saveFolder + "/" + year + "-" + month + "-" + date;

				File path1 = new File(homedir);
				if (!(path1.exists())) {
					path1.mkdir();// 새로운 폴더를 생성
				}

				// 난수를 구합니다.
				Random r = new Random();
				int random = r.nextInt(100000000);

				/**** 확장자 구하기 시작 ****/
				int index = fileName.lastIndexOf(".");
				// 문자열에서 특정 문자열의 위치 값(index)를 반환한다.
				// indexOf가 처음 발견되는 문자열에 대한 index를 반환하는 반면,
				// lastIndexOf는 마지막으로 발견되는 문자열의 index를 반환합니다.
				// (파일명에 점에 여러개 있을 경우 맨 마지막에 발견되는 문자열의 위치를 리턴합니다.)
				System.out.println("index = " + index);

				String fileExtension = fileName.substring(index + 1);
				System.out.println("fileExtension = " + fileExtension);
				/**** 확장자 구하기 끝 ***/

				// 새로운 파일명을 저장
				String refileName = "bbs" + year + month + date + random + "." + fileExtension;
				System.out.println("refileName = " + refileName);

				// 오라클 디비에 저장될 레코드 값
				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
				System.out.println("fileDBName = " + fileDBName);

				uploadfile.transferTo(new File(saveFolder + fileDBName));// transferTo(File path) : 업로드한 파일을 매개변수의 경로에
																			// 저장합니다.
				// 바뀐 파일명으로 저장
				bbsbean.setBbs_file(fileDBName);
			}

			this.bbsService.editBbs(bbsbean);// 수정메서드 호출

			// get방식으로 3개의 파라미터 값이 넘어갑니다.
			response.sendRedirect("bbs_cont.nhn?state=cont&page=" + page + "&num=" + bbs_num);
		}
		return null;
	}

	/* 자료실 삭제 */
	@RequestMapping(value = "/bbs_delete_ok.nhn", method = RequestMethod.POST)
	public ModelAndView bbs_delete_ok(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("bbs_num") int bbs_num, @RequestParam("page") int page) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String pwd = request.getParameter("pwd").trim();

		// 글번호에 해당하는 디비 내용을 가져옵니다.
		BbsBean bbsbean = this.bbsService.getBbsCont(bbs_num);

		// 기존 파일명 가져옵니다.
		String fname = bbsbean.getBbs_file();

		if (!bbsbean.getBbs_pass().equals(pwd)) {// 비번이 같지 않다면
			out.println("<script>");
			out.println("alert('비번이 다릅니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {// 비번이 같다면
			if (fname != null) {// 기존 이진파일이 존재한다면
				File file = new File(saveFolder + fname);
				file.delete();// 서버 폴더로 부터 기존 이진파일 삭제합니다.
			}
			this.bbsService.deleteBbs(bbs_num);// 디비로 부터 레코드 삭제합니다.
			response.sendRedirect("bbs_list.nhn?page=" + page);
		}
		return null;
	}

	/* 자료실 답변저장 */
	@RequestMapping(value = "/bbs_reply_ok.nhn", method = RequestMethod.POST)
	public ModelAndView bbs_reply_ok(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute BbsBean bbsbean, @RequestParam("page") int page) throws Exception {

		this.bbsService.refEdit(bbsbean);

		bbsbean.setBbs_re_lev(bbsbean.getBbs_re_lev() + 1);
		bbsbean.setBbs_re_seq(bbsbean.getBbs_re_seq() + 1);

		this.bbsService.bbsReplyOk(bbsbean); // 저장 메서드 호출

		response.sendRedirect("bbs_list.nhn?page=" + page); // 해당 쪽번호 목록으로 이동
		return null;
	}

	/* server.xml 한글 처리 인코딩 설정 - get 방식 적용 
	<Connector connectionTimeout="20000" port="8088" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/> */
	/* 자료실 검색 목록 */
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
		//총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;
		
		//현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등 ...)
		int startpage = ((page - 1) / 10) * 10 + 1;
		
		//현재 페이지에 보여줄 마지막 페이지 수 (10, 20, 30 등 ...)
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

		// 브라우저 종류 찾기
		String header = request.getHeader("User-Agent");
		String browser = "";
		System.out.println("header= " + header);
		if (header.contains("MSIE") || header.contains("Trident")) {// 11버전이상 : "Trident"
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

		// 한글이름의 파일 다운로드 (이 부분이 한글 파일명이 깨지는 것을 방지해 줍니다.)
		// IE와 다른 브라우저 처리
		String sEncoding = "";
		if (browser.equals("MSIE")) {
			System.out.println("MSIE");
			// sEncoding = java.net.URLEncoder.encode(originalFileName, "UTF-8");
			sEncoding = URLEncoder.encode(originalFileName, "UTF-8").replaceAll("\\+", "%20");
			// 파일명에 공백이 있는 경우 "+"가 생기는 것을 공백으로 처리합니다.
			// sEncoding = sEncoding.replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {// Firefox의 경우 파일명에 공백이 있는 경우 공백을 기준으로 앞의 글자만 파일명으로 인식해서 파일명 앞뒤에 ("")을
												// 붙여서 해결했습니다.
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
