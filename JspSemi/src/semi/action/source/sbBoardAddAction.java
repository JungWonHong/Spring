package semi.action.source;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import semi.action.Action;
import semi.action.ActionForward;
import semi.db.*;
import semi.db.bean.SourceBoardBean;

public class sbBoardAddAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO boarddao=new BoardDAO();
		SourceBoardBean sb=new SourceBoardBean();
		ActionForward forward=new ActionForward();
		
		String realFolder="";
		String saveFolder="boardupload";
		int fileSize=5*1024*1024;
		
		//���� ���� ��� ����
		ServletContext sc=request.getServletContext();
		realFolder=sc.getRealPath(saveFolder);
		System.out.println("realFolder="+realFolder);
		boolean result=false;
		
		try{
			MultipartRequest multi=null;
			multi=new MultipartRequest(request, realFolder, fileSize, "euc-kr", new DefaultFileRenamePolicy());
			sb.setSb_id(multi.getParameter("id"));
			sb.setSb_title(multi.getParameter("sb_title"));
			sb.setSb_content(multi.getParameter("sb_content"));
			
			//���ε��� ���ϸ��� ���ε��� ������ ��ü ��ο��� ���� �̸��� ����
			sb.setSb_file(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			
			result=boarddao.sbboardInesrt(sb);
			
			if(result==false){
				System.out.println("�Խ��� ��� ����");
				return null;
			}
			System.out.println("�Խ��� ��� �Ϸ�");
			
			forward.setRedirect(true);
			forward.setPath("./sbBoardList.bo");
			return forward;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
