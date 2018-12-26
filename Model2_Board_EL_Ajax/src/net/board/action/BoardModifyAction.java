//글 수정 처리 Action 클래스
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
		 
		 //전달받은 파라미터 num 변수에 저장합니다.
		 int num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		 String page = request.getParameter("page");
		 String pass = request.getParameter("BOARD_PASS");
		 
		 BoardDAO boarddao=new BoardDAO();
		 BoardBean boarddata=new BoardBean();
		 
		 //글쓴이 인지 확인하기 위해 저장된 비밀번호와 입력한 비밀번호를 비교합니다.
		 boolean usercheck=boarddao.isBoardWriter(num, pass);
		 //비밀번호가 다른 경우
		 if(usercheck==false){
		   		response.setContentType("text/html;charset=utf-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('수정할 권한이 없습니다.');");
		   		//out.println("location.href='./BoardList.bo';");
		   		out.println("history.go(-1)");
		   		out.println("</script>");
		   		out.close();
		   		return null;
		 }
		 //비밀번호가 일치하는 경우
		 try{
			 //수정 내용을 설정합니다.
			 boarddata.setBOARD_NUM(num);
			 boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			 boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
			 
			 //DAO에서 수정 메서드 호출하여 수정합니다.
			 result = boarddao.boardModify(boarddata);
			 //수정에 실패한 경우
			 if(result==false){
		   		System.out.println("게시판 수정 실패");
		   		return null;
		   	 }
			 //수정 성공의 경우
		   	 System.out.println("게시판 수정 완료");
		   	 
		   	 forward.setRedirect(true);
		   	 //수정한 글 내용을 보여주기 위해 글 내용 보기 보기 페이지로 이동하기위해 경로를 설정합니다.
		   	 forward.setPath(
		   	   "./BoardDetailAction.bo?num="+boarddata.getBOARD_NUM() + "&page=" + page);
		   	 return forward;
	   	 }catch(Exception ex){
	   			ex.printStackTrace();	 
		 }
		 return null;
	 }
}