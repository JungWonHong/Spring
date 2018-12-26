package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFrontController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
    	/*
	 	요청된 전체 URL중에서 포트 번호 다음 부터 마지막 문자열까지 반환됩니다.
	 	예) http://localhost:8088/JspProject/BoardList.bo인 경우
	 	   "/JspProject/BoardList.bo" 반환됩니다.
    	 */
    	String RequestURI = request.getRequestURI();
    	System.out.println("RequestURI2 = " + RequestURI);
    	
    	// getContextPath() : 컨텍스트 경로가 반환됩니다.
    	// contextPath는 "/JspProject"가 반환됩니다.
    	String contextPath = request.getContextPath();
    	System.out.println("contextPath2 = " + contextPath);
    	
    	//RequestURI에서 컨텍스트 경로 길이 값의 인덱스 위치의 문자부터
    	//마지막 위치 문자까지 추출합니다.
    	//command는 "/BoardList.bo" 반환됩니다.
    	String command = RequestURI.substring(contextPath.length());
    	System.out.println("command2 = " + command);
    	System.out.println("들어옴");
    	//초기화
    	ActionForward forward = null;
    	Action action = null;
    	
		if (command.equals("/BoardList.bo")) {
			action = new BoardListAction();// 다형성에 의한 업캐스팅
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardWrite.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./ch14/_1.Model2/board/qna_board_write.jsp");
		} else if (command.equals("/BoardAddAction.bo")) {
			action = new BoardAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardReplyAction.bo")) {
			action = new BoardReplyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardDelete.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./ch14/_1.Model2/board/qna_board_delete.jsp");
		} else if (command.equals("/BoardModify.bo")) {
			action = new BoardModifyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardReplyView.bo")) {
			action = new BoardReplyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardModifyAction.bo")) {
			action = new BoardModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardDeleteAction.bo")) {
			action = new BoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardDetailAction.bo")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    	
    	if (forward != null) {
    		if(forward.isRedirect()) { //리다이렉트 됩니다.
    			response.sendRedirect(forward.getPath());
    		} else { //포워딩 됩니다.
    			RequestDispatcher dispatcher = 
    					request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
