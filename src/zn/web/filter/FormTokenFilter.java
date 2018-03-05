package zn.web.filter;


import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 	Andy Hung
 * @version v1.0
 * 檢查user是否已經登入
 */

@WebFilter(
	urlPatterns = {"/message.do"}
)

public class FormTokenFilter implements Filter{
	
	@Override
	public void init(FilterConfig config) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		Random ran = new Random();
		String formhash = String.valueOf(ran.nextInt());
		Set<String> formhashSession = (Set<String>) req.getSession().getAttribute("formhashSession");
        if (formhashSession == null) {
             formhashSession = new HashSet<String>();
        }
        while (formhashSession.contains(formhash)) {
             formhash = String.valueOf(ran.nextInt());
        }
        formhashSession.add(formhash);
        req.setAttribute("formhash", formhash);
        req.getSession().setAttribute("formhashSession", formhashSession);
        chain.doFilter(req, response);
	}
	
}
