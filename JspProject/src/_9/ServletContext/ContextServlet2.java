package _9.ServletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//1. 크롬에서 실행
//	 http://localhost://8088/JspProject/ch3/_9.context/context
//2. 크롬을 제외한 다른 브라우저에서 실행
//	 http://localhost://8088/JspProject/ch3/_9.context/scope.jsp
@WebServlet("/ch3/_9.context/context")
public class ContextServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		
		//현재 페이지가 소속된 웹 애플리케이션의 ServletContext객체를 구해옵니다.
		ServletContext sc = this.getServletContext();
		//ServletContext sc = request.getSession().getServletContext();
		
		HttpSession session = request.getSession();
		request.setAttribute("food", "과자1"); 
		session.setAttribute("food", "과자2");
		sc.setAttribute("food", "과자3");
		response.sendRedirect("scope.jsp"); 
		//새로운 요청이 들어옴 request는 새로운 객체가 되기때문에 null
		//request는 프로그램이 종료되기 전까지 살아있는 정보
		//session은 브라우저 단위로 웹브라우저가 종료하기전까지 살아있는 정보
		//ServletContext는 서버가 중지하기전까지는 살아있는 정보
	}
}
