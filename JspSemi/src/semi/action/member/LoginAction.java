package semi.action.member;

import java.io.PrintWriter;
import java.util.StringTokenizer;

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
		String memkind = request.getParameter("memkind"); //�����ڽ� ����/��� ȸ��
		String id = request.getParameter("id"); //�Է¹��� ID
		String pass = request.getParameter("pass"); //�Է¹��� PW
		int result = 0;
				
		HttpSession session = request.getSession();
		String isE = ""; // ���ȸ�� ����
		if(memkind.equals("1")){ //����ȸ�� �α��ν�
			result = mdao.isPId(id, pass); //������ �´��� üũ
			if(id.equals("admin")){ //admin�� �α��� ��
				isE = "E";
				session.setAttribute("isE", isE); //admin�� ���ȸ���� ���ѵ� �����ֱ� ���� 'E'��� ���� isE�̸��� ���ǿ� ���� 
			}
			 session.setAttribute("isE", isE);
			 session.setAttribute("memkind", memkind);
		}else{ //���ȸ�� �α��ν�
			result = mdao.isEId(id, pass);
			isE = "E";
			session.setAttribute("isE", isE);
	        session.setAttribute("memkind", memkind);

		}
		System.out.println("�����:" + result);
		String url = (String)session.getAttribute("movepage"); //�α��ι�ư�� ���� ������ �ּ�
		StringTokenizer st = new StringTokenizer(url, "/"); //  url�� �� : /*.com -> '/'�� ������ �� 
		String url2 = st.nextToken();
		 // ������ �� ���
		if (result == 1) {
			// �α��� ����
			session.setAttribute("id", id); // �α����� id ���ǿ� ����
			forward.setRedirect(false);
			//forward.setPath("." + url);
			forward.setPath(url2); // �α��ι�ư�� ���� �������� �̵�
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