<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="model.Order" %>
<%@ page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 Order order = (Order)request.getAttribute("order");
String username =(String)request.getAttribute("username");
User user = (User) session.getAttribute("user");
%>

<HTML>
<link rel="stylesheet" type="text/css" href="../../css/read.css">
<HEAD>
<TITLE>依頼詳細</TITLE>
</HEAD>
<BODY>
<font size="16">依頼詳細</font>

<table border="1" class="order">
<tr>
	<th align="center">依頼ID/フラグ状態</th>
	<td align="center"><%=order.getRequestid()%></td>
	<td align="center"><%switch(order.getManagementflag()){
	case 0:
		out.println("error");
		break;
	case 1:
		out.println("検討中");
		break;
	case 2:
		out.println("許可");
		break;
	case 3:
		out.println("不可");
		break;
	}%>

	<%if(user.getRole()==1){%>
	<form method="post" action="./ChangeFlagServlet">
	<input type="hidden" name="flag" value="manflg">
	<input type="hidden" name="reqid" value="<%=order.getRequestid()%>">
<input type="radio" name="manflg"value="2">許可
<input type="radio" name="manflg"value="3">不可
	<button>変更</button></form>
	<%}%>	</td>

</tr>

<tr>
	<th align="center">経理判断/納品状況</th>
	<td align="center"><%switch(order.getDecision()){
		case 0:
		out.println("");
		break;
	case 1:
		out.println("判断待ち");
		break;
	case 2:
		out.println("許可");
		break;
	case 3:
		out.println("不可");
		break;
	}%>

	<%if(user.getRole()==1 && order.getManagementflag() == 2){%>
	<form method="post" action="./ChangeFlagServlet">
	<input type="hidden" name="flag" value="decflg">
	<input type="hidden" name="reqid" value="<%=order.getRequestid()%>">
<input type="radio" name="decflg"value="2">許可
<input type="radio" name="decflg"value="3">不可
	<button>変更</button></form>
	<%}%>	</td>
	<td align="center"><%switch(order.getDeliveryofgoods()){
		case 0:
		out.println("");
		break;
	case 1:
		out.println("未納品");
		break;
	case 2:
		out.println("納品済");
		break;
	}%>

		<%if(user.getId().equals(order.getUserid()) && order.getDecision()==2){%>
	<form method="post" action="./ChangeFlagServlet">
	<input type="hidden" name="flag" value="delflg">
	<input type="hidden" name="reqid" value="<%=order.getRequestid()%>">
	<input type="hidden" name="goodsname" value="<%=order.getGoodsname()%>">
<input type="radio" name="delflg"value="2">納品済
	<button>変更</button></form>
	<%}%>	</td>
</tr>

<tr>
	<th align="center" >名称</th>
	<td align="center" colspan="2"><c:out value="${order.getGoodsname()}" /></td>
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
	<th align="center">依頼者</th>
	<td align="center" colspan="2"><%=username%></td>
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

<a href="../user/GoMypageServlet" class="mypage">マイページに戻る</a>

</BODY>
</HTML>