package semi.action.pool;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.MemberDAO;
import semi.db.bean.PMemberBean;

public class PoolListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		List<PMemberBean> poollist = new ArrayList<PMemberBean>();

		int poolpage = 1;
		int limit = 10;

		if (request.getParameter("poolpage") != null) {
			poolpage = Integer.parseInt(request.getParameter("poolpage"));
		}
		System.out.println("넘어온 페이지" + poolpage);

		int poollistcount = mdao.getPoolListCount(); // 총 리스트 수를 받아옴
		poollist = mdao.getPoolList(poolpage, limit); // 페이지와 리스트에 표시할 글 수를
															// 파라미터로 전달하여 글 목록을
															// 얻어와서
															// boardlist(List)
															// 객체에 저장

		// 총페이지 수
		int poolmaxpage = (poollistcount + limit - 1) / limit;
		System.out.println("총 페이지 수 = " + poolmaxpage);
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int poolstartpage = ((poolpage - 1) / 10) * 10 + 1;
		System.out.println("현재 페이지에 보여줄 시작 페이지 수 = " + poolstartpage);
		// 현재 페이징 보여줄 마지막 페이지 수(10, 20, 30 등...)
		int poolendpage = poolstartpage + 10 - 1;

		if (poolendpage > poolmaxpage)
			poolendpage = poolmaxpage;

		// 각 설정한 정보는 request 객체에 저장
		request.setAttribute("poolpage", poolpage);// 현재 페이지의 수
		request.setAttribute("poolmaxpage", poolmaxpage);// 최대 페이지의 수
		request.setAttribute("poolstartpage", poolstartpage);// 현재 페이지에 표시할 첫 페이지의 수
		request.setAttribute("poolendpage", poolendpage);// 현재페이지에 표시할 끝 페이지 수
		request.setAttribute("poollistcount", poollistcount);// 글 수
		request.setAttribute("poollist", poollist);

		forward.setPath("./semi/pool/pool_list.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
