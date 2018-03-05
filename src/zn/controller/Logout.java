package zn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 	Andy Hung
 * @version v1.0
 * 登出
 */

@WebServlet(
		urlPatterns = {"/logout.do"},
		initParams = {
				@WebInitParam(name="LOGIN_VIEW", value="index.jsp")
		}
)
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String LOGIN_VIEW;
	
	@Override
	public void init() throws ServletException {
		LOGIN_VIEW = getServletConfig().getInitParameter("LOGIN_VIEW");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getSession().invalidate();
		response.sendRedirect(LOGIN_VIEW);
	}
}
