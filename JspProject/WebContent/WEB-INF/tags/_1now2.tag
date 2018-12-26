<%@ tag body-content="empty" pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<fmt:formatDate value="${date }" type="both" timeStyle="long" dateStyle="long"/>