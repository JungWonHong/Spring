/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.44
 * Generated at: 2017-08-04 00:40:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.semi.reviewboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.SimpleDateFormat;
import semi.db.bean.*;
import semi.db.*;

public final class rvboard_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("semi.db.bean");
    _jspx_imports_packages.add("semi.db");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
	
	String id=(String)session.getAttribute("id");
	List boardList=(ArrayList)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();

      out.write("    \r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Review 게시판</title>\r\n");
      out.write("<link href=\"./css/board.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"./css/top.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Header.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../menubar.jsp", out, false);
      out.write("\r\n");
      out.write("<!-- 게시판 리스트 -->\r\n");
      out.write("<table width=570 border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t<tr align=\"center\" valign=\"middle\">\r\n");
      out.write("\t\t<td colspan=\"4\">현장의 소리</td>\r\n");
      out.write("\t\t<td align=right>\r\n");
      out.write("\t\t\t<font size=2>글 개수 : ");
      out.print(listcount );
      out.write("</font>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th  width=\"8%\">\r\n");
      out.write("\t\t\t<div>번호</div>\r\n");
      out.write("\t\t</th>\r\n");
      out.write("\t\t<th width=\"50%\">\r\n");
      out.write("\t\t\t<div>제목</div>\r\n");
      out.write("\t\t</th>\r\n");
      out.write("\t\t<th width=\"14%\">\r\n");
      out.write("\t\t\t<div>글쓴이</div>\r\n");
      out.write("\t\t</th>\r\n");
      out.write("\t\t<th width=\"17%\">\r\n");
      out.write("\t\t\t<div>작성일</div>\t\r\n");
      out.write("\t\t</th>\r\n");
      out.write("\t\t<th width=\"11%\">\r\n");
      out.write("\t\t\t<div>조회수</div>\r\n");
      out.write("\t\t</th>\t\r\n");
      out.write("\t</tr>\t\t\r\n");
      out.write('\r');
      out.write('\n');

	//boardList 객체에는 현재 페이지의 글 목록이 저장되어있으며, 저장된 글 목록만큼 
	//for문을 돌려서 boardList에 있는 글들을 하나씩 BoardBean 객체에 담아오고
	//각각의 속성 값을 출력한다.
	for(int i=0; i<boardList.size(); i++){
		ReviewBoardBean rv=(ReviewBoardBean)boardList.get(i);

      out.write("\r\n");
      out.write("\t<tr align=\"center\" valign=\"middle\"\r\n");
      out.write("\t\tonmouseover=\"this.style.backgroundColor='F8F8F8'\"\t\t\r\n");
      out.write("\t\tonmouseout=\"this.style.backgroundColor=''\">\r\n");
      out.write("\t\t<td>");
      out.print(rv.getRv_no() );
      out.write("</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t<a href=\"./rvBoardDetailAction.bo?num=");
      out.print(rv.getRv_no());
      out.write("\">\r\n");
      out.write("\t\t\t\t");
      out.print(rv.getRv_title() );
      out.write("\r\n");
      out.write("\t\t\t</a>\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div>");
      out.print(rv.getRv_id() );
      out.write("</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div>");
      out.print(rv.getRv_date() );
      out.write("</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<div>");
      out.print(rv.getRv_count() );
      out.write("</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\t\r\n");

	}

      out.write("\r\n");
      out.write("\t<tr align=center height=20>\r\n");
      out.write("\t\t<td colspan=7>\r\n");
      out.write("\t\t\t<!-- 현재 페이지가 1일 경우 [이전]을 표시할 때 링크를 걸지 않는다. 현재 위치한 페이지가 2이상일 경우만\r\n");
      out.write("\t\t\t이전 페이지로 돌아갈 수 있으므로, 현재 페이지 값이 1일 때에는 링크할 필요가 없다. -->\r\n");
      out.write("\t\t\t");
if(nowpage<=1){ 
      out.write("\r\n");
      out.write("\t\t\t[이전]&nbsp;\r\n");
      out.write("\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t<a href=\"./rvBoardList.bo?page=");
      out.print(nowpage-1 );
      out.write("\">[이전]</a>&nbsp;\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t<!-- 해당 페이지 그룹의 시작 페이지부터 마지막 페이지까지 for문을 돌린다. -->\r\n");
      out.write("\t\t\t");
for(int a=startpage; a<=endpage; a++){ 
				//표시할 이동 가능한 페이지 중 현재 페이지는 링크를 걸지 않고 표시.
				if(a==nowpage){
      out.write("\r\n");
      out.write("\t\t\t\t\t<b>[");
      out.print(a );
      out.write("]</b>\r\n");
      out.write("\t\t\t\t<!-- 현재페이지를 제외한 나머지 이동 가능한 페이지를 표시할 때는 페이지 이동이 되도록 링크를 건다. -->\t\r\n");
      out.write("\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"./rvBoardList.bo?page=");
      out.print(a );
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(a );
      out.write("]</a>&nbsp;\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
 if(nowpage>=maxpage){
      out.write("\r\n");
      out.write("\t\t\t\t[다음]\r\n");
      out.write("\t\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\t<a href=\"./rvBoardList.bo?page=");
      out.print(nowpage+1 );
      out.write("\">[다음]</a>&nbsp;\t\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr align=\"right\">\r\n");
      out.write("\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t\t");
if(id!=null&&id.length()!=0){
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"./rvBoardWrite.bo\">[글쓰기]</a>\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t");
} else {
      out.write("\r\n");
      out.write("\t<tr align=\"right\">\r\n");
      out.write("\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t");
} 
      out.write("\t\r\n");
      out.write("\t\t<td colspan=\"1\" align=\"center\">\r\n");
      out.write("\t\t\t<a href=\"./rvBoardList.bo\">[처음]</a>\r\n");
      out.write("\t\t</td>\t\r\n");
      out.write("\t</tr>\t \r\n");
      out.write("</table>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./rvboard_search.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
