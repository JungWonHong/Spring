package _1.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * jsp 2.2는 서블릿 설정이 web.xml보다는 Annotation(주석-특별한 의미 부여)
      기반으로 제공합니다.
 * @WebServlet 애노테이션은 urlPattern 속성을 값으로 갖는데 이 속성은
      해당 서블릿과 매핑될 URL 패턴을 지정할 때 사용됩니다.
      아래의 경우 '/ch3/_1.login/login'로 들어오는 URL을
   LoginServlet이 처리하도록 설정하고 있습니다.
   web.xml 파일에 별도의 설정을 하지 않더라도 LoginServlet을 실행할 수 있게 됩니다.
 */
@WebServlet(urlPatterns = "/ch3/_1.login/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//응답하는 데이터 타입이 html타입이고 charset=euc-kr로 지정하면서 
		//응답되는 데이터들의 한글 처리를 한 부분입니다. 
		response.setContentType("text/html;charset=euc-kr");
		
		//getContextPath() : 웹 애플리케이션 경로 정보를 반환합니다.
		//URL에서 포트번호와 슬래피 다음 웹 애플리케이션 이름을 지정합니다.
		//이 값을 추출하는 메소드 입니다.
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//getParameter() 메서드 : name으로 전송되어 온 파라미터 값을 반환해 주는 메서드
		//클라이언트에서 전송되어 오는 id라는 이름의 파라미터 값과
		//passwd라는 이름의 파라미터 값을 받는 부분입니다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//문자열 단위로 response객체에 내용을 출력할 수 있는 출력 스트림을 생성한 부분입니다.
		PrintWriter out = response.getWriter();
		
		//응답에 id변수 값과 passwd변수 값을 출력하는 부분입니다.
		out.println("<br>" + "아이디=" + id + "<br>");
		out.println("비밀번호=" + passwd + "<br>");
		out.close();
	}
}
