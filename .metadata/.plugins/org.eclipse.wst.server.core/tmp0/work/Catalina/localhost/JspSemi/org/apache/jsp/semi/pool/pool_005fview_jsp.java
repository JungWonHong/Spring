/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.44
 * Generated at: 2017-08-03 04:12:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.semi.pool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import semi.db.bean.*;

public final class pool_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("semi.db.bean");
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
      out.write("    \r\n");
      out.write("    ");

    PMemberBean pmember = (PMemberBean)request.getAttribute("pmember");
    
      out.write(" \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<title>인재POOL - view</title>\r\n");
      out.write("<link href=\"./css/top.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"./css/board.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Header.jsp", out, false);
      out.write("\r\n");
      out.write("<form name = \"pmodify\" method=\"post\" enctype=\"multipart/form-data\" action = \"AddResume.com\">\r\n");
      out.write("<table>\r\n");
      out.write("<h3>이력서</h3>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>이름</td>\r\n");
      out.write("    <td>");
      out.print(pmember.getP_name());
      out.write("</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>나이</td>\r\n");
      out.write("    <td>");
      out.print(pmember.getP_age());
      out.write("</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>ID</td>\r\n");
      out.write("    <td>\r\n");
      out.write("    \t");
      out.print(pmember.getP_id());
      out.write("\r\n");
      out.write("    \t<input type=\"hidden\" name=\"p_id\" value=");
      out.print(pmember.getP_id() );
      out.write(">\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>연락처</td>\r\n");
      out.write("    <td>");
      out.print(pmember.getP_hp());
      out.write("</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>Email</td>\r\n");
      out.write("    <td>");
      out.print(pmember.getP_email());
      out.write("</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>입사 후 포부(500자 이내)</td>\r\n");
      out.write("    <td><textarea rows=\"10\" cols=\"50\" name = \"comment\" readonly=\"readonly\">");
      out.print(pmember.getP_comment() );
      out.write("</textarea>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>포트폴리오</td>\r\n");
      out.write("    <td>");
if(pmember.getP_portpolio()!=null){
      out.write("\r\n");
      out.write("    <a href=\"./semi/resume/file_down.jsp?file_name=");
      out.print(pmember.getP_portpolio());
      out.write("\" download>\r\n");
      out.write("\t\t");
      out.print(pmember.getP_portpolio() );
      out.write("</a>");
}else{ 
      out.write("\r\n");
      out.write("\t\t포트폴리오없음\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>IT관련 자격증 유무</td>\r\n");
      out.write("    <td>\r\n");
      out.write("    ");
if(pmember.getP_certi() != 0){ 
      out.write("\r\n");
      out.write("    \t관련자격증보유\r\n");
      out.write("    ");
} else { 
      out.write("\r\n");
      out.write("    \t관련자격증없음\r\n");
      out.write("    ");
} 
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td colspan=2>\r\n");
      out.write("      <a href = \"javascript:history.go(-1)\">[뒤로]</a>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>  \r\n");
      out.write("  \r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../Footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
