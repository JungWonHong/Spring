package semi.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.member.*;

@WebServlet("*.com")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		System.out.println("RequestURI2 = " + RequestURI);

		String contextPath = request.getContextPath();
		System.out.println("contextPath2 = " + contextPath);

		String command = RequestURI.substring(contextPath.length());
		System.out.println("command2 = " + command);

		ActionForward forward = null;
		Action action = null;
		HttpSession session = request.getSession();
		if (command.equals("/KHJobs.com")) { // �ʱ�ȭ��
			session.setAttribute("movepage", command);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/main/MainForm.jsp");
		} else if (command.equals("/login.com")) { // �α��ι�ư �������
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/member/Login.jsp");
		} else if (command.equals("/loginProcess.com")) {// �α��ΰ���
			action = new LoginAction(); // ȸ�������� ���� DB�� �� �α��� ó��
			try { // �����ڸ� �����ڿ� ȭ��, ȸ�������� ȭ������ �̵��ϰ�
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/pjoin.com")) { // ����ȸ�����Թ�ư �������
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/member/PMemberJoin.jsp");
		} else if (command.equals("/pjoinProcess.com")) {
			action = new PJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/ejoin.com")) { // ���ȸ�����Թ�ư �������
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/member/EMemberJoin.jsp");
		} else if (command.equals("/ejoinProcess.com")) {
			action = new EJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/MemberIdCheckAction.com")) {
			action = new MemberIdCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Logout.com")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/member/Logout.jsp");
		} else if (command.equals("/PMyPage.com")) {
			action = new PinfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/EMyPage.com")) {
			action = new EinfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/PModifyView.com")) {
			action = new PModifyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/PModifyAction.com")) {
			action = new PModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/EModifyView.com")) {
			action = new EModifyView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/EModifyAction.com")) {
			action = new EModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/PDelete.com")) {
			action = new PMemberDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/EDelete.com")) {
			action = new EMemberDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/PDeleteCheck.com")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/member/PDeleteCheck.jsp");
		} else if (command.equals("/EDeleteCheck.com")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/member/EDeleteCheck.jsp");
		} else if(command.equals("/adminMemberList.com")){
			action = new infoAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/adminPinfo.com")){
			/*������ ���� -
			 * ����ȸ�� �⺻���� �ѷ��ִ� �κ�*/
			action = new adminPInfoAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/adminEinfo.com")){
			/*������ ���� -
			 * ���ȸ�� �⺻���� �ѷ��ִ� �κ�*/
			action = new adminEInfoAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
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
