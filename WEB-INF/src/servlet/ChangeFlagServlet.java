package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.MailController;
import controller.OrderController;
import model.User;

public class ChangeFlagServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		String flag = request.getParameter("flag");
		int condition = Integer.parseInt(request.getParameter(flag));
		int req_id = Integer.parseInt(request.getParameter("reqid"));

		OrderController ctrl = new OrderController();
		ctrl.changeflag(req_id,flag,condition);

		if(flag.equals("delflg")){

		String goodsname = request.getParameter("goodsname");

		MailController mailctrl = new MailController();
		mailctrl.deliveryMail(req_id, goodsname, user.getMailaddress(), user.getPer_mail(), user.getUsername());

		}
		//response.sendRedirect(response.encodeRedirectURL("/Springwork/jsp/order/orderReading.jsp"));
		RequestDispatcher dispatch = request.getRequestDispatcher("ReadOrderServlet?id="+req_id);
		dispatch.forward(request, response);
}
}
