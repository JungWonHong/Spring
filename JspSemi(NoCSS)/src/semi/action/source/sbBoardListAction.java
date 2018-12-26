package semi.action.source;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.*;
import semi.db.bean.SourceBoardBean;

public class sbBoardListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boarddao=new BoardDAO();
		List<SourceBoardBean> boardlist=new ArrayList<SourceBoardBean>();
		
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("�Ѿ�� ������"+page);
		
		int listcount=boarddao.sbgetListCount(); //�� ����Ʈ ���� �޾ƿ�
		boardlist=boarddao.sbgetBoardList(page, limit); //�������� ����Ʈ�� ǥ���� �� ���� �Ķ���ͷ� �����Ͽ� �� ����� ���ͼ�
														//boardlist(List) ��ü�� ����
		//boardlist
		
		//�������� ��
		 int maxpage = (listcount + limit - 1) / limit;
	     System.out.println("�� ������ �� = " + maxpage);
	     //���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
	     int startpage = ((page - 1) / 10) * 10 + 1;
	     System.out.println("���� �������� ������ ���� ������ �� = " + startpage);
	     //���� ����¡ ������ ������ ������ ��(10, 20, 30 ��...)
	     int endpage=startpage+10-1;
	     
	     if(endpage>maxpage) endpage=maxpage;
	     
	     //�� ������ ������ request ��ü�� ����
	     request.setAttribute("page", page);//���� �������� ��
	     request.setAttribute("maxpage", maxpage);//�ִ� �������� ��
	     request.setAttribute("startpage", startpage);//���� �������� ǥ���� ù �������� ��
	     request.setAttribute("endpage", endpage);//������������ ǥ���� �� ������ ��
	     request.setAttribute("listcount", listcount);//�� ��
	     request.setAttribute("boardlist", boardlist);
	     ActionForward forward=new ActionForward();
	     forward.setRedirect(false);
	     forward.setPath("./semi/sourceboard/sbboard_list.jsp");
	     return forward;
	}
}
