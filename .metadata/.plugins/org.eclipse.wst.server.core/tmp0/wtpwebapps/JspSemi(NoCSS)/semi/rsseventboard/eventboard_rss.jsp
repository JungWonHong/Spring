<%@ page language="java"
    contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.util.List" %>
<%@ page import="org.xml.sax.InputSource" %>
<%@ page import="org.jdom.Document" %>
<%@ page import="org.jdom.Element" %>
<%@ page import="org.jdom.input.SAXBuilder" %>
<%
    List list = null;
    try{
        SAXBuilder parser = new SAXBuilder();
        parser.setValidation(false);
        parser.setIgnoringElementContentWhitespace(true);
        URL url = new URL("http://feed43.com/0206465874522756.xml");
        InputSource is = new InputSource(url.openStream());
        Document doc = parser.build(is);
        Element root = doc.getRootElement();
        Element channel = root.getChild("channel");
        list = channel.getChildren("item");
    }catch(Exception e){
        e.getStackTrace();
    }
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공모전 게시판(RSS)</title>
<style>
div {
	border: 1px solid black;
	width:800px;
	height: 400px;
	margin:auto;
	padding: 20px;
	overflow: hidden;
}
ul {
	list-style:none;
	margin:0;
	padding:0;
}
li{
	margin: 0 0 0 0;
	padding: 0 0 0 0;
	border: 0;
}
</style>
<script type="text/javascript" src="./js/jquery-3.2.1.js"></script>
<script>
$(document).ready(function() {
   function rolliTem(){$(".roll-wrapper li:first").slideUp(function(){$(this).appendTo($(".roll-wrapper")).slideDown()})}
   var rollStart= setInterval(function(){ rolliTem()},5000);
   $(".roll-wrapper li").bind("mouseenter mouseleave", function(e) {
      if (e.type == 'mouseenter') { clearInterval(rollStart); }
      else { rollStart = setInterval(function(){ rolliTem()},5000); }
   });
});
</script>
</head>
<jsp:include page="../Header.jsp"></jsp:include>
<body>
<div>
<ul class="roll-wrapper">
<%
    if(list!=null){
        for(int i=0; i<list.size(); i++){
            Element el = (Element) list.get(i);
%>
    <li ><a href='<%=el.getChildText("link")%>' target=_news>
        <%=el.getChildText("title")%></a>
        <%=el.getChildText("description") %>
        </li>
<%
        }
    }else{
%>
    <li>잠시 후 다시 접속하여 주십시오.</li>
<%
    }
%>
</ul>
</div>
</body>
</html>
