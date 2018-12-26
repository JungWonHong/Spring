package semi.action.source;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.*;
import semi.db.bean.SourceBoardBean;
public class sbBoardSearchAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boarddao=new BoardDAO();
		ArrayList<SourceBoardBean> boardlist=new ArrayList<SourceBoardBean>();
		request.setCharacterEncoding("euc-kr");
		String keyField=(String)request.getParameter("keyField");
		String keyWord=(String)request.getParameter("keyWord");
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지"+page);
		
		int listcount=boarddao.sbSearchListCount(keyField, keyWord); //총 리스트 수를 받아옴
		//boardlist=boarddao.sbSearchBoardList(keyField, keyWord, page, limit); //페이지와 리스트에 표시할 글 수를 파라미터로 전달하여 글 목록을 얻어와서
														//boardlist(List) 객체에 저장
		boardlist=boarddao.sbSearchBoardList(keyField, keyWord, page, limit);
		
		//총페이지 수
		 int maxpage = (listcount + limit - 1) / limit;
	     System.out.println("총 페이지 수 = " + maxpage);
	     //현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
	     int startpage = ((page - 1) / 10) * 10 + 1;
	     System.out.println("현재 페이지에 보여줄 시작 페이지 수 = " + startpage);
	     //현재 페이징 보여줄 마지막 페이지 수(10, 20, 30 등...)
	     int endpage=startpage+10-1;
	     
	     if(endpage>maxpage) endpage=maxpage;
	     
	     //각 설정한 정보는 request 객체에 저장
	     request.setAttribute("page", page);//현재 페이지의 수
	     request.setAttribute("maxpage", maxpage);//최대 페이지의 수
	     request.setAttribute("startpage", startpage);//현재 페이지에 표시할 첫 페이지의 수
	     request.setAttribute("endpage", endpage);//현재페이지에 표시할 끝 페이지 수
	     request.setAttribute("listcount", listcount);//글 수
	     request.setAttribute("boardlist", boardlist);
	     request.setAttribute("keyWord", keyWord);
	     request.setAttribute("keyField", keyField);

	     ActionForward forward=new ActionForward();
	     forward.setRedirect(false);
	     forward.setPath("./semi/sourceboard/sbboard_result.jsp");
	     
	     return forward;
	}
}
