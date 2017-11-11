package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.MailController;
import controller.OrderController;
import model.Order;
//import model.RegistOrder;
import model.User;


public class RegistOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		//RegistOrder order = (RegistOrder) session.getAttribute("order");
		Order order = (Order) session.getAttribute("order");
		User user = (User) session.getAttribute("user");


		//Order order = new Order();

		String kind = order.getKind();
		String goodsname = order.getGoodsname();
		int cost = order.getCost();
		int number = order.getNumber();
		String reason = order.getReason();

		String author=null;
		String isbn=null;
		String publisher=null;
		String fulKeyword=null;

		if(kind.equals("書籍")){
			author = order.getAuthor();
			isbn = order.getIsbn();
			publisher = order.getPublisher();
			fulKeyword = order.getFulKeyword();
		}

		String id = user.getId();

		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		month = String.format("%2s",month).replace(" ", "0");
		String day = String.valueOf(cal.get(Calendar.DATE));
		day = String.format("%2s",day).replace(" ", "0");
		String date = year + month + day;
		int today = Integer.parseInt(date) * 100;
		int limitRequestNumber = today + 100;

		OrderController controller = new OrderController();
		MailController ctrl = new MailController();

		int reqId=controller.serchRequestId(today);

		if (reqId < limitRequestNumber) {
			controller.registOrder(reqId, kind, goodsname, author, isbn, publisher, fulKeyword, cost, number, reason, id);
			ctrl.registMail(reqId, goodsname, user.getMailaddress(),user.getPer_mail(),user.getUsername());

			request.setAttribute("reqId", "依頼ID :" + reqId + " として登録されました");

			getServletContext().getRequestDispatcher("/jsp/user/confirmOrder.jsp").forward(request, response);
			//response.sendRedirect(response.encodeRedirectURL("/Springwork/jsp/user/confirmOrder.jsp"));

			HttpSession ordersession = request.getSession();

			if (ordersession!=null) {
				ordersession.removeAttribute("order");
			}
		} else {
			request.setAttribute("reqId", "今日はこれ以上登録できません");

			getServletContext().getRequestDispatcher("/jsp/user/confirmOrder.jsp").forward(request, response);

		}
	}
}
