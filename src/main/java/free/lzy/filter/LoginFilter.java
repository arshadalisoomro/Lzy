package free.lzy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;

import free.lzy.common.Code;
import free.lzy.common.Constants;
import free.lzy.common.FailResult;
import free.lzy.entity.bo.User;

/**
 * 登录过滤器
 */
public class LoginFilter implements Filter {
	
	public void init(FilterConfig arg0) throws ServletException {}
	
	public void destroy() {}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		if (loginCheck(request, response)) {
			chain.doFilter(request, response);
		}
	}
	
	/**
	 * 登录验证
	 */
	private boolean loginCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean flag = true;
		
		if (request.getRequestURI().endsWith(Constants.URL_LOGIN)) {
			// Flag = true.
		} else {
			// 判断登录状态
			HttpSession session = request.getSession(false);
			if (session != null) {
				User user = (User) session.getAttribute(Constants.SESSION_USER);
				if (user == null) {
					flag = false;
					
					response.setStatus(HttpStatus.UNAUTHORIZED.value());
					response.setContentType(MediaType.APPLICATION_JSON);
					response.getWriter().print(FailResult.toJson(Code.UNLOGIN, "用户未登录"));
				}
			} else {
				flag = false;
				
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				response.setContentType(MediaType.APPLICATION_JSON);
				response.getWriter().print(FailResult.toJson(Code.SESSION_TIMEOUT, "SESSION已过期"));
			}
		}
		
		return flag;
	}
}
