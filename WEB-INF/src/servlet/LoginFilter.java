package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
		    try{

		    	//System.out.println("filter");
		      HttpSession session = ((HttpServletRequest)request).getSession();

		      if(session.getAttribute("user") == null){
		    	  RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/user/LogoutServlet");
		            dispatcher.forward(request,response);

		      }else{
		    	  chain.doFilter(request, response);
		      }

		    }catch (ServletException se){
		    }catch (IOException e){
		    }
		  }


	  public void init(FilterConfig filterConfig) throws ServletException{
	  }

	  public void destroy(){
	  }
}