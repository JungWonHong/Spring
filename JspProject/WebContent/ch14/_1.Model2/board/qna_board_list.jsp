<%--�� ����� �����ִ� �� ������ --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="net.board.db.*" %>
<%
   List<BoardBean> boardlist = (ArrayList<BoardBean>)request.getAttribute("boardlist");
   int listcount = ((Integer)request.getAttribute("listcount")).intValue();
   int nowpage = ((Integer)request.getAttribute("page")).intValue();
   int maxpage = ((Integer)request.getAttribute("maxpage")).intValue();
   int startpage = ((Integer)request.getAttribute("startpage")).intValue();
   int endpage = ((Integer)request.getAttribute("endpage")).intValue();
%>
<!DOCTYPE html>
<html>
   <head>
      <title>MVC �Խ���</title>
      <link href="css/ch14_listlist.css" rel="stylesheet" type="text/css">
   </head>
   <body>
      <!-- �Խ��� ����Ʈ -->
      <table>
      <%
      if(listcount > 0) { //��ϵ� ���� �ִ� ����Դϴ�.
      %>
         <tr>
            <th colspan="3">MVC �Խ��� - list</th>
            <th colspan="2"><font size=2>�� ���� : <%=listcount %></font></th>
         </tr>
         <tr>
            <th width="8%"><div>��ȣ</div></th>
            <th width="50%"><div>����</div></th>
            <th width="14%"><div>�ۼ���</div></th>
            <th width="17%"><div>��¥</div></th>
            <th width="11%"><div>��ȸ��</div></th>
         </tr>
      <%
         for(BoardBean b : boardlist){
      /*
         for(int i=0; i<boardList.size(); i++){
            BoardBean b = (BoardBean)boardlist.get(i);            
      */
      %>
         <tr 
            onmouseover="this.style.backgroundColor='#F8F8F8'"
            onmouseout ="this.style.backgroundColor='#FFFFFF'">
            <td><%=b.getBOARD_NUM() %></td>
            <td>
               <div>
               <!-- �亯���̸� ���̸�ŭ �տ� ������ �߰��Ͽ� �ð������� �亯 ȿ���� �ݴϴ�. -->
               <%
               if(b.getBOARD_RE_LEV() != 0) {
                  for(int a=0; a<=b.getBOARD_RE_LEV()*2; a++){%>
                     &nbsp;
               <%   }%>
                  ��
               <!-- ������ ��� -->
               <%} else { %>
                  ��
               <%} %>
               <!-- �� ������ Ŭ���� ��� �Դϴ�. -->
                  <a href="./BoardDetailAction.bo?num=<%=b.getBOARD_NUM() %>">
                     <%=b.getBOARD_SUBJECT() %>
                  </a>
               </div>
            </td>
            <td><div><%=b.getBOARD_NAME() %></div></td>
            <td><div><%=b.getBOARD_DATE() %></div></td>
            <td><div><%=b.getBOARD_READCOUNT() %></div></td>
         </tr>
      <%      
         } //for�� ��
      %>
      <!-- ����¡ ó���ϴ� �� [����][1][2][3]..[10][����] -->
      <tr class="h30 lime center">
         <td colspan=5>
            <%if(nowpage <= 1) { //1������ ������ ��� %>
               [����]&nbsp;
            <%} else { //2������ �̻��� ��� - �� ������ ���� �������� �̵� %>
               <a href="./BoardList.bo?page=<%=nowpage-1 %>">
               [����]</a>&nbsp;
            <%} %>
            
            <%for(int a=startpage; a<=endpage; a++){
               if(a == nowpage){ //���� ������ - ��ũ ���� �ʽ��ϴ�.%>
                  [<%=a %>]
            <%   } else { //���� ������ �ƴ� ��� ��ũ �̴ϴ�. %>
                  <a href="./BoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
            <%   } %> 
         <%   }%>
         
         <!-- ���� �������� ���� ū ���������� ũ�ų� ���� ��� [����]�� ��ũ ���� �ʽ��ϴ�. -->
            <%if(nowpage >= maxpage) { %>
               [����]
            <%} else { %>
               <a href="./BoardList.bo?page=<%=nowpage+1 %>">[����]</a>
            <%} %>
         </td>
      </tr>
      <% //��ϵ� ���� �ִ� ��� end
      } else {
      %>
      <tr>
         <td colspan="4">MVC �Խ���</td>
         <td style="text-align:right"><font size=2>��ϵ� ���� �����ϴ�.</font></td>
      </tr>
      <%
      }
      %>
      <tr>
         <td colspan="5" style="text-align:right">
            <a href="./BoardWrite.bo">[�۾���]</a>
         </td>
      </tr>
      </table>
   </body>
</html>