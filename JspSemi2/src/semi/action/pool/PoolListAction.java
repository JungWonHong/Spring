package semi.action.pool;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.MemberDAO;
import semi.db.bean.PMemberBean;

public class PoolListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MemberDAO mdao = new MemberDAO();
		List<PMemberBean> poollist = new ArrayList<PMemberBean>();

		int poolpage = 1;
		int limit = 10;

		if (request.getParameter("poolpage") != null) {
			poolpage = Integer.parseInt(request.getParameter("poolpage"));
		}
		System.out.println("�Ѿ�� ������" + poolpage);

		int poollistcount = mdao.getPoolListCount(); // �� ����Ʈ ���� �޾ƿ�
		poollist = mdao.getPoolList(poolpage, limit); // �������� ����Ʈ�� ǥ���� �� ����
															// �Ķ���ͷ� �����Ͽ� �� �����
															// ���ͼ�
															// boardlist(List)
															// ��ü�� ����

		// �������� ��
		int poolmaxpage = (poollistcount + limit - 1) / limit;
		System.out.println("�� ������ �� = " + poolmaxpage);
		// ���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
		int poolstartpage = ((poolpage - 1) / 10) * 10 + 1;
		System.out.println("���� �������� ������ ���� ������ �� = " + poolstartpage);
		// ���� ����¡ ������ ������ ������ ��(10, 20, 30 ��...)
		int poolendpage = poolstartpage + 10 - 1;

		if (poolendpage > poolmaxpage)
			poolendpage = poolmaxpage;

		// �� ������ ������ request ��ü�� ����
		request.setAttribute("poolpage", poolpage);// ���� �������� ��
		request.setAttribute("poolmaxpage", poolmaxpage);// �ִ� �������� ��
		request.setAttribute("poolstartpage", poolstartpage);// ���� �������� ǥ���� ù �������� ��
		request.setAttribute("poolendpage", poolendpage);// ������������ ǥ���� �� ������ ��
		request.setAttribute("poollistcount", poollistcount);// �� ��
		request.setAttribute("poollist", poollist);

		forward.setPath("./semi/pool/pool_list.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
