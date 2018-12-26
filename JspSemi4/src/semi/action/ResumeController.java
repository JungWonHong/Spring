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
		/*if (command.equals("/KHJobs.com")) { // 초기화면
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
		} else if(command.equals("/ApplyView.re")){ //채용게시판 상세뷰 - 버튼클릭시
			action = new ApplyViewAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/ApplyCompany.re")){ //채용게시판 상세뷰 - 버튼클릭시
			action = new ApplyCompanyAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/ResumeList.re")){ //회원마이페이지에서
			action = new ResumeListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/ResumeDetail.re")){ //이력서리스트에서
			action = new ResumeDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/ResumeDelete.re")){ //이력서디테일
			action = new ResumeDeleteAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
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
