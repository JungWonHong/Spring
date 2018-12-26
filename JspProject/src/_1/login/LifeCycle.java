package _1.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @은 annotation으로 자바 주석문처럼 소스안에 @기호와 함께 사용됩니다.
 * 주석문처럼 컴파일러에 정보를 알려주는 기능 또는 자바 프로그램 실행에 관한 내용을 설정하는
 * 용도로 사용됩니다.
 * @WebServlet 설정을 통한 서블릿 접근 방법은 서블릿 3.0부터 지원합니다.
   /LifeCycle2의 의미는
   "http://localhost:8088/JspProject/LifeCycle2"로 요청이 들어오면
       실행할 서블릿이라는 의미 입니다.
 */
@WebServlet("/LifeCycle2")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycle() {
    	System.out.println("저는 생성자 입니다.~~");
    }

    /*
     * 콜백 메소드(callback method) - 어떤 객체에서 어떤 상황이 발생하면
     * 컨테이너가 자동으로 호출하여 실행되는 메소드를 의미합니다.
     * 이런 콜백 메소드들이 서블릿을 실행합니다.
     * - init(), service(), destroy()
     *   init()->service()->destroy()
     */
    // init()메소드는 서블릿 객체가 생성된 다음에 호출되는 메소드로 클라이언트로부터
    // 최초로 서블릿 요청이 있을 때 한 번 실행됩니다.
    // 서블릿 초기화 작업에 사용됩니다.
    public void init() throws ServletException{
    	System.out.println("저는 init() 입니다.");
    }
    
    //이 메서드의 출력 결과를 보기 위해서는 이 파일을 수정한 뒤 저장하고 콘솔을 바라보며
    //잠시 기다려 보세요.
    //또는 서버를 중지 해 보세요
    //서블릿 객체가 메모리에서 삭제될 때 실행됩니다 - 자원 해제 작업 등에 사용됩니다.
    public void destroy(){
    	System.out.println("저는 destroy() 입니다.");
    }
    
    //클라이언트의 요청이 있을 때마다 실행됩니다.
    //service()메소드가 끝나면 서버에서의 실행은 끝납니다.
    //서버 프로그램 실행이 완료된 후에는 서블릿 컨테이너가 실행결과를 웹 서버에 전달하고
    //웹 서버는 서비스를 요청한 클라이언트에 응답합니다.
    //이로써 웹에서 하나의 요청에 대한 처리가 완료됩니다.
    //브라우저에서 새로고침을 해보세요
    public void service(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException{
    	System.out.println("저는 service() 입니다. ~");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
