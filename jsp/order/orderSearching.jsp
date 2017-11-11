<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="model.Order" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "model.Order" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
ArrayList list =  (ArrayList)request.getAttribute("list");
int year=0;
int month=0;
int day=0;
%>

<HTML>
<script type="text/javascript" src="../../js/search.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/search.css">
<HEAD>
<TITLE>依頼検索</TITLE>
</HEAD>
<BODY>
<font size="16">依頼検索</font>
<form method="POST" action="./SearchOrderServlet">
<table border="1" class="searchbox">
<tr>
	<th bgcolor=#FAAC58 align="center">絞り込み検索</th>
</tr>

<tr>
	<td>
	<!-- <input type="hidden" name="reqidcheck" value=null> -->
	<input type="checkbox" name="reqidcheck" value="1"
	onclick="connecttext('reqidtext',this.checked);">依頼ID　　　　　：
	<input type="text" name="reqid" id="reqidtext" pattern="[0-9]{10}" value="" disabled>
	<br>

	<!--  <input type="hidden" name="kindcheck" value=null> -->
	<input type="checkbox" name="kindcheck" value="1"
	onclick="connectradio('kind',this.checked);">種別　　　　　　：
	<input type="radio" name="kind" id="kind0" value="書籍" disabled>書籍
	<input type="radio" name="kind" id="kind1" value="文具" disabled>文具
	<input type="radio" name="kind" id="kind2" value="電子機器" disabled>電子機器
	<input type="radio" name="kind" id="kind3" value="その他" disabled>その他
	<br>

	<!--  <input type="hidden" name="namecheck" value=null> -->
	<input type= "checkbox" name="namecheck" value="1"
	onclick="connecttext('nametext',this.checked);">名称　　　　　　：
	<input type="text" name="name" id="nametext" value="" disabled>
	<br>

	<!--  <input type="hidden" name="keywordcheck" value=null> -->
	<input type="checkbox" name="keywordcheck" value="1"
	onclick="connecttext('keywordtext',this.checked);">書籍キーワード　：
	<input type="text" name="keyword" id="keywordtext" value="" disabled>
	<br>

	<!-- <input type="hidden" name="datecheck" value=null> -->
	<input type="checkbox" name="datecheck" value="1"
	onclick="connectdate('min_year','min_month','min_day','max_year','max_month','max_day',this.checked);">日付　　　　　　：
	<select name="min_year" id="min_year" disabled>
		<% for (year = 2017; year < 2050; year++){%>
		<option value="<%=year%>"><%=year%></option>
		<%} %>
	</select>
	<select name="min_month" id="min_month" disabled>
		<% for (month = 1; month < 12; month++){%>
		<option value="<%=month%>"><%=month%></option>
		<%} %>
	</select>
	<select name="min_day" id="min_day" disabled>
		<% for (day = 1; day < 31; day++){%>
		<option value="<%=day%>"><%=day%></option>
		<%} %>
	</select>
	<select name="max_year" id="max_year" disabled>
		<% for (year = 2017; year < 2050; year++){%>
		<option value="<%=year%>"><%=year%></option>
		<%} %>
	</select>
	<select name="max_month" id="max_month" disabled>
		<% for (month = 1; month < 12; month++){%>
		<option value="<%=month%>"><%=month%></option>
		<%} %>
	</select>
	<select name="max_day" id="max_day" disabled>
		<% for (day = 1; day < 31; day++){%>
		<option value="<%=day%>"><%=day%></option>
		<%} %>
	</select>
	<br>

	<!-- <input type="hidden" name="flagcheck" value=null> -->
	<input type="checkbox" name="flagcheck" value="1"
	onclick="connectradio('flag',this.checked);">購入管理フラグ　：
	<input type="radio" name="flag" id="flag0" value="2" disabled>許可
	<input type="radio" name="flag" id="flag1" value="1" disabled>検討中
	<input type="radio" name="flag" id="flag2" value="3" disabled>不可
	<br>

	<!--  <input type="hidden" name="decisioncheck" value=null> -->
	<input type="checkbox" name="decisioncheck" value="1"
	onclick="connectradio('decision',this.checked);">経理判断　　　　：
	<input type="radio" name="decision" id="decision0" value="1" disabled>判断待ち
	<input type="radio" name="decision" id="decision1" value="2" disabled>購入許可
	<input type="radio" name="decision" id="decision2" value="3" disabled>不可
	<br>

	<!--  <input type="hidden" name="deliverycheck" value=null> -->
	<input type="checkbox" name="deliverycheck" value="1"
	onclick="connectradio('delivery',this.checked);">納品状況　　　　：
	<input type="radio" name="delivery" id="delivery0" value="1" disabled>未納品
	<input type="radio" name="delivery" id="delivery1" value="2" disabled>納品済
	<br>

	<!-- <input type="hidden" name="usernamecheck" value=null> -->
	<input type="checkbox" name="usernamecheck" value="1"
	onclick="connecttext('usernametext',this.checked);">依頼者　　　　　：
	<input type="text" name="username" id="usernametext" value="" disabled>
	<br>
	<div class="button"><button class="searchbutton" type="submit" value="">検索</button></div>
	</td>

</tr>
</form>

</table>

<br>

<%if (list != null){ %>

<font align="left">検索結果　

<%=list.size()%>件
　　　　　　　　　　　　　　　　
日付　<!-- ソートボタン上下 --></font>
<br>

<table class="resultbox" border="1">
<TBODY>
<% for(int i=0;i<list.size();i++) {%>
<%Order order = (Order)list.get(i);%>
<TR>
<TD>
<a href="./ReadOrderServlet?id=<%=order.getRequestid()%>">
	<%=order.getRequestid()%>　　　<%=order.getKind()%>:<c:out value="<%=order.getGoodsname()%>" /></a>

</TD>
</TR>
<% } %>
<% } %>

</TBODY>
</table>

<a href="../user/GoMypageServlet" class="mypage">マイページに戻る</a>

</form>
</BODY>
</HTML>






