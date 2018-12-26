package _9.ServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context")
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		//현재 페이지가 소속된 웹 애플리케이션의 ServletContext객체를 구해옵니다.
		ServletContext sc = this.getServletContext();
		//ServletContext sc = request.getSession().getServletContext();
		
		//getMajorVersion() : 현재 WAS에서 지원하고 있는 서블릿의 Major 버전정보를 반환합니다.
		//getMinorVersion() : 현재 WAS에서 지원하고 있는 서블릿의 Minor 버전정보를 반환합니다.
		out.print("서블릿 버전 : " + sc.getMajorVersion() + "." 
								+ sc.getMinorVersion() + "<br>");
		
		//현재 사용중인 서블릿 컨테이너의 이름과 버전 정보를 반환합니다.
		out.print("서버 정보 : " + sc.getServerInfo() + "<br>");
		
		//getContextPath() : 웹 애플리케이션을 찾아가기 위해 사용하는 경로를 반환합니다.
		out.print("웹 애플리케이션 경로 : " + sc.getContextPath() + "<br>");
		
		//getServletContextName() : web.xml의 <display-name> 태그 사이의
		//값을 추출하는 메서드 입니다.
		out.print("웹 애플리케이션 이름 : " + sc.getServletContextName() + "<br>");
		
		//콘솔 창에 나타납니다.
		sc.log("로그 기록");
		
		out.close();
	}
}
