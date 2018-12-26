package semi.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.resume.*;

@WebServlet("*.re")
public class ResumeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResumeController() {
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
		/*if (command.equals("/KHJobs.com")) { // �ʱ�ȭ��
			session.setAttribute("movepage", command);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./semi/main/MainForm.jsp");
		} else */
		if(command.equals("/ManageResume.re")){
			action = new ManageResumeAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/AddResume.re")){
			action = new AddResumeAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/ApplyView.re")){ //ä��Խ��� �󼼺� - ��ưŬ����
			action = new ApplyViewAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/ApplyCompany.re")){ //ä��Խ��� �󼼺� - ��ưŬ����
			action = new ApplyCompanyAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/ResumeList.re")){ //ȸ����������������
			action = new ResumeListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/ResumeDetail.re")){ //�̷¼�����Ʈ����
			action = new ResumeDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/ResumeDelete.re")){ //�̷¼�������
			action = new ResumeDeleteAction();
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
