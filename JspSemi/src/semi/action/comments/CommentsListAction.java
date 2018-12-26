package semi.action.comments;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.CommentsDAO;
import semi.db.bean.CommentsBean;

public class CommentsListAction implements Action {

   public ActionForward execute(
         HttpServletRequest request, HttpServletResponse response) 
               throws Exception {
      CommentsDAO boarddao = new CommentsDAO();
      List<CommentsBean> commentslist = new ArrayList<CommentsBean>();
      
      int cmtpage = 1;
      int limit = 10;
      
      if(request.getParameter("cmtpage") != null) {
    	  cmtpage = Integer.parseInt(request.getParameter("cmtpage"));
      }
      System.out.println("넘어온 페이지 = " + cmtpage);
      
      HttpSession session = request.getSession();
      int boardnum = (int)session.getAttribute("boardnum");
      int cmtlistcount = boarddao.getCommentsListCount(boardnum); // 총 리스트 수를 받아옵니다.
      commentslist = boarddao.getCommentsList(cmtpage, limit, boardnum); // 리스트를 받아옵니다.
      
      int cmtmaxpage = (cmtlistcount + limit - 1) / limit;
      System.out.println("총 페이지 수 = " + cmtmaxpage);
      
      int cmtstartpage = ((cmtpage - 1) / 10) * 10 + 1; //시작페이지
      System.out.println("시작 페이지 수 = " + cmtstartpage);
      
      int cmtendpage = cmtstartpage + 10 - 1; //마지막페이지
      System.out.println("마지막 페이지 수 = " + cmtendpage);
      
      if (cmtendpage > cmtmaxpage) cmtendpage = cmtmaxpage;
      
      request.setAttribute("cmtpage", cmtpage);
      request.setAttribute("cmtmaxpage", cmtmaxpage);
      
      request.setAttribute("cmtstartpage", cmtstartpage);
      
      request.setAttribute("cmtendpage", cmtendpage);
      
      request.setAttribute("cmtlistcount", cmtlistcount); //총 글의 수
      
      request.setAttribute("commentslist", commentslist);
      
      ActionForward forward = new ActionForward();
      forward.setRedirect(false);
      
      forward.setPath("./semi/comments/Comments_List.jsp");
      return forward;
   }
}