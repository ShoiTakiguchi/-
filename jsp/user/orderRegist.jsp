<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="model.Order"%>
<% Order order = (Order) session.getAttribute("order"); %>
<html>
<script type="text/javascript" src="../../js/regist.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/regist.css">
<head>
<title>依頼登録</title>
</head>
<body>
	<font size="16">依頼登録</font>
	<FORM method="post" action="../ConfirmOrderServlet">
	<table border="1" class="registbox">
	<tr>
	<th bgcolor=#FFCC33 align="center">依頼内容を入力してください</th>
	</tr>
	<tr>
	<td>
		書籍<input type="radio" name="kind" id="book" value="書籍" onclick="booktext(this.checked);" required>
		文具<input type="radio" name="kind" id="notbook" value="文具" onclick="anothertext(this.checked);">
		電子機器<input type="radio" name="kind" id="notbook" value="電子機器" onclick="anothertext(this.checked);">
		その他<input type="radio" name="kind" id="notbook" value="その他" onclick="anothertext(this.checked);"><br>
		名称　　　　:<input type="text" name="goodsname"
		value="<%if(order!=null){if(order.getGoodsname()!=null)out.println(order.getGoodsname()); }%>" required><br>
		著者名　　　:<input type="text" name="author" id="author"
		value="<%if(order!=null){if(order.getAuthor()!=null)out.println(order.getAuthor()); }%>" required disabled><br>
		ISBNは半角数字で入力してください<br>入力例:○○○-○○○○○○○○○○<br>
		ISBN 　　　:<input type="text" name="isbn" id="isbn"
		value="<%if(order!=null){if(order.getIsbn()!=null)out.println(order.getIsbn()); }%>" pattern="\d{3}-\d{10}" required disabled><br>
		出版社　　　:<input type="text" name="publisher" id="publisher"
		value="<%if(order!=null){if(order.getPublisher()!=null)out.println(order.getPublisher());} %>" required disabled><br>
		キーワード　:<input type="text" name="keyword" id="keyword"
		value="<%if(order!=null){if(order.getFulKeyword()!=null)out.println(order.getFulKeyword());} %>" required disabled><br>
		単価　　　　:<input type="text" name="cost" pattern="[0-9]{1,6}"
		value="<%if(order!=null)out.println(order.getCost()); %>" required><br>
		個数　　　　:<input type="text" name="number" pattern="[0-9]{1,3}"
		value="<%if(order!=null)out.println(order.getNumber()); %>" required><br>
		依頼理由　　:<input type="text" name="reason"
		value="<%if(order!=null){if(order.getReason()!=null)out.println(order.getReason());} %>" required><br>
		備考　　　　<input type="text" name="note"
		value="<%if(order!=null){if(order.getNote()!=null)out.println(order.getNote());} %>" ><br>

		<div class="button"><button class ="confirmbutton" type="submit" value="">確認画面に移る</button></div>
	</td>
	</tr>
	</FORM>
	</table>
</body>
</html>