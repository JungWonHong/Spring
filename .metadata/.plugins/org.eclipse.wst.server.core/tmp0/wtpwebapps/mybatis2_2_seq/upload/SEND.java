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

      out.println("���̵� = " + id + "<br>");
      out.println("��й�ȣ = " + pass + "<br>");
      out.println("�ֹι�ȣ = " + jumin1 + "-" + jumin2 + "<br>");
      
      //�������� ������ ���  ��ȿ�� �˻翡��
      //$('#domain').attr("disabled", "disabled");�� ��Ȱ��ȭ�� ���״�.
      //��Ȱ���� ��� ������ �� ������ �̷������ �ʴ´�.
      //�ּ�â�� Ȯ���� ���� �������� ������ ��� domain�� ���۵��� �ʰ� sel�� ���۵ȴ�.
      //���� �Է��� ��쿡�� domain�� ���� ����Ǿ� ���۵ǰ� sel�� ���� ���� ���·� ���۵ȴ�.
      if(sel.equals("")) //���� �Է��� ���
         out.println("e-mail = " + email + "@" + domain + "<br>");
      else
         out.println("e-mail = " + email + "@" + sel + "<br>");
      
      if(gender.equals("m"))
         out.println("���� = ����<br>");
      else
         out.println("���� = ����<br>");
      
      for(int num=0; num<hobby.length; num++){
      out.println("��� = " + hobby[num] + "<br>");
      }
      
      out.println("�����ȣ  = " + post1 + "-" + post2 + "<br>");
      out.println("�ּ� = " + address + "<br>");
      out.println("�ڱ�Ұ� = " + intro);
      
   }

}