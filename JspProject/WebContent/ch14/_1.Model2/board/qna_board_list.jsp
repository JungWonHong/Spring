<%--글 목록을 보여주는 뷰 페이지 --%>
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
      <title>MVC 게시판</title>
      <link href="css/ch14_listlist.css" rel="stylesheet" type="text/css">
   </head>
   <body>
      <!-- 게시판 리스트 -->
      <table>
      <%
      if(listcount > 0) { //등록된 글이 있는 경우입니다.
      %>
         <tr>
            <th colspan="3">MVC 게시판 - list</th>
            <th colspan="2"><font size=2>글 개수 : <%=listcount %></font></th>
         </tr>
         <tr>
            <th width="8%"><div>번호</div></th>
            <th width="50%"><div>제목</div></th>
            <th width="14%"><div>작성자</div></th>
            <th width="17%"><div>날짜</div></th>
            <th width="11%"><div>조회수</div></th>
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
               <!-- 답변글이면 깊이만큼 앞에 공백을 추가하여 시각적으로 답변 효과를 줍니다. -->
               <%
               if(b.getBOARD_RE_LEV() != 0) {
                  for(int a=0; a<=b.getBOARD_RE_LEV()*2; a++){%>
                     &nbsp;
               <%   }%>
                  ▶
               <!-- 원문인 경우 -->
               <%} else { %>
                  ▶
               <%} %>
               <!-- 글 제목을 클릭한 경우 입니다. -->
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
         } //for문 끝
      %>
      <!-- 페이징 처리하는 문 [이전][1][2][3]..[10][다음] -->
      <tr class="h30 lime center">
         <td colspan=5>
            <%if(nowpage <= 1) { //1페이지 이하인 경우 %>
               [이전]&nbsp;
            <%} else { //2페이지 이상인 경우 - 한 페이지 적은 페이지로 이동 %>
               <a href="./BoardList.bo?page=<%=nowpage-1 %>">
               [이전]</a>&nbsp;
            <%} %>
            
            <%for(int a=startpage; a<=endpage; a++){
               if(a == nowpage){ //현재 페이지 - 링크 걸지 않습니다.%>
                  [<%=a %>]
            <%   } else { //현재 페이지 아닌 경우 링크 겁니다. %>
                  <a href="./BoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
            <%   } %> 
         <%   }%>
         
         <!-- 현재 페이지가 가장 큰 페이지보다 크거나 같은 경우 [다음]에 링크 걸지 않습니다. -->
            <%if(nowpage >= maxpage) { %>
               [다음]
            <%} else { %>
               <a href="./BoardList.bo?page=<%=nowpage+1 %>">[다음]</a>
            <%} %>
         </td>
      </tr>
      <% //등록된 글이 있는 경우 end
      } else {
      %>
      <tr>
         <td colspan="4">MVC 게시판</td>
         <td style="text-align:right"><font size=2>등록된 글이 없습니다.</font></td>
      </tr>
      <%
      }
      %>
      <tr>
         <td colspan="5" style="text-align:right">
            <a href="./BoardWrite.bo">[글쓰기]</a>
         </td>
      </tr>
      </table>
   </body>
</html>