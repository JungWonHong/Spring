package semi.action.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.BoardDAO;

public class rvBoardDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("euc-kr");
		
		boolean result=false;
		//list ���������� �޾ƿ� ��
		int num=Integer.parseInt(request.getParameter("rv_no"));
		
		BoardDAO boarddao=new BoardDAO();
		
		result=boarddao.rvboardDelete(num);
		if(result==false){
			System.out.println("�Խ��� ���� ����");
			return null;
		}
		//���� ó�� ����- �۸�� ���� ��û�� ����
		System.out.println("�Խ��� ���� ����");
		forward.setRedirect(true);
		forward.setPath("./rvBoardList.bo");
		return forward;
	}

}
