/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.44
 * Generated at: 2017-07-25 06:35:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ch14._005f1_Model2.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import net.board.db.*;

public final class qna_005fboard_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("net.board.db");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

   List<BoardBean> boardlist = (ArrayList<BoardBean>)request.getAttribute("boardlist");
   int listcount = ((Integer)request.getAttribute("listcount")).intValue();
   int nowpage = ((Integer)request.getAttribute("page")).intValue();
   int maxpage = ((Integer)request.getAttribute("maxpage")).intValue();
   int startpage = ((Integer)request.getAttribute("startpage")).intValue();
   int endpage = ((Integer)request.getAttribute("endpage")).intValue();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("      <title>MVC 게시판</title>\r\n");
      out.write("      <link href=\"css/ch14_listlist.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("   </head>\r\n");
      out.write("   <body>\r\n");
      out.write("      <!-- 게시판 리스트 -->\r\n");
      out.write("      <table>\r\n");
      out.write("      ");

      if(listcount > 0) { //등록된 글이 있는 경우입니다.
      
      out.write("\r\n");
      out.write("         <tr>\r\n");
      out.write("            <th colspan=\"3\">MVC 게시판 - list</th>\r\n");
      out.write("            <th colspan=\"2\"><font size=2>글 개수 : ");
      out.print(listcount );
      out.write("</font></th>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <th width=\"8%\"><div>번호</div></th>\r\n");
      out.write("            <th width=\"50%\"><div>제목</div></th>\r\n");
      out.write("            <th width=\"14%\"><div>작성자</div></th>\r\n");
      out.write("            <th width=\"17%\"><div>날짜</div></th>\r\n");
      out.write("            <th width=\"11%\"><div>조회수</div></th>\r\n");
      out.write("         </tr>\r\n");
      out.write("      ");

         for(BoardBean b : boardlist){
      /*
         for(int i=0; i<boardList.size(); i++){
            BoardBean b = (BoardBean)boardlist.get(i);            
      */
      
      out.write("\r\n");
      out.write("         <tr \r\n");
      out.write("            onmouseover=\"this.style.backgroundColor='#F8F8F8'\"\r\n");
      out.write("            onmouseout =\"this.style.backgroundColor='#FFFFFF'\">\r\n");
      out.write("            <td>");
      out.print(b.getBOARD_NUM() );
      out.write("</td>\r\n");
      out.write("            <td>\r\n");
      out.write("               <div>\r\n");
      out.write("               <!-- 답변글이면 깊이만큼 앞에 공백을 추가하여 시각적으로 답변 효과를 줍니다. -->\r\n");
      out.write("               ");

               if(b.getBOARD_RE_LEV() != 0) {
                  for(int a=0; a<=b.getBOARD_RE_LEV()*2; a++){
      out.write("\r\n");
      out.write("                     &nbsp;\r\n");
      out.write("               ");
   }
      out.write("\r\n");
      out.write("                  ▶\r\n");
      out.write("               <!-- 원문인 경우 -->\r\n");
      out.write("               ");
} else { 
      out.write("\r\n");
      out.write("                  ▶\r\n");
      out.write("               ");
} 
      out.write("\r\n");
      out.write("               <!-- 글 제목을 클릭한 경우 입니다. -->\r\n");
      out.write("                  <a href=\"./BoardDetailAction.bo?num=");
      out.print(b.getBOARD_NUM() );
      out.write("\">\r\n");
      out.write("                     ");
      out.print(b.getBOARD_SUBJECT() );
      out.write("\r\n");
      out.write("                  </a>\r\n");
      out.write("               </div>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td><div>");
      out.print(b.getBOARD_NAME() );
      out.write("</div></td>\r\n");
      out.write("            <td><div>");
      out.print(b.getBOARD_DATE() );
      out.write("</div></td>\r\n");
      out.write("            <td><div>");
      out.print(b.getBOARD_READCOUNT() );
      out.write("</div></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("      ");
      
         } //for문 끝
      
      out.write("\r\n");
      out.write("      <!-- 페이징 처리하는 문 [이전][1][2][3]..[10][다음] -->\r\n");
      out.write("      <tr class=\"h30 lime center\">\r\n");
      out.write("         <td colspan=5>\r\n");
      out.write("            ");
if(nowpage <= 1) { //1페이지 이하인 경우 
      out.write("\r\n");
      out.write("               [이전]&nbsp;\r\n");
      out.write("            ");
} else { //2페이지 이상인 경우 - 한 페이지 적은 페이지로 이동 
      out.write("\r\n");
      out.write("               <a href=\"./BoardList.bo?page=");
      out.print(nowpage-1 );
      out.write("\">\r\n");
      out.write("               [이전]</a>&nbsp;\r\n");
      out.write("            ");
} 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            ");
for(int a=startpage; a<=endpage; a++){
               if(a == nowpage){ //현재 페이지 - 링크 걸지 않습니다.
      out.write("\r\n");
      out.write("                  [");
      out.print(a );
      out.write("]\r\n");
      out.write("            ");
   } else { //현재 페이지 아닌 경우 링크 겁니다. 
      out.write("\r\n");
      out.write("                  <a href=\"./BoardList.bo?page=");
      out.print(a );
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(a );
      out.write("]</a>&nbsp;\r\n");
      out.write("            ");
   } 
      out.write(" \r\n");
      out.write("         ");
   }
      out.write("\r\n");
      out.write("         \r\n");
      out.write("         <!-- 현재 페이지가 가장 큰 페이지보다 크거나 같은 경우 [다음]에 링크 걸지 않습니다. -->\r\n");
      out.write("            ");
if(nowpage >= maxpage) { 
      out.write("\r\n");
      out.write("               [다음]\r\n");
      out.write("            ");
} else { 
      out.write("\r\n");
      out.write("               <a href=\"./BoardList.bo?page=");
      out.print(nowpage+1 );
      out.write("\">[다음]</a>\r\n");
      out.write("            ");
} 
      out.write("\r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      ");
 //등록된 글이 있는 경우 end
      } else {
      
      out.write("\r\n");
      out.write("      <tr>\r\n");
      out.write("         <td colspan=\"4\">MVC 게시판</td>\r\n");
      out.write("         <td style=\"text-align:right\"><font size=2>등록된 글이 없습니다.</font></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      ");

      }
      
      out.write("\r\n");
      out.write("      <tr>\r\n");
      out.write("         <td colspan=\"5\" style=\"text-align:right\">\r\n");
      out.write("            <a href=\"./BoardWrite.bo\">[글쓰기]</a>\r\n");
      out.write("         </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("   </body>\r\n");
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