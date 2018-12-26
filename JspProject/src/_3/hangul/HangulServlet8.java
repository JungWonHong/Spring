package _3.hangul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ch3/_3.hangul/hangul8")
public class HangulServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HangulServlet8() {
        super();
    }
/*
 * �ѱ� ó�� get ��� 1-1
 * server.xml�� �����ؼ� get������� ���۵Ǿ� ���� �Ķ���͵��� ĳ���� ���� �� ����
 * �����ϴ� ���
 * connector�±��� URIEncoding="euc-kr"
 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		String name = request.getParameter("name");
		String korName = name;

		PrintWriter out = response.getWriter();

		out.println("original = " + name + "<br>");
		
		out.println("hangulProcess = " + korName);
		out.close();
	}*/
/*
 * �ѱ� ó�� get ��� 1-2
 * server.xml�� �����ؼ� get������� ���۵Ǿ� ���� �Ķ���͵��� ĳ���� ���� �� ����
 * �����ϴ� ���
 * connector�±��� useBodyEncodingForURI="true"
 * �������� �Ķ���� �� �ޱ� ���� request.setCharacterEncoding("euc-kr"); �߰��ϱ�
 */	
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		String korName = name;

		PrintWriter out = response.getWriter();

		out.println("original = " + name + "<br>");
		
		out.println("hangulProcess = " + korName);
		out.close();
	}*/
    
/*
 * �ѱ� ó�� post ���
 * �������� �Ķ���� �� �ޱ� ����
 * request.setCharacterEncoding("euc-kr");
 * �߰��ϱ�
 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	response.setContentType("text/html;charset=euc-kr");
    	request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		String korName = name;

		PrintWriter out = response.getWriter();

		out.println("original = " + name + "<br>");
		out.println("hangulProcess = " + korName);
		out.close();
	}
}
