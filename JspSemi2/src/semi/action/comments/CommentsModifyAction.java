package semi.action.comments;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.CommentsDAO;
import semi.db.bean.CommentsBean;

public class CommentsModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");

		int com_no = Integer.parseInt(request.getParameter("com_no"));
		boolean result = false;

		CommentsDAO cmtdao = new CommentsDAO();
		CommentsBean cmtdata = new CommentsBean();

		cmtdata.setCom_no(com_no);
		cmtdata.setCom_content(request.getParameter("cmtcontent"));

		// DAO���� �����޼��� ȣ���Ͽ� ����
		result = cmtdao.CommentsModify(cmtdata);

		// ��������
		if (result == false) {
			System.out.println("��� ���� ����");
			return null;
		}
		// ��������
		System.out.println("��� ���� �Ϸ�");

		PrintWriter out = response.getWriter();

		out.println("<script>");
		out.println("alert('�����Ϸ�');");
		out.println("self.close();");
		out.println("opener.location.reload();");
		out.println("</script>");

		return null;
	}

}
