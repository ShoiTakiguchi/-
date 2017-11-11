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

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");


		String id = request.getParameter("id");
		String password = request.getParameter("password");

		LoginController manager = new LoginController();

		User user = new User();
		user = manager.certifyUser(id, password);

		if (user == null) {
			request.setAttribute("error", "IDとパスワードをもう一度確認してください");
			getServletContext().getRequestDispatcher("/jsp/user/index.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

				//response.sendRedirect(response.encodeRedirectURL("./user/studentMypage.jsp"));
				RequestDispatcher dispatch = request.getRequestDispatcher("./GoMypageServlet");
				dispatch.forward(request, response);
				//response.sendRedirect(response.encodeRedirectURL("./admin/adminTop.jsp"));
		}
	}
}
