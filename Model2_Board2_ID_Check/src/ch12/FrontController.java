package ch12;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.net")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
    	/*
    	 	��û�� ��ü URL�߿��� ��Ʈ ��ȣ ���� ���� ������ ���ڿ����� ��ȯ�˴ϴ�.
    	 	��) http://localhost:8088/JspProject/login.net�� ���
    	 	   "/JspProject/login.net" ��ȯ�˴ϴ�.
    	 */
    	String RequestURI = request.getRequestURI();
    	System.out.println("RequestURI2 = " + RequestURI);
    	
    	// getContextPath() : ���ؽ�Ʈ ��ΰ� ��ȯ�˴ϴ�.
    	// contextPath�� "/JspProject"�� ��ȯ�˴ϴ�.
    	String contextPath = request.getContextPath();
    	System.out.println("contextPath2 = " + contextPath);
    	
    	//RequestURI���� ���ؽ�Ʈ ��� ���� ���� �ε��� ��ġ�� ���ں���
    	//������ ��ġ ���ڱ��� �����մϴ�.
    	//command�� "/login.net" ��ȯ�˴ϴ�.
    	//String command = RequestURI.substring(contextPath.length(), RequestURI.length());
    	String command = RequestURI.substring(contextPath.length());
    	System.out.println("command = " + command);
    	
    	//�ʱ�ȭ
    	ActionForward forward = null;
    	Action action = null;
    	
    	if (command.equals("/login.net")) {
    		forward = new ActionForward();
    		forward.setRedirect(false); //�ּ� ������� jsp�������� ������ �����ݴϴ�.
    		forward.setPath("./jsp/loginForm.jsp");
    	} else if (command.equals("/join.net")) {
    		forward = new ActionForward();
    		forward.setRedirect(false); //�ּ� ������� jsp�������� ������ �����ݴϴ�.
    		forward.setPath("./jsp/joinForm.jsp");
    	} else if (command.equals("/joinProcess.net")) {
    		action = new JoinProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else if (command.equals("/loginProcess.net")) {
    		action = new LoginProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else if (command.equals("/logout.net")) {
    		action = new logoutAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else if (command.equals("/member_list.net")) {
    		action = new ListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else if (command.equals("/member_info.net")) {
    		action = new Member_infoAction();
    		try {
    			forward = action.execute(request, response); //request���� id���� �޾ƿ�
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else if (command.equals("/member_delete.net")) {
    		action = new Member_deleteAction();
    		try {
    			forward = action.execute(request, response); //request���� id���� �޾ƿ�
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else if (command.equals("/Idcheckajax.net")){
    		action = new Idcheckajax();
    		try {
    			forward = action.execute(request, response); //request���� id���� �޾ƿ�
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if (forward != null) {
    		if(forward.isRedirect()) { //�����̷�Ʈ �˴ϴ�.
    			response.sendRedirect(forward.getPath());
    		} else { //������ �˴ϴ�.
    			RequestDispatcher dispatcher = 
    					request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    }
    
    //doProcess(request, response)�ޤõ带 �����Ͽ� ��û�� GET����̵�
    //POST������� ���۵Ǿ� ���� ���� �޼��忡�� ��û�� ó���� �� �ֵ��� �Ͽ����ϴ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
