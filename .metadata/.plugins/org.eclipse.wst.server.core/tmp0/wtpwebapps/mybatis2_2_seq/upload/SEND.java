package Homework;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch4_jsp/_2.include/send")
public class SEND extends HttpServlet {
   private static final long serialVersionUID = 1L;
     
    public SEND() {
        super();

    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html; charset=euc-kr");
      PrintWriter out = response.getWriter();
      String id = request.getParameter("id");
      String pass = request.getParameter("pass");
      String jumin1 = request.getParameter("jumin1");
      String jumin2 = request.getParameter("jumin2");
      String email = request.getParameter("email");
      String sel = request.getParameter("sel");
      String domain = request.getParameter("domain");
      String gender = request.getParameter("gender");
      String[] hobby = request.getParameterValues("hobby");
      String post1 = request.getParameter("post1");
      String post2 = request.getParameter("post2");
      String address = request.getParameter("address");
      String intro = request.getParameter("intro");

      out.println("아이디 = " + id + "<br>");
      out.println("비밀번호 = " + pass + "<br>");
      out.println("주민번호 = " + jumin1 + "-" + jumin2 + "<br>");
      
      //도메인을 선택한 경우  유효성 검사에서
      //$('#domain').attr("disabled", "disabled");로 비활성화를 시켰다.
      //비활성된 경우 서버로 값 전송이 이루어지지 않는다.
      //주소창을 확인해 보면 도메인을 선택한 경우 domain은 전송되지 않고 sel만 전송된다.
      //직접 입력한 경우에는 domain은 값이 저장되어 전송되고 sel은 값이 없는 상태로 전송된다.
      if(sel.equals("")) //직접 입력한 경우
         out.println("e-mail = " + email + "@" + domain + "<br>");
      else
         out.println("e-mail = " + email + "@" + sel + "<br>");
      
      if(gender.equals("m"))
         out.println("성별 = 남자<br>");
      else
         out.println("성별 = 여자<br>");
      
      for(int num=0; num<hobby.length; num++){
      out.println("취미 = " + hobby[num] + "<br>");
      }
      
      out.println("우편번호  = " + post1 + "-" + post2 + "<br>");
      out.println("주소 = " + address + "<br>");
      out.println("자기소개 = " + intro);
      
   }

}