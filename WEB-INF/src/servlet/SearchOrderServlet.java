package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.OrderController;
import model.Order;

public class SearchOrderServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int req_id = 0;
		String kind = null;
		String name = null;
		ArrayList<String> keywordList = new ArrayList<String>(5);
		for(int i=0; i<5; i++) keywordList.add(null);
		//System.out.println(keywordList.size());

		int min_date = 0;
		int max_date = 0;
		int managementFlag = 0;
		int decision = 0;
		int delivery = 0;
		String username = null;


		if(request.getParameter("reqidcheck") != null) req_id = Integer.parseInt(request.getParameter("reqid"));
		if(request.getParameter("kindcheck") != null) kind = request.getParameter("kind");
		if(request.getParameter("namecheck") != null) name = request.getParameter("name");
		if(request.getParameter("keywordcheck") != null){
			//System.out.println("keyword");
			String lines = request.getParameter("keyword");
			String[] keywords = lines.split(",");
			for(int i=0; i<keywords.length; i++){

				keywordList.add(i,keywords[i]);
			}
		}
		if(request.getParameter("datecheck") != null){
			String Year = String.format("%04d", Integer.parseInt(request.getParameter("min_year")));
			String Month = String.format("%02d", Integer.parseInt(request.getParameter("min_month")));
			String Day = String.format("%02d", Integer.parseInt(request.getParameter("min_day")));
			String date = Year + Month + Day;
			//System.out.println(date);
			min_date = Integer.parseInt(date) * 100;
			Year = String.format("%04d", Integer.parseInt(request.getParameter("max_year")));
			Month = String.format("%02d", Integer.parseInt(request.getParameter("max_month")));
			Day = String.format("%02d", Integer.parseInt(request.getParameter("max_day")));
			date = Year + Month + Day;
			max_date = Integer.parseInt(date) * 100 + 99;
			//System.out.println(date);
		}
		if(request.getParameter("flagcheck") != null) managementFlag = Integer.parseInt(request.getParameter("flag"));
		if(request.getParameter("decisioncheck") != null) decision = Integer.parseInt(request.getParameter("decision"));
		if(request.getParameter("deliverycheck") != null) delivery = Integer.parseInt(request.getParameter("delivery"));
		if(request.getParameter("usernamecheck") != null) username = request.getParameter("username");



		OrderController controller = new OrderController();
		ArrayList<Order> list = controller.searchOrder(req_id, kind, name ,keywordList, min_date, max_date, managementFlag, decision, delivery, username);

		request.setAttribute("list",list);
		getServletContext().getRequestDispatcher("/jsp/order/orderSearching.jsp").forward(request, response);

	}

}
