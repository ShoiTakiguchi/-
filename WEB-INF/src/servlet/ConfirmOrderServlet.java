package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;

public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");


		String kind = request.getParameter("kind");
		String goodsname = request.getParameter("goodsname");

        //判定するパターンを生成
       /* Pattern p = Pattern.compile("^\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}$");
        Matcher m = p.matcher(isbn);*/

        //画面表示
        /*System.out.println(m.find());

		String[] isbnArray = isbn.split("");
		for (int i = 0; i < isbnArray.length; i++) {
		   System.out.println("isbnArrayの要素番号" + i + "の時：" + isbnArray[i]);
		}
		System.out.println(m.find());*/
		int cost = Integer.parseInt(request.getParameter("cost"));
		int number = Integer.parseInt(request.getParameter("number"));
		String reason = request.getParameter("reason");
		String note = request.getParameter("note");

		Order order = new Order();

		order.setKind(kind);
		order.setGoodsname(goodsname);
		order.setCost(cost);
		order.setNumber(number);
		order.setReason(reason);

		if(kind.equals("書籍")){
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String fulKeyword = request.getParameter("keyword");

		order.setAuthor(author);
		order.setIsbn(isbn);
		order.setPublisher(publisher);
		order.setFulKeyword(fulKeyword);
		}
		if(note != null) order.setNote(note);

		HttpSession session = request.getSession();
		session.setAttribute("order", order);

		//if(!isbnArray[3].equals("-") || !isbnArray[5].equals("-") || !isbnArray[8].equals("-") || !isbnArray[15].equals("-")) {

		//if(m.find()==true) {
			request.setAttribute("order", order);
			request.getRequestDispatcher("user/confirmOrder.jsp").forward(request, response);
		/*}if(m.find()==false) {
			request.setAttribute("isbn", "エラー :" + isbn + " は指定された入力方法ではありません");
			getServletContext().getRequestDispatcher("/jsp/user/orderRegist.jsp").forward(request, response);}*/


	}
}
