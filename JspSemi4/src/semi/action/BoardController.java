package semi.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.recruit.*;
import semi.action.review.*;
import semi.action.source.*;
import semi.action.pool.*;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// "/JspProject/BoardList.bo" 반환됩니다.
		String RequestURI = request.getRequestURI();
		System.out.println("RequestURI2 = " + RequestURI);

		// contextPath는 "/JspProject"가 반환됩니다.
		String contextPath = request.getContextPath();
		System.out.println("contextPath2 = " + contextPath);

		// command는 "/BoardList.bo" 반환됩니다.
		String command = RequestURI.substring(contextPath.length());
		System.out.println("command2 = " + command);
		// 초기화
		ActionForward forward = null;
		Action action = null;
		HttpSession session = request.getSession();
		session.setAttribute("movepage", command);
		
		if (command.equals("/RecruitList.bo")) {
			action = new RecruitListAction();// 다형성에 의한 업캐스팅
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/RecruitDetailAction.bo")) {
			action = new RecruitDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/RecruitWrite.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/recruitboard/recruit_board_write.jsp");
		} else if (command.equals("/RecruitAddAction.bo")) {
			action = new RecruitAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/rvBoardList.bo")) {
			action = new rvBoardListAction();// 다형성에 의한 업캐스팅
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/rvBoardWrite.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/reviewboard/rvboard_write.jsp");
		} else if (command.equals("/rvBoardAddAction.bo")) {
			action = new rvBoardAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/rvBoardDetailAction.bo")) {
			action = new rvBoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/rvBoardModify.bo")) {
			action = new rvBoardModifyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/rvBoardModifyAction.bo")) {
			action = new rvBoardModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/rvBoardDelete.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/reviewboard/rvboard_delete.jsp");		
		} else if (command.equals("/rvBoardDeleteAction.bo")) {
			action = new rvBoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/rvBoardSearchAction.bo")) {
			action = new rvBoardSearchAction();// 다형성에 의한 업캐스팅
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		} else if (command.equals("/sbBoardList.bo")) {
			action = new sbBoardListAction();// 다형성에 의한 업캐스팅
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sbBoardAddAction.bo")) {
			action = new sbBoardAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sbBoardDetailAction.bo")) {
			action = new sbBoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sbBoardDelete.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/sourceboard/sbboard_delete.jsp");	
		} else if (command.equals("/sbBoardDeleteAction.bo")) {
			action = new sbBoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sbBoardModify.bo")) {
			action = new sbBoardModifyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sbBoardModifyAction.bo")) {
			action = new sbBoardModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sbBoardWrite.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/sourceboard/sbboard_write.jsp");
		} else if (command.equals("/sbBoardSearchAction.bo")) {
			action = new sbBoardSearchAction();// 다형성에 의한 업캐스팅
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		} else if (command.equals("/Pool.bo")) {
			action = new PoolListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/PoolView.bo")) {
			action = new PoolViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/eventBoard.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/rsseventboard/eventboard_rss.jsp");
		}

		if (forward != null) {
			if (forward.isRedirect()) { // 리다이렉트 됩니다.
				response.sendRedirect(forward.getPath());
			} else { // 포워딩 됩니다.
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
