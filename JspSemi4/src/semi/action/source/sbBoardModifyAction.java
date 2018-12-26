package semi.action.source;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

public class sbBoardModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		ActionForward forward=new ActionForward();
		boolean result=false;
		//���޹��� �Ķ���� num ������ �����մϴ�.
		int num=Integer.parseInt(request.getParameter("sb_no"));
		BoardDAO boarddao=new BoardDAO();
		SourceBoardBean sb=new SourceBoardBean();
		
		//�۾��̸� ���� ����(ä������)
		
		try{
			//���� ���� ����
			sb.setSb_no(num);
			sb.setSb_title(request.getParameter("sb_title"));
			sb.setSb_content(request.getParameter("sb_content"));
			
			if(request.getParameter("sb_file").equals(""))
				sb.setSb_file(request.getParameter("sb_file_orig"));
			else
				sb.setSb_file(request.getParameter("sb_file"));

			//DAO���� �����޼��带 ȣ���Ͽ� ����
			result=boarddao.sbBoardModify(sb);
			
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
				"./sbBoardDetailAction.bo?num="+sb.getSb_no());
			return forward;
		}catch(Exception ex){
   			ex.printStackTrace();	 
	 }
		return null;
	}

}
