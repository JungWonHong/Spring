package com.khcc.myweb.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.khcc.myweb.dao.ReportService;
import com.khcc.myweb.model.ReportBean;

@Controller
public class ReportAction {

	@Resource(name = "reportService")
	private ReportService reportService;

	// private String saveFolder =
	// "C:/Users/Jisoo/springworkspace/springFinal_all/src/main/webapp/resources/upload";

	/* 신고하기 작성(회원) */
	@RequestMapping(value = "/khcc_reportwrite.nhn")
	public String report_write() throws Exception {
		return "report/report_write";
	}

	/* 삭제(회원) */
	@RequestMapping(value = "/khcc_reportdel.nhn")
	public ModelAndView report_del(@RequestParam("num") int num, @RequestParam("page") int page,
			@RequestParam("state") String state) throws Exception {
		// ReportBean reportbean=this.reportService.getReportCont(num);
		ModelAndView model = new ModelAndView("report/report_del");
		// model.addObject("reportbean", reportbean);
		model.addObject("num", num);
		model.addObject("state", state);
		model.addObject("page", page);
		return model;
	}

	/* 게시판 저장 */
	@RequestMapping(value = "/khcc_reportwrite_ok.nhn", method = RequestMethod.POST)
	public String khcc_reportwrite_ok(ReportBean report, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 여기
		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");

		MultipartFile uploadfile = report.getUploadfile();
		//
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(report.getR_SENDER());
		if (!uploadfile.isEmpty()) {
			// 원래 파일명 구해오기
			String fileName = uploadfile.getOriginalFilename();

			// 원래 파일명 저장
			report.setR_ORGIMG(fileName);

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
			String fileExtension = fileName.substring(index + 1);
			/**** 확장자 구하기 끝 ***/

			// 새로운 파일명을 저장
			String refileName = "report" + year + month + date + random + "." + fileExtension;

			// 오라클 디비에 저장될 레코드 값
			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;

			// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile.transferTo(new File(saveFolder + fileDBName));
			// 바뀐 파일명으로 저장
			report.setR_IMG(fileDBName);
			report.setR_RECEIVER("admin");
		}

		this.reportService.insertreport(report);// 저장 메소드 호출

		out.println("<script>");
		out.println("window.close();");
		out.println("</script>");
		return null;
	}

	/* 신고하기 리스트(관리자) */
	@RequestMapping(value = "/khcc_reportlist.nhn")
	public ModelAndView report_list(@RequestParam(value = "page", defaultValue = "1", required = false) int page)
			throws Exception {

		// value="page" : 요청 파라미터 page
		// defaultValue="1" ; 요청 파라미터가 존재하지 않을 때 1의 값을 설정
		// required=false : 요청 파라미터가 필수가 아닌 경우

		int limit = 5; // 한 화면에 출력할 레코드 갯수

		int listcount = reportService.getListCount(); // 총 리스트 수를 받아옴

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

		List<ReportBean> reportlist = reportService.getReportList(page);

		ModelAndView model = new ModelAndView("report/report_list");
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("reportlist", reportlist);
		return model;
	}

	/* 서비스 안내 뷰 */
	@RequestMapping(value = "/khcc_servicesview.nhn")
	public String services_view() throws Exception {
		return "servicesView/services_view";
	}

	/* 자료실 내용보기, 수정폼, 답변글폼, 삭제폼 */
	@RequestMapping(value = "/khcc_reportcont.nhn")
	public ModelAndView report_cont(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam("num") int num,
			@RequestParam("state") String state) throws Exception {

		// 번호를 기준으로 DB 내용을 가져옵니다.
		ReportBean reportbean = this.reportService.getReportCont(num);

		ModelAndView contM = new ModelAndView();

		if (state.equals("cont")) {// 내용보기
			contM.setViewName("report/report_cont");

			// 글내용 중 엔터키 친부분을 다음줄로 개행 처리
			String report_cont = reportbean.getR_CONTENT().replace("\n", "<br/>");

			contM.addObject("report_cont", report_cont);
		} else if (state.equals("del")) {// 삭제일때
			contM.setViewName("report/report_del");
		}
		contM.addObject("reportbean", reportbean);
		contM.addObject("page", page);
		return contM;
	}

	@RequestMapping(value = "/submit_report.nhn")
	public String submit_report(HttpServletResponse response, @RequestParam("illegal") String illegal) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		this.reportService.submitReport(illegal);
		int check = this.reportService.checkPenalty(illegal);
		
		out.println("<script>");
		if(check == 3) {
			out.println("alert('경고 누적 3회 회원! 탈퇴처리해주세요.');");
			out.println("self.close();");
			out.println("opener.location.href='./khcc_adminpage.nhn';");
		} else {
			out.println("alert('경고 누적 완료.');");
			out.println("location.href='./khcc_reportlist.nhn';");
		}
		out.println("</script>");
			
		return null;
	}

	/* 자료실 삭제 */
	@RequestMapping(value = "/khcc_reportdelete_ok.nhn", method = RequestMethod.POST)
	public ModelAndView report_delete_ok(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("r_NUM") int r_NUM, @RequestParam("page") int page, @RequestParam("state") String state)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 글번호에 해당하는 디비 내용을 가져옵니다.
		ReportBean reportbean = this.reportService.getReportCont(r_NUM);

		// 기존 파일명 가져옵니다.
		String fname = reportbean.getR_ORGIMG();

		// 이미지 상대 경로 삭제
		String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");
		if (fname != null) {// 기존 이진파일이 존재한다면
			File file = new File(saveFolder + fname);
			file.delete();// 서버 폴더로 부터 기존 이진파일 삭제합니다.
		}
		// 이미지 상대 경로 삭제

		this.reportService.deleteReport(r_NUM);// 디비로 부터 레코드 삭제합니다.
		out.println("<script>");
		out.println("self.close();");
		if (state.equals("list"))
			out.println("opener.document.location.reload();");
		else if (state.equals("con"))
			out.println("opener.document.location.href='./khcc_reportlist.nhn';");
		out.println("</script>");
		return null;
	}
}
