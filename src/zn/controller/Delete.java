package zn.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zn.model.Blah;
import zn.model.UserService;

/**
 * @author 	Andy Hung
 * @version v1.0
 * 刪除留言
 */

@WebServlet(
		urlPatterns = {"/delete.do"},
		initParams = {
				@WebInitParam(name = "SUCCESS_VIEW", value = "message.do")
		}
)
public class Delete extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String SUCCESS_VIEW;
    
    public void init() throws ServletException {
    	SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
    }
    
	protected void doGet(HttpServletRequest request, 
	                     HttpServletResponse response) 
	                         throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("login");
        String message = request.getParameter("message"); 
		UserService userService = (UserService)getServletContext().getAttribute("userService");
        Blah blah = new Blah();
        blah.setUsername(username);
        blah.setDate(new Date(Long.parseLong(message)));
        userService.deleteBlah(blah);
        response.sendRedirect(SUCCESS_VIEW);
	}
}
