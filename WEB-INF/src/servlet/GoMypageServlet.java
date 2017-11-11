package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.OrderController;
import model.News;
import model.Order;
import model.User;



public class GoMypageServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//RegistOrder order = (RegistOrder) session.getAttribute("order");
		User user = (User) session.getAttribute("user");

		OrderController ctrl = new OrderController();

		if(user.getRole() == 0){
			ArrayList<News> list = new ArrayList<News>();
			list = ctrl.getNews(user.getId());
			request.setAttribute("list",list);
			getServletContext().getRequestDispatcher("/jsp/user/studentMypage.jsp").forward(request, response);
		}else if(user.getRole() == 1){
			ArrayList<Order> list = new ArrayList<Order>();
			ArrayList<Order> list2 = new ArrayList<Order>();
			list = ctrl.getConsider();
			list2 = ctrl.getAccounting();
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			getServletContext().getRequestDispatcher("/jsp/user/managerMypage.jsp").forward(request, response);
		}

	}

}
