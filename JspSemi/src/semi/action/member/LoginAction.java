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
		String memkind = request.getParameter("memkind"); //라디오박스 개인/기업 회원
		String id = request.getParameter("id"); //입력받은 ID
		String pass = request.getParameter("pass"); //입력받은 PW
		int result = 0;
				
		HttpSession session = request.getSession();
		String isE = ""; // 기업회원 여부
		if(memkind.equals("1")){ //개인회원 로그인시
			result = mdao.isPId(id, pass); //정보가 맞는지 체크
			if(id.equals("admin")){ //admin이 로그인 시
				isE = "E";
				session.setAttribute("isE", isE); //admin은 기업회원의 권한도 갖고있기 위해 'E'라는 값을 isE이름의 세션에 저장 
			}
			 session.setAttribute("isE", isE);
			 session.setAttribute("memkind", memkind);
		}else{ //기업회원 로그인시
			result = mdao.isEId(id, pass);
			isE = "E";
			session.setAttribute("isE", isE);
	        session.setAttribute("memkind", memkind);

		}
		System.out.println("결과는:" + result);
		String url = (String)session.getAttribute("movepage"); //로그인버튼을 누른 페이지 주소
		StringTokenizer st = new StringTokenizer(url, "/"); //  url의 값 : /*.com -> '/'를 제거한 값 
		String url2 = st.nextToken();
		 // 삽입이 된 경우
		if (result == 1) {
			// 로그인 성공
			session.setAttribute("id", id); // 로그인한 id 세션에 저장
			forward.setRedirect(false);
			//forward.setPath("." + url);
			forward.setPath(url2); // 로그인버튼을 누른 페이지로 이동
			return forward;
	      } else {
	            String message = "";
	          if(result == -1)
	             message = "아이디가 존재하지 않습니다.";
	          else
	             message = "비밀번호가 일치하지 않습니다.";
	          
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