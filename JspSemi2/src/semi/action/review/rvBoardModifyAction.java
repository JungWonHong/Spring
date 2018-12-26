package semi.action.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.BoardDAO;
import semi.db.bean.ReviewBoardBean;

public class rvBoardModifyAction implements Action {
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("euc-kr");
      ActionForward forward=new ActionForward();
      boolean result=false;
      
      //전달받은 파라미터 num 변수에 저장합니다.
      int num=Integer.parseInt(request.getParameter("RV_NO"));
      BoardDAO boarddao=new BoardDAO();
      ReviewBoardBean rv=new ReviewBoardBean();
      
      //글쓴이만 수정 가능(채워야함)
      
      try{
         //수정 내용 설정
         rv.setRv_no(num);
         rv.setRv_title(request.getParameter("rv_title"));
         rv.setRv_content(request.getParameter("rv_content"));
         
         //DAO에서 수정메서드를 호출하여 수정
         result=boarddao.rvBoardModify(rv);
         
         //수정에 실패한 경우
         if(result==false){
            System.out.println("게시판 수정 실패");
            return null;
         }
         //수정 성공
         System.out.println("게시판 수정 완료");
         
         forward.setRedirect(true);
         //수정한 글 내용을 보여주기 위해 글 내용 보기 페이지로 이동하기 위해 경로 설정
         forward.setPath(
            "./rvBoardDetailAction.bo?num="+rv.getRv_no());
         return forward;
      }catch(Exception ex){
            ex.printStackTrace();    
    }
      return null;
   }

}