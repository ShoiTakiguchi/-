package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginController;
import model.User;

public class MailSettingServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		LoginController ctrl = new LoginController();

		int perMail = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		//System.out.println(perMail+user.getId());

		ctrl.changeMail(user.getId(),perMail);

		RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/user/GoMypageServlet");
		dispatch.forward(request, response);


	}



}
