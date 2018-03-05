package zn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zn.model.UserService;

/**
 * @author Andy Hung
 * @version v1.0 檢查user是否已登入
 */

@WebServlet(
		urlPatterns = { "/login.do" }, 
		initParams = { 
				@WebInitParam(name = "SUCCESS_VIEW", value = "message.do"),
				@WebInitParam(name = "ERROR_VIEW", value = "index.jsp"), 
		}
)

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String SUCCESS_VIEW;
	private String ERROR_VIEW;

	@Override
	public void init() throws ServletException {
		SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
		ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		response.sendRedirect("index.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 創建UserService物件
		UserService userService = (UserService) getServletContext().getAttribute("userService");
		if (userService.checkLogin(username, password)) {
			request.getSession().setAttribute("login", username);
			response.sendRedirect(SUCCESS_VIEW);
		} else {
			request.setAttribute("error", "使用者名稱或密碼錯誤");
			request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
		}
	}

}
