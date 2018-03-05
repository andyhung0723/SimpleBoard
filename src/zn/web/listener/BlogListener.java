package zn.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import zn.model.UserService;

/**
 * @author 	Andy Hung
 * @version v1.0
 * 創建UserService實例
 */

@WebListener

public class BlogListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String USERS = sce.getServletContext().getInitParameter("USERS");
		context.setAttribute("userService", new UserService(USERS));
	}
	
}
