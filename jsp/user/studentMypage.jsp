<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "java.util.Calendar" %>
<%@ page import="model.Order" %>
<%@ page import="model.News" %>
<%@ page import="model.User" %>
<% User user = (User) session.getAttribute("user");%>
<% ArrayList<News> list = (ArrayList<News>)request.getAttribute("list");%>

<HTML>
<script type="text/javascript" src="../../js/mypage.js"></script>
<HEAD>
<TITLE>依頼者マイページ</TITLE>
</HEAD>

<font size="16">マイページ</font><br><br>
<link rel="stylesheet" type="text/css" href="../../css/mypage.css">

<span class="role">依頼者</span>
<%=user.getUsername()%>さんがログインしています
<a href ="./MailSettingServlet?id=1"><img src="./mailtrue.png" class="mail" onclick="mailPermit(1);"></a>
<a href ="./MailSettingServlet?id=0"><img src="./mailfalse.png" class="mail" onclick="mailPermit(0);"></a>
<a href="./LogoutServlet" class="LogoutButton">ログアウト</a><br>
<br>
＊備品の購入依頼はここから->　<a href ="../user/orderRegist.jsp" class="LinkButton">依頼登録</a><br>
<br>
＊購入依頼の検索はここから->　<a href ="../order/orderSearching.jsp" class="LinkButton">依頼検索</a><br>
<br>
<br>
<div class="news">
<h1>お知らせ</h1>
<ul>
<%if(list==null)out.println("お知らせはありません");
else{%>
<%for(int i=0; i<list.size(); i++){
	News news = (News)list.get(i);%>
	<li><a href="../order/ReadOrderServlet?id=<%=news.getRequestid()%>"><%=news.getRequestid()%></a>
	<%if(news.isDelnews()) out.println("  新しい備品が納品されました ");

	else if(news.isDecnews()) out.println("  あなたの依頼が経理に許可されました ");
	else if(news.isMannews()) out.println("  あなたの依頼が管理者に更新されました ");
	%></li>
	<%} }%>

</ul>
</div>
</BODY>
</HTML>