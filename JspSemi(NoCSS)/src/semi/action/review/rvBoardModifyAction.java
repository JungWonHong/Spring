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
      
      //���޹��� �Ķ���� num ������ �����մϴ�.
      int num=Integer.parseInt(request.getParameter("RV_NO"));
      BoardDAO boarddao=new BoardDAO();
      ReviewBoardBean rv=new ReviewBoardBean();
      
      //�۾��̸� ���� ����(ä������)
      
      try{
         //���� ���� ����
         rv.setRv_no(num);
         rv.setRv_title(request.getParameter("rv_title"));
         rv.setRv_content(request.getParameter("rv_content"));
         
         //DAO���� �����޼��带 ȣ���Ͽ� ����
         result=boarddao.rvBoardModify(rv);
         
         //������ ������ ���
         if(result==false){
            System.out.println("�Խ��� ���� ����");
            return null;
         }
         //���� ����
         System.out.println("�Խ��� ���� �Ϸ�");
         
         forward.setRedirect(true);
         //������ �� ������ �����ֱ� ���� �� ���� ���� �������� �̵��ϱ� ���� ��� ����
         forward.setPath(
            "./rvBoardDetailAction.bo?num="+rv.getRv_no());
         return forward;
      }catch(Exception ex){
            ex.printStackTrace();    
    }
      return null;
   }

}