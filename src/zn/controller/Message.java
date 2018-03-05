package zn.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zn.model.Blah;
import zn.model.UserService;

/**
 * @author Andy Hung
 * @version v1.0 新增留言
 */

@WebServlet(
		urlPatterns = { "/message.do" }, 
		initParams = { @WebInitParam(name = "MEMBER_VIEW", value = "member.jsp") }
)
public class Message extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String MEMBER_VIEW;

	public void init() throws ServletException {
		MEMBER_VIEW = getServletConfig().getInitParameter("MEMBER_VIEW");
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//檢查是否重複登入的flag
        String formhash = request.getParameter("formhash");
        Set<String> formhashSession = (Set<String>) request.getSession().getAttribute("formhashSession");
    	
        String username = (String) request.getSession().getAttribute("login");
		UserService userService = (UserService) getServletContext().getAttribute("userService");
		Blah blah = new Blah();
		blah.setUsername(username);
		String blabla = request.getParameter("blabla");
		if (formhashSession == null || !formhashSession.contains(formhash)) {
			System.out.println("重複提交囉");
       }else{
			if (blabla != null && blabla.length() != 0) {
				request.removeAttribute("error");
				if (blabla.length() < 140) {
					blah.setDate(new Date());
					blah.setTxt(blabla);
					userService.addBlah(blah);
					formhashSession.remove(formhash);
			    	request.getSession().setAttribute("formhashSession", formhashSession);
				} else {
					request.setAttribute("blabla", blabla);
				}
		    }else {
		    	request.setAttribute("error", "請輸入留言");
		    }
		}
		List<Blah> blahs = userService.getBlahs(blah);
		request.setAttribute("blahs", blahs);
		request.getRequestDispatcher(MEMBER_VIEW).forward(request, response);
        
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
