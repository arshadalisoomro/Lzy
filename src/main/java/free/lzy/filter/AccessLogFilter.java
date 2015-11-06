package free.lzy.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import free.lzy.common.Constants;
import free.lzy.entity.bo.User;
import free.lzy.log.LzyLog;

/**
 * 访问日志过滤器
 */
public class AccessLogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		logAccessAPI(request);
		
		chain.doFilter(request, response);
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
			String userAgent = StringUtils.defaultString(request.getHeader("User-Agent"));
			
			String queryString = request.getQueryString();
			if (queryString != null) {
				queryString = URLDecoder.decode(request.getQueryString(), Constants.CHARSET);
			}
			requestURI = requestURI + (StringUtils.isNotEmpty(queryString) ? ("?" + queryString) : StringUtils.EMPTY);
			
			LzyLog.getAccessAPILogger().info(String.format("[%s] [%s] [%s] %s [%s]", userId, remoteAddr, method, requestURI, userAgent)); 
		} catch (Exception e) {
			LzyLog.getAccessAPILogger().warn("AccessAPI logger error: " + e.getMessage(), e);
		}
	}
}
