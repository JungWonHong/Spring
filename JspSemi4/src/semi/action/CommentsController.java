package semi.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.comments.CommentsAddAction;
import semi.action.comments.CommentsDeleteAction;
import semi.action.comments.CommentsListAction;
import semi.action.comments.CommentsModifyAction;
import semi.action.comments.CommentsModifyView;

@WebServlet("*.co")
public class CommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentsController() {
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
		if (command.equals("/CommentsList.co")) {
			action = new CommentsListAction(); // 다형성에 의한 업캐스팅
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/CommentsWrite.co")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/comments/Comments_Write.jsp");
		} else if (command.equals("/CommentsAddAction.co")) {
			action = new CommentsAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/CommentsDelete.co")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/comments/Comments_Delete.jsp");
		} else if (command.equals("/CommentsDeleteAction.co")) {
			action = new CommentsDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/CommentsModify.co")) {
			action = new CommentsModifyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/CommentsModifyAction.co")) {
			action = new CommentsModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
