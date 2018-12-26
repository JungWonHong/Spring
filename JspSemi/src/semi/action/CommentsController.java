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
		// "/JspProject/BoardList.bo" ��ȯ�˴ϴ�.
		String RequestURI = request.getRequestURI();
		System.out.println("RequestURI2 = " + RequestURI);

		// contextPath�� "/JspProject"�� ��ȯ�˴ϴ�.
		String contextPath = request.getContextPath();
		System.out.println("contextPath2 = " + contextPath);

		// command�� "/BoardList.bo" ��ȯ�˴ϴ�.
		String command = RequestURI.substring(contextPath.length());
		System.out.println("command2 = " + command);
		// �ʱ�ȭ
		ActionForward forward = null;
		Action action = null;
		HttpSession session = request.getSession();
		session.setAttribute("movepage", command);
		if (command.equals("/CommentsList.co")) {
			action = new CommentsListAction(); // �������� ���� ��ĳ����
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
			if (forward.isRedirect()) { // �����̷�Ʈ �˴ϴ�.
				response.sendRedirect(forward.getPath());
			} else { // ������ �˴ϴ�.
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
