package _2.mem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ch3/_2.mem/memReg")
public class MemRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemRegServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");

		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");

		PrintWriter out = response.getWriter();

		out.println("회원명 = " + name + "<br>");
		out.println("주소 = " + addr + "<br>");
		out.println("전화번호 = " + tel + "<br>");
		out.println("취미 = " + hobby + "<br>");
		out.close();
	}
}
