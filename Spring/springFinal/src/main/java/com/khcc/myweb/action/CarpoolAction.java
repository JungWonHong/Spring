package com.khcc.myweb.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khcc.myweb.dao.CarpoolService;
import com.khcc.myweb.model.CarpoolBean;
import com.khcc.myweb.model.CpReservationBean;

@Controller
public class CarpoolAction {
	@Autowired
	private CarpoolService cpService;

	// 처음 보여주는 화면
	@RequestMapping(value = "/rider")
	public ModelAndView start(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("self.close();");
			out.println("opener.document.location.href='khcc_login.nhn';");
			out.println("</script>");
			return null;
		} else {
			ModelAndView a = new ModelAndView();
			a.setViewName("carpool/rider");
			return a;
		}
	}

	// 라이더가 최종 등록 전 확인하는 작업
	@RequestMapping(value = "/rider_add")
	public String rider_add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String date = request.getParameter("date");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String duration = request.getParameter("duration");
		String distance = request.getParameter("distance");
		String[] distance2 = distance.split("km"); // 거리km 에서 km를 제거.
		int fee = (int) Double.parseDouble(distance2[0]) * 600; // km당 600원 요금 계산

		request.setAttribute("date", date);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("duration", duration);
		request.setAttribute("distance", distance2[0]);
		request.setAttribute("fee", fee);

		return "carpool/rider_add";
	}

	// 라이더가 최종 확인 후 카풀등록
	@RequestMapping(value = "/carpool_add", method = RequestMethod.POST)
	public String carpool_add(CarpoolBean cpbean, HttpServletResponse response) throws Exception {
		this.cpService.insertCp(cpbean);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("self.close();");
		out.println("opener.close();");
		out.println("</script>");
		out.close();
		return null;
	}

	// 카풀 리스트(driver 메뉴 클릭시)
	@RequestMapping(value = "/cp_list")
	public ModelAndView cp_list(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "viewlist", defaultValue = "recent") String type) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String login_email = (String) session.getAttribute("login_email");
		if (login_email == null) {
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.')");
			out.println("location='khcc_login.nhn'");
			out.println("</script>");
			return null;
		} else {
			String check = this.cpService.checkDriver(login_email);
			if (check == null) {
				out.println("<script>");
				out.println("alert('면허와 카드 등록이 필요한 서비스입니다.')");
				out.println("location.href='khcc_mypage.nhn'");
				out.println("</script>");
				return null;
			} else {
				int limit = 10; // 한 화면에 출력할 레코드 갯수
				int listcount = cpService.getListCount(); // 오늘 등록된 카풀 갯수)
				int totalcount = cpService.getListTotal(); // 총 카풀 갯수
				int maxpage = (totalcount + limit - 1) / limit; // 총 페이지 수
				int startpage = ((page - 1) / 10) * 10 + 1; // 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
				int endpage = startpage + 10 - 1; // 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30 등...)

				if (endpage > maxpage)
					endpage = maxpage;

				if (endpage < page)
					page = endpage;

				// 정렬방법 (최신순, 거리순, 요금순)
				String type2 = "";
				if (type.equals("recent"))
					type2 = "cp_regdate";
				else if (type.equals("distance"))
					type2 = "cp_distance";
				else
					type2 = "cp_sum";

				Map m = new HashMap();
				m.put("page", page);
				m.put("type", type2);

				List<CarpoolBean> cplist = cpService.getCpList(m);
				ModelAndView model = new ModelAndView("carpool/driver");
				model.addObject("page", page);
				model.addObject("maxpage", maxpage);
				model.addObject("startpage", startpage);
				model.addObject("endpage", endpage);
				model.addObject("listcount", listcount);
				model.addObject("totalcount", totalcount);
				model.addObject("cplist", cplist);
				model.addObject("type", type);

				return model;
			}
		}
	}

	// 카풀 리스트 검색
	@RequestMapping(value = "/cp_find", method = RequestMethod.GET)
	public ModelAndView bbs_find_ok(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "viewlist", defaultValue = "recent") String type,
			@RequestParam("find_name") String find_name, @RequestParam("find_field") String find_field)
			throws Exception {

		System.out.println(type);
		int limit = 10;

		// 정렬방법 (최신순, 거리순, 요금순)
		String type2 = "";
		if (type.equals("recent"))
			type2 = "cp_regdate";
		else if (type.equals("distance"))
			type2 = "cp_distance";
		else
			type2 = "cp_sum";

		Map m = new HashMap();
		m.put("page", page);
		m.put("type", type2);
		m.put("find_field", find_field);
		m.put("find_name", "%" + find_name + "%");

		int listcount = cpService.getListCount3(m);
		// 총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;

		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등 ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// 현재 페이지에 보여줄 마지막 페이지 수 (10, 20, 30 등 ...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;

		List<CarpoolBean> cplist = cpService.getCpList3(m);

		ModelAndView model = new ModelAndView("carpool/driver_find");
		model.addObject("find_name", find_name);
		model.addObject("find_field", find_field);
		model.addObject("page", page);
		model.addObject("maxpage", maxpage);
		model.addObject("startpage", startpage);
		model.addObject("endpage", endpage);
		model.addObject("listcount", listcount);
		model.addObject("cplist", cplist);
		model.addObject("type", type);
		return model;
	}

	@RequestMapping(value = "/carpool_request")
	public String carpool_request(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cp_num = request.getParameter("cp_num");
		String depart = request.getParameter("depart");
		String arrive = request.getParameter("arrive");
		String time = request.getParameter("time");
		String distance = request.getParameter("distance");
		String sum = request.getParameter("sum");
		String id = request.getParameter("cp_id");

		request.setAttribute("cp_num", cp_num);
		request.setAttribute("depart", depart);
		request.setAttribute("arrive", arrive);
		request.setAttribute("time", time);
		request.setAttribute("distance", distance);
		request.setAttribute("sum", sum);
		request.setAttribute("cp_id", id);

		return "carpool/carpool_add";
	}

	@RequestMapping(value = "/cprequest_ok")
	public String cprequest_ok(CpReservationBean cprbean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String cp_num = request.getParameter("cr_num");
		this.cpService.updateCp(cp_num);
		this.cpService.insertCpr(cprbean);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("self.close();");
		out.println("alert('신청완료');");
		out.println("opener.document.location.reload();");
		out.println("</script>");
		out.close();
		return null;
	}
}
