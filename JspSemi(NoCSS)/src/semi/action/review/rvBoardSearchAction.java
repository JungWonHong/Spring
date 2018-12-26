package semi.action.review;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.action.*;
import semi.db.*;
import semi.db.bean.*;

public class rvBoardSearchAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boarddao=new BoardDAO();
		ArrayList<ReviewBoardBean> boardlist=new ArrayList<ReviewBoardBean>();
		request.setCharacterEncoding("euc-kr");
		String keyField=(String)request.getParameter("keyField");
		String keyWord=(String)request.getParameter("keyWord");
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("�Ѿ�� ������"+page);
		
		int listcount=boarddao.rvSearchListCount(keyField, keyWord); //�� ����Ʈ ���� �޾ƿ�
		boardlist=boarddao.rvSearchBoardList(keyField, keyWord, page, limit); //�������� ����Ʈ�� ǥ���� �� ���� �Ķ���ͷ� �����Ͽ� �� ����� ���ͼ�
														//boardlist(List) ��ü�� ����
		
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
	     request.setAttribute("keyWord", keyWord);
	     request.setAttribute("keyField", keyField);
	     
	     ActionForward forward=new ActionForward();
	     forward.setRedirect(false);
	     forward.setPath("./semi/reviewboard/rvboard_result.jsp");
	     return forward;
	}
}
