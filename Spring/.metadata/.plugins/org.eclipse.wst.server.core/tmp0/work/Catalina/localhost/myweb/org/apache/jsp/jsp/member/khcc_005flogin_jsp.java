/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.45
 * Generated at: 2017-09-28 00:14:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class khcc_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/jsp/member/../include/menubar_login.jsp", Long.valueOf(1506473848043L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1506557313050L));
    _jspx_dependants.put("jar:file:/I:/KH/Spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springFinal/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/jsp/member/../include/menubar_nologin.jsp", Long.valueOf(1506413706138L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>로그인</title>\r\n");
      out.write("<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"./resources/css/admin2.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./resources/css/member2.css\"> -->\r\n");
      out.write("<script src=\"./resources/js/jquery-3.2.1.js\"></script>\r\n");
      out.write("<script src=\"./resources/js/member4.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("   function check() {\r\n");
      out.write("      if($.trim($(\"#login_email\").val()) == \"\") {\r\n");
      out.write("         alert(\"이메일을 입력하세요!\");\r\n");
      out.write("         $(\"#login_email\").val(\"\").focus();\r\n");
      out.write("         return false;\r\n");
      out.write("      }\r\n");
      out.write("      if($.trim($(\"#login_password\").val()) == \"\") {\r\n");
      out.write("         alert(\"비밀번호를 입력하세요!\");\r\n");
      out.write("         $(\"#login_password\").val(\"\").focus();\r\n");
      out.write("         return false;\r\n");
      out.write("      }\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   /* 비밀번호 찾기 팝업창 */\r\n");
      out.write("   function pwd_find() {\r\n");
      out.write("      window.open(\"pwd_find.nhn\", \"비밀번호 찾기\", \"width=400, height=300\");\r\n");
      out.write("      // 자바 스크립트에서 window 객체의  open(\"팝업창 경로와 파일명\", \"팝업창 이름\", \"팝업창 속성\");\r\n");
      out.write("      // 메서드로 새로운 팝업창을 만듭니다. \r\n");
      out.write("      // 폭이 400, 높이가 300인 새로운 팝업창. 단위는 픽셀\r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("#login_wrap{\r\n");
      out.write("      width:600px; height:350px;\r\n");
      out.write("   margin-top:14%; margin-left:auto; margin-right:auto;\r\n");
      out.write("   border:1px solid lightgray;\r\n");
      out.write("   border-radius:20px;\r\n");
      out.write("   box-shadow:15px 15px 15px lightgray;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login_title{margin-left:40%; margin-top:7%; color:#2ABCB4; font-weight:bold; font-size:30pt;}\r\n");
      out.write(".emailth {\r\n");
      out.write("    margin-left: 14%;\r\n");
      out.write("    font-size: 15pt;\r\n");
      out.write("    padding-top: 6%;\r\n");
      out.write("}\r\n");
      out.write(".passth {\r\n");
      out.write("    margin-left: 12%;\r\n");
      out.write("    padding-top: 3%;\r\n");
      out.write("    font-size: 15pt;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".input_box1 {\r\n");
      out.write("    width: 250px;\r\n");
      out.write("    height: 30px;\r\n");
      out.write("    margin-left: 32%;\r\n");
      out.write("    margin-top: -4.5%;\r\n");
      out.write("}\r\n");
      out.write(".input_box2 {\r\n");
      out.write("    width: 250px;\r\n");
      out.write("    height: 30px;\r\n");
      out.write("    margin-left: 32%;\r\n");
      out.write("    margin-top: -4.5%;\r\n");
      out.write("}\r\n");
      out.write("#login_menu {\r\n");
      out.write("    padding-left: 21%;\r\n");
      out.write("    padding-top: 10%;\r\n");
      out.write("}\r\n");
      out.write("#login_t{margin-top:5%;}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("   <div id=\"login_wrap\">\r\n");
      out.write("      <h2 class=\"login_title\">로그인</h2>\r\n");
      out.write("      <form method=\"post\" action=\"khcc_login_ok.nhn\" onsubmit=\"return check()\">\r\n");
      out.write("         <div id=\"login_t\">\r\n");
      out.write("              \r\n");
      out.write("               <div class=\"emailth\">이메일</div>\r\n");
      out.write("         \r\n");
      out.write("                  <input name=\"login_email\" id=\"login_email\" class=\"input_box1\">\r\n");
      out.write("      \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("               <div class=\"passth\">비밀번호</div>\r\n");
      out.write("            \r\n");
      out.write("                  <input type=\"password\" name=\"login_password\" id=\"login_password\"\r\n");
      out.write("                        class=\"input_box2\">\r\n");
      out.write("         \r\n");
      out.write("            \r\n");
      out.write("         </div>\r\n");
      out.write("         <div id=\"login_menu\">\r\n");
      out.write("            <input type=\"submit\" value=\"로그인\" class=\"btn btn-default\">\r\n");
      out.write("            <a class=\"btn btn-default\" onclick=\"href='khcc_join.nhn'\">회원가입</a>\r\n");
      out.write("            <input type=\"reset\" value=\"취소\" class=\"btn btn-default\" \r\n");
      out.write("                  onclick=\"$('#login_email').focus();\">\r\n");
      out.write("            <input type=\"button\" value=\"비밀번호 찾기\" class=\"btn btn-default\"\r\n");
      out.write("                  onclick=\"pwd_find()\">\r\n");
      out.write("         </div>\r\n");
      out.write("      </form>\r\n");
      out.write("   </div>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /jsp/member/khcc_login.jsp(77,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty login_email}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("<link href=\"./resources/bootstrap-css/bootstrap.min.css\"\r\n");
          out.write("\trel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/prettyPhoto.css\" rel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/font-awesome.min.css\"\r\n");
          out.write("\trel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/animate.css\" rel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/main.css\" rel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/responsive.css\" rel=\"stylesheet\">\r\n");
          out.write("\r\n");
          out.write("<script src=\"./resources/js/jquery-3.2.1.js\"></script>\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t<script type=\"text/javascript\" src=\"./resources/bootstrap-js/jquery.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/bootstrap.min.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/smoothscroll.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/jquery.isotope.min.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/jquery.prettyPhoto.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/jquery.parallax.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\" src=\"./resources/bootstrap-js/main.js\"></script>\r\n");
          out.write("\t\r\n");
          out.write("\t<script>\r\n");
          out.write("\t\t/* 비밀번호 찾기 팝업창 */\r\n");
          out.write("\t\tfunction pwd_find() {\r\n");
          out.write("\t\t\twindow.open(\"pwd_find.nhn\", \"비밀번호 찾기\", \"width=400, height=300\");\r\n");
          out.write("\t\t\t// 자바 스크립트에서 window 객체의  open(\"팝업창 경로와 파일명\", \"팝업창 이름\", \"팝업창 속성\");\r\n");
          out.write("\t\t\t// 메서드로 새로운 팝업창을 만듭니다. 폭이 400, 높이가 300인 새로운 팝업창. 단위는 픽셀\r\n");
          out.write("\t\t}\r\n");
          out.write("\t\tfunction reportwindow() {\r\n");
          out.write("\t\t\turl = \"./khcc_reportwrite.nhn\";\r\n");
          out.write("\t\t\twindow.open(url, \"report\", \"toolbar=no, status=yes, menubar=no,\"\r\n");
          out.write("\t\t\t\t\t+ \"scrollbars=yes, directories=no, top=100, left=400,\"\r\n");
          out.write("\t\t\t\t\t+ \"width=470px, height=500px\");\r\n");
          out.write("\t\t}\r\n");
          out.write("\t\tfunction reportlistwindow() {\r\n");
          out.write("\t\t\turl = \"./khcc_reportlist.nhn\";\r\n");
          out.write("\r\n");
          out.write("\t\t\twindow.open(url, \"report\", \"toolbar=no, status=yes, menubar=no,\"\r\n");
          out.write("\t\t\t\t\t+ \"scrollbars=yes, directories=no,\"\r\n");
          out.write("\t\t\t\t\t+ \"width=600px, height=450px\");\r\n");
          out.write("\t\t}\r\n");
          out.write("\r\n");
          out.write("\t\t$('li.dropdown').hover(\r\n");
          out.write("\t\t\t\tfunction() {\r\n");
          out.write("\t\t\t\t\t$(this).find('.dropdown-menu').stop(true, true).delay(200)\r\n");
          out.write("\t\t\t\t\t\t\t.fadeIn(500);\r\n");
          out.write("\t\t\t\t},\r\n");
          out.write("\t\t\t\tfunction() {\r\n");
          out.write("\t\t\t\t\t$(this).find('.dropdown-menu').stop(true, true).delay(200)\r\n");
          out.write("\t\t\t\t\t\t\t.fadeOut(500);\r\n");
          out.write("\t\t\t\t});\r\n");
          out.write("\t</script>\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t<header id=\"navigation\">\r\n");
          out.write("\t\t<div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"banner\">\r\n");
          out.write("\t\t\t<div class=\"container\">\r\n");
          out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
          out.write("\t\t\t\t\t<a class=\"navbar-brand\" onclick=\"loaction:href='khcc_home.nhn'\"\r\n");
          out.write("\t\t\t\t\t\tstyle=\"cursor: pointer\"> <img\r\n");
          out.write("\t\t\t\t\t\tsrc=\"./resources/images/logo.png\">\r\n");
          out.write("\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t<!-- 일반사용자일 때 -->\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fif_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t<!-- 관리자 계정으로 접속할 때 -->\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fif_005f2(_jspx_th_c_005fif_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t\t</div>\r\n");
          out.write("\t\t\t<div>\r\n");
          out.write("\t\t\t\t<a href=\"khcc_logout.nhn\" style=\"float: right\">로그아웃</a>\r\n");
          out.write("\t\t\t</div>\r\n");
          out.write("\t\t\t<div>\r\n");
          out.write("\t\t\t\t<a href=\"khcc_mypage.nhn\" style=\"float: right\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("님 환영합니다.</a>\r\n");
          out.write("\t\t\t</div>\r\n");
          out.write("\t\t</div>\r\n");
          out.write("\t\t<!--/navbar-->\r\n");
          out.write("\t</header>\r\n");
          out.write("\t<!--/#navigation-->");
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /jsp/member/../include/menubar_login.jsp(73,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login_email != 'admin@khcc.com'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<div class=\"collapse navbar-collapse\">\r\n");
          out.write("\t\t\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"khcc_servicesview.nhn\">서비스 안내</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"khcc_reservation.nhn\">실시간 예약</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li class=\"drop\tdown\"><a href=\"#\"\r\n");
          out.write("\t\t\t\t\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\">카풀</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"cp_list\">Driver</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"javascript:window.open('./rider', '카풀등록', 'width=800,height=500,scrollbars=yes');\">Rider</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t\t</ul></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"qa_list.nhn\">REVIEW</a></li>\r\n");
          out.write("                  \t\t\t<li><a href=\"nt_list.nhn\">고객센터</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"khcc_mypage.nhn\">마이페이지</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:reportwindow()\"> <img\r\n");
          out.write("\t\t\t\t\t\t\t\t\tsrc=\"./resources/images/reporticon.png\" style=\"width:20px; height:20px\">신고하기</a>\r\n");
          out.write("\t\t\t\t\t\t</ul>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
      // /jsp/member/../include/menubar_login.jsp(94,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login_email eq 'admin@khcc.com'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<div class=\"collapse navbar-collapse\">\r\n");
          out.write("\t\t\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"javascript:reportlistwindow()\">신고함</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"khcc_servicesview.nhn\">서비스 안내</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"khcc_reservation.nhn\">실시간 예약</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li class=\"drop\tdown\"><a href=\"#\"\r\n");
          out.write("\t\t\t\t\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\">카풀</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"cp_list\">Driver</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"javascript:window.open('./rider', '카풀등록', 'width=800,height=500,scrollbars=yes');\">Rider</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t\t</ul></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"qa_list.nhn\">REVIEW</a></li>\r\n");
          out.write("                  \t\t\t<li><a href=\"nt_list.nhn\">고객센터</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t<li><a href=\"khcc_adminpage.nhn\">관리자페이지</a></li>\r\n");
          out.write("\t\t\t\t\t\t</ul>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f3_reused = false;
    try {
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent(null);
      // /jsp/member/khcc_login.jsp(81,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty login_email}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write("\r\n");
          out.write("<link href=\"./resources/bootstrap-css/bootstrap.min.css\"\r\n");
          out.write("\trel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/prettyPhoto.css\" rel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/font-awesome.min.css\"\r\n");
          out.write("\trel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/animate.css\" rel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/main.css\" rel=\"stylesheet\">\r\n");
          out.write("<link href=\"./resources/bootstrap-css/responsive.css\" rel=\"stylesheet\">\r\n");
          out.write("<script src=\"./resources/js/jquery-3.2.1.js\"></script>\r\n");
          out.write("<script type=\"text/javascript\" src=\"./resources/bootstrap-js/jquery.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/bootstrap.min.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/smoothscroll.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/jquery.isotope.min.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/jquery.prettyPhoto.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\"\r\n");
          out.write("\t\tsrc=\"./resources/bootstrap-js/jquery.parallax.js\"></script>\r\n");
          out.write("\t<script type=\"text/javascript\" src=\"./resources/bootstrap-js/main.js\"></script>\r\n");
          out.write("<script>\r\n");
          out.write("\t$('li.dropdown').hover(function() {\r\n");
          out.write("\t  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);\r\n");
          out.write("\t}, function() {\r\n");
          out.write("\t  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);\r\n");
          out.write("\t});\r\n");
          out.write("</script>\r\n");
          out.write("\r\n");
          out.write("\t<header id=\"navigation\">\r\n");
          out.write("\t\t<div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"banner\">\r\n");
          out.write("\t\t\t<div class=\"container\">\r\n");
          out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
          out.write("\t\t\t\t\t<a class=\"navbar-brand\" onclick=\"loaction:href='khcc_home.nhn'\"\r\n");
          out.write("\t\t\t\t\t\tstyle=\"cursor: pointer\"> \r\n");
          out.write("\t\t\t\t\t\t<img src=\"./resources/images/logo.png\">\r\n");
          out.write("\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t<div class=\"collapse navbar-collapse\">\r\n");
          out.write("\t\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
          out.write("\t\t\t\t\t\t<li><a href=\"khcc_servicesview.nhn\">서비스 안내</a></li>\r\n");
          out.write("\t\t\t\t\t\t<li><a href=\"khcc_reservation.nhn\">실시간 예약</a></li>\r\n");
          out.write("\t\t\t\t\t\t<li class=\"drop\tdown\"><a href=\"#\"\r\n");
          out.write("\t\t\t\t\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\">카풀</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"cp_list\">Driver</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"javascript:window.open('./rider', '카풀등록', 'width=800,height=500,scrollbars=yes');\">Rider</a></li>\r\n");
          out.write("\t\t\t\t\t\t\t\t</ul></li>\r\n");
          out.write("\t\t\t\t\t\t<li><a href=\"qa_list.nhn\">REVIEW</a></li>\r\n");
          out.write("                  \t\t<li><a href=\"nt_list.nhn\">고객센터</a></li>\r\n");
          out.write("\t\t\t\t\t\t<li><a href=\"khcc_login.nhn\">로그인</a></li>\r\n");
          out.write("\t\t\t\t\t\t<li><a href=\"khcc_join.nhn\">회원가입</a></li>\r\n");
          out.write("\t\t\t\t\t</ul>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t</div>\r\n");
          out.write("\t\t</div>\r\n");
          out.write("\t\t<!--/navbar-->\r\n");
          out.write("\t</header>\r\n");
          out.write("\t<!--/#navigation-->");
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      _jspx_th_c_005fif_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f3_reused);
    }
    return false;
  }
}