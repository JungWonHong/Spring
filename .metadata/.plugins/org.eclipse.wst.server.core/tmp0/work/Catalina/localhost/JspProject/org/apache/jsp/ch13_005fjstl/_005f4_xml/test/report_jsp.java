/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.45
 * Generated at: 2017-08-09 00:10:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ch13_005fjstl._005f4_xml.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class report_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar", Long.valueOf(1502071230694L));
    _jspx_dependants.put("jar:file:/I:/KH정보교육원/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/JspProject/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/x.tld", Long.valueOf(1323225978000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
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
      out.write("<!-- JSTL xml은 xml문서에서 자주 사용되는 기능들을 태그 라이브러리로 모아 놓은 것입니다. -->\r\n");
      out.write("<!-- JSTL xml라이브러리를 사용하기 위해 uri 속성과 prefix 속성을 설정합니다.-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>JSTL xml 라이브러리 사용 예제(jstl_xml_ex.jsp)</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div></div>\r\n");
      out.write("\t</body>\r\n");
      out.write("\t<script src=\"../../../js/jquery-3.2.1.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tdata = '<students>'\r\n");
      out.write("\t\tdata += ' <student>'\r\n");
      out.write("\t\tdata += '  <name lang=\"한국\">홍길동</name>'\r\n");
      out.write("\t\tdata += '  <age>18</age>'\r\n");
      out.write("\t\tdata += '  <gender>남</gender>'\r\n");
      out.write("\t\tdata += '  <phone>010-3456-11xx</phone>'\r\n");
      out.write("\t\tdata += ' </student>'\r\n");
      out.write("\t\tdata += ' <student>'\r\n");
      out.write("\t\tdata += '  <name lang=\"일본\">김길동</name>'\r\n");
      out.write("\t\tdata += '  <age>19</age>'\r\n");
      out.write("\t\tdata += '  <gender>남</gender>'\r\n");
      out.write("\t\tdata += '  <phone>010-4567-00xx</phone>'\r\n");
      out.write("\t\tdata += ' </student>'\r\n");
      out.write("\t\tdata += ' <student>'\r\n");
      out.write("\t\tdata += '  <name lang=\"미국\">홍길순</name>'\r\n");
      out.write("\t\tdata += '  <age>18</age>'\r\n");
      out.write("\t\tdata += '  <gender>여</gender>'\r\n");
      out.write("\t\tdata += '  <phone>없음</phone>'\r\n");
      out.write("\t\tdata += ' </student>'\r\n");
      out.write("\t\tdata += ' <student>'\r\n");
      out.write("\t\tdata += '  <name lang=\"미국\">김길순</name>'\r\n");
      out.write("\t\tdata += '  <age>18</age>'\r\n");
      out.write("\t\tdata += '  <gender>여</gender>'\r\n");
      out.write("\t\tdata += '  <phone>없음</phone>'\r\n");
      out.write("\t\tdata += ' </student>'\r\n");
      out.write("\t\tdata += ' </students>'\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//$(document).ready(function(){ //body 아래에 있기 때문에 $(document).ready를 안해줘도 된다.\r\n");
      out.write("\t\t\tvar xmlData = $.parseXML(data);\r\n");
      out.write("\t\t\tstu = $(xmlData).find('student');\r\n");
      out.write("\t\t\t$(stu).each(function(){\r\n");
      out.write("\t\t\t\tname = $(this).find('name').text();\r\n");
      out.write("\t\t\t\tif (name != '홍길순') {\r\n");
      out.write("\t\t\t\t\toutput = name + \" \";\r\n");
      out.write("\t\t\t\t\toutput += $(this).find('age').text() + \" \";\r\n");
      out.write("\t\t\t\t\toutput += $(this).find('gender').text() + \" \";\r\n");
      out.write("\t\t\t\t\toutput += $(this).find('name').attr('lang');\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tphone = $(this).find('phone').text();\r\n");
      out.write("\t\t\t\t\tif (phone == '없음')\r\n");
      out.write("\t\t\t\t\t\tphone_message = \"전화없음\";\r\n");
      out.write("\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t\tphone_message = \"전화번호 : \" + phone;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\toutput += \"[\" + phone_message + \"]<br>\";\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t//innerHTML 속성에 추가하여 출력합니다.\r\n");
      out.write("\t\t\t\t\tdocument.body.innerHTML += output;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t/* $(xmlData).find('student').each(function(){\r\n");
      out.write("\t\t\t\tvar output = '';7\r\n");
      out.write("\t\t\t\tif($(this).find('name').text() != '홍길순'){\r\n");
      out.write("\t\t\t\t\toutput += $(this).find('name').text() + '&nbsp;';\r\n");
      out.write("\t\t\t\t\toutput += $(this).find('age').text() + '&nbsp;';\r\n");
      out.write("\t\t\t\t\toutput += $(this).find('gender').text() + '&nbsp;';\r\n");
      out.write("\t\t\t\t\toutput += $(this).find('name').attr('lang') + '&nbsp;';\r\n");
      out.write("\t\t\t\t\tif($(this).find('phone').text() != '없음')\r\n");
      out.write("\t\t\t\t\t\toutput += '[전화번호 : ' + $(this).find('phone').text() + ']';\r\n");
      out.write("\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t\toutput += '[전화 없음]';\r\n");
      out.write("\t\t\t\t\toutput += '<br>';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tdocument.body.innerHTML += output;\r\n");
      out.write("\t\t\t}); */\r\n");
      out.write("\t\t//});\r\n");
      out.write("\t</script>\r\n");
      out.write("</html>\t");
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
