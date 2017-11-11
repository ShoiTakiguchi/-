<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import="model.Order" %>
<%@ page import="model.News" %>
<%@ page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% User user = (User) session.getAttribute("user");%>

<% ArrayList<Order> list = (ArrayList<Order>)request.getAttribute("list");%>
<% ArrayList<Order> list2 = (ArrayList<Order>)request.getAttribute("list2");%>

<HTML>
<script type="text/javascript" src="../../js/mypage.js"></script>
<HEAD>
<TITLE>依頼者マイページ</TITLE>
</HEAD>
<link rel="stylesheet" type="text/css" href="../../css/mypage.css">
<BODY>
<span class="role">管理者</span>
<%=user.getUsername()%>さんがログインしています
<a href ="./MailSettingServlet?id=1"><img src="./mailtrue.png" class="mail" onclick="mailPermit(1);"></a>
<a href ="./MailSettingServlet?id=0"><img src="./mailfalse.png" class="mail" onclick="mailPermit(0);"></a>
<a href="./LogoutServlet" class="LogoutButton">ログアウト</a><br>
<br>
＊購入依頼の検索はここから->　<a href ="../order/orderSearching.jsp" class="LinkButton">依頼検索</a><br>
<br>
<br>
<div class="news">
<h1>検討が必要な依頼一覧</h1>
<ul>
<%for(int i=0; i<list.size(); i++){
	Order order = (Order)list.get(i);%>
	<li><a href="../order/ReadOrderServlet?id=<%=order.getRequestid()%>"><%=order.getRequestid()%></a>
	<c:out value="<%=order.getGoodsname()%>" /></li>
	<%} %>
</ul>

</div>

<div class="news">
<h1>経理の判断待ち依頼一覧</h1>
<ul>
<%for(int i=0; i<list2.size(); i++){
	Order order = (Order)list2.get(i);%>
	<li><a href="../order/ReadOrderServlet?id=<%=order.getRequestid()%>"><%=order.getRequestid()%></a>
	<c:out value="<%=order.getGoodsname()%>" /></li>
	<%} %>
</ul>

</div>
</BODY>
</HTML>