//�� ���� ó�� Action Ŭ����
package net.board.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.board.db.*;

 public class BoardModifyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,
			                      HttpServletResponse response) 
	 	throws Exception{
		 request.setCharacterEncoding("utf-8");
		 ActionForward forward = new ActionForward();
		 boolean result = false;
		 
		 //���޹��� �Ķ���� num ������ �����մϴ�.
		 int num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		 String page = request.getParameter("page");
		 String pass = request.getParameter("BOARD_PASS");
		 
		 BoardDAO_max boarddao=new BoardDAO_max();
		 BoardBean boarddata=new BoardBean();
		 
		 //�۾��� ���� Ȯ���ϱ� ���� ����� ��й�ȣ�� �Է��� ��й�ȣ�� ���մϴ�.
		 boolean usercheck=boarddao.isBoardWriter(num, pass);
		 //��й�ȣ�� �ٸ� ���
		 if(usercheck==false){
		   		response.setContentType("text/html;charset=utf-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('������ ������ �����ϴ�.');");
		   		//out.println("location.href='./BoardList.bo';");
		   		out.println("history.go(-1)");
		   		out.println("</script>");
		   		out.close();
		   		return null;
		 }
		 //��й�ȣ�� ��ġ�ϴ� ���
		 try{
			 //���� ������ �����մϴ�.
			 boarddata.setBOARD_NUM(num);
			 boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			 boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
			 
			 //DAO���� ���� �޼��� ȣ���Ͽ� �����մϴ�.
			 result = boarddao.boardModify(boarddata);
			 //������ ������ ���
			 if(result==false){
		   		System.out.println("�Խ��� ���� ����");
		   		return null;
		   	 }
			 //���� ������ ���
		   	 System.out.println("�Խ��� ���� �Ϸ�");
		   	 
		   	 forward.setRedirect(true);
		   	 //������ �� ������ �����ֱ� ���� �� ���� ���� ���� �������� �̵��ϱ����� ��θ� �����մϴ�.
		   	 forward.setPath(
		   	   "./BoardDetailAction.bo?num="+boarddata.getBOARD_NUM() + "&page=" + page);
		   	 return forward;
	   	 }catch(Exception ex){
	   			ex.printStackTrace();	 
		 }
		 return null;
	 }
}