package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.OrderController;
import model.Order;

public class ReadOrderServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//System.out.println(Integer.parseInt(request.getParameter("id")));
		OrderController controller = new OrderController();

		Order order = controller.readOrder(Integer.parseInt(request.getParameter("id")));

		//userid -> name
		String username = controller.namecheck(order.getUserid());

		request.setAttribute("order",order);
		request.setAttribute("username",username);
		getServletContext().getRequestDispatcher("/jsp/order/orderReading.jsp").forward(request, response);

	}
}
