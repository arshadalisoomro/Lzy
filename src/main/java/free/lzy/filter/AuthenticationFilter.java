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

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;

import free.lzy.common.Code;
import free.lzy.common.Constants;
import free.lzy.common.FailResult;
import free.lzy.entity.bo.User;
import free.lzy.log.LzyLog;

/**
 * 过滤器
 */
public class AuthenticationFilter implements Filter {
	
	public void init(FilterConfig arg0) throws ServletException {}
	
	public void destroy() {}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		logAccessAPI(request);
		
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
	
	/*
	 * 记录访问信息
	 */
	private void logAccessAPI(HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
			String userId = user != null ? user.getId() : "NOT_LOGIN";
			String remoteAddr = request.getRemoteAddr();
			String method = request.getMethod(); 
			String requestURI = request.getRequestURI();
			String queryString = request.getQueryString();
			String userAgent = StringUtils.defaultString(request.getHeader("User-Agent"));
			requestURI = requestURI + (StringUtils.isNotEmpty(queryString) ? ("?" + queryString) : StringUtils.EMPTY);
			
			LzyLog.getAccessAPILogger().info(String.format("[%s] [%s] [%s] %s [%s]", userId, remoteAddr, method, requestURI, userAgent)); 
		} catch (Exception e) {
			LzyLog.getAccessAPILogger().warn("AccessAPI logger error: " + e.getMessage(), e);
		}
	}
}
