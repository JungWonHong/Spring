//��� ����
package semi.action.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.CommentsDAO;

public class CommentsDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");
		boolean result=false;
		int com_no =Integer.parseInt(request.getParameter("com_no"));
		
		
		CommentsDAO cmtdao = new CommentsDAO();
		System.out.println(com_no);
		result = cmtdao.CommentsDelete(com_no);
		
		//�������н�
		if(result==false){
			System.out.println("��ۻ��� ����");
			return null;
			
		}
		//���� ������
		System.out.println("��ۻ��� ����");
		forward.setRedirect(true);
		forward.setPath("./sbBoardDetailAction.bo");
		return forward;
	}

}
