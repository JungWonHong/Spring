package semi.action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.action.*;
import semi.db.MemberDAO;

public class LoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		request.setCharacterEncoding("euc-kr");
		String memkind = request.getParameter("memkind");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		int result = 0;
				
		HttpSession session = request.getSession();
		String isE = "";
		if(memkind.equals("1")){
			result = mdao.isPId(id, pass);
			if(id.equals("admin")){
				isE = "E";
				session.setAttribute("isE", isE);
			}
		}else{
			result = mdao.isEId(id, pass);
			isE = "E";
			session.setAttribute("isE", isE);
		}
		System.out.println("�����:" + result);
		String url = (String)session.getAttribute("movepage");
		 // ������ �� ���
		if (result == 1) {
			// �α��� ����
			session.setAttribute("id", id);
			forward.setRedirect(false);
			forward.setPath("." + url);
			return forward;
	      } else {
	            String message = "";
	          if(result == -1)
	             message = "���̵� �������� �ʽ��ϴ�.";
	          else
	             message = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
	          
	          response.setContentType("text/html; charset=euc-kr");
	          PrintWriter out = response.getWriter();
	          out.println("<script>");
	          out.println("alert('" + message + "');");
	          out.println("history.go(-1);");
	          out.println("</script>");
	          out.close();
	          return null;
	      }
	      
	   }

	}