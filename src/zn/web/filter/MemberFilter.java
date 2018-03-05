package zn.web.filter;


import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 	Andy Hung
 * @version v1.0
 * 檢查user是否已經登入
 */

@WebFilter(
			urlPatterns = {"/delete.do", "/message.do", "/member.jsp", "/logout.do"},
			initParams = {
					@WebInitParam(name = "LOGIN_VIEW", value = "index.jsp")
			}
)

public class MemberFilter implements Filter{
	
	private String LOGIN_VIEW;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.LOGIN_VIEW = config.getInitParameter("LOGIN_VIEW");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		if(req.getSession().getAttribute("login") != null) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect(LOGIN_VIEW);
		}
	}
	
}
