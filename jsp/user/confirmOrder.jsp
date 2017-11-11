<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.Order"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Order order = (Order) session.getAttribute("order");
%>
<html>
<link rel="stylesheet" type="text/css" href="../../css/read.css">
<title>依頼登録内容確認ページ</title>
<body>
以下の内容でよければ登録を押してください<br>
<br>
<table border="1" class="order">

<tr>
	<th align="center" >名称</th>
	<td align="center" colspan="2"><c:out value="${order.getGoodsname()}" /></td>
</tr>
<tr>
	<th align="center" >種別</th>
	<td align="center" colspan="2"><c:out value="${order.getKind()}" /></td>
</tr>

<% if((order.getKind()).equals("書籍")){%>

<tr>
	<th align="center">著者名</t>
	<td align="center" colspan="2"><c:out value="${order.getAuthor()}" /></td>
</tr>

<tr>
	<th align="center">ISBN</th>
	<td align="center" colspan="2"><%=order.getIsbn()%></td>
</tr>

<tr>
	<th align="center">出版社</th>
	<td align="center" colspan="2"><c:out value="${order.getPublisher()}" /></td>
</tr>

<tr>
	<th align="center">キーワード</th>
	<td align="center" colspan="2">
	<c:out value="${order.getKeyword1()}" />
	<% if(order.getKeyword2() != null){%>,　<c:out value="${order.getKeyword2()}" />
	<% if(order.getKeyword3() != null){%>,　<c:out value="${order.getKeyword3()}" />
	<% if(order.getKeyword4() != null){%>,　<c:out value="${order.getKeyword4()}" />
	<% if(order.getKeyword5() != null){%>,　<c:out value="${order.getKeyword5()}" />
	<%}}}} %>
	</td>
</tr>
<% } %>

<tr>
	<th align="center">単価/個数</th>
	<td align="center"><%=order.getCost()%> 円</td>
	<td align="center"><%=order.getNumber()%></td>
</tr>

<tr>
	<th align="center">依頼理由</th>
	<td align="center" colspan="2"><c:out value="${order.getReason()}" /></td>
</tr>

<% if(order.getNote() != null){ %>
<tr>
	<th align="center">備考</th>
	<td align="center"><%=order.getNote()%></td>
</tr>
<%}%>

</table>
<br>
	<c:if test="${reqId == null}">
		<FONT><a href="/Springwork/jsp/user/orderRegist.jsp">戻って編集</a></FONT>
		<FORM method="post" action="/Springwork/jsp/RegistOrderServlet">
			<input type="submit" value="登録">
		</FORM>
	</c:if>
	<c:if test="${reqId != null}">
		<FONT color="red"> ${reqId} </FONT>
		<FONT><a href="/Springwork/jsp/user/studentMypage.jsp">マイページに戻る</a></FONT>

	</c:if>
</body>
</html>