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
 * 한글 처리 get 방식 1-1
 * server.xml을 수정해서 get방식으로 전송되어 오는 파라미터들의 캐릭터 셋을 한 번에
 * 수정하는 방법
 * connector태그의 URIEncoding="euc-kr"
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
 * 한글 처리 get 방식 1-2
 * server.xml을 수정해서 get방식으로 전송되어 오는 파라미터들의 캐릭터 셋을 한 번에
 * 수정하는 방법
 * connector태그의 useBodyEncodingForURI="true"
 * 서블릿에서 파라미터 값 받기 전에 request.setCharacterEncoding("euc-kr"); 추가하기
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
 * 한글 처리 post 방식
 * 서블릿에서 파라미터 값 받기 전에
 * request.setCharacterEncoding("euc-kr");
 * 추가하기
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
