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

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 过滤器
 */
public class RestAuthenticationFilter implements Filter {
	
	private static final Logger LOGGER = Logger.getLogger("access_api");

	public void destroy() {

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		logAccessAPI(request);
		
		// TODO 登录状态验证
		// TODO 权限验证
		
		chain.doFilter(request, response);
	}
	
	/*
	 * 记录访问信息
	 */
	private void logAccessAPI(HttpServletRequest request) {
		try {
			String remoteAddr = request.getRemoteAddr();
			String method = request.getMethod(); 
			String requestURI = request.getRequestURI();
			String queryString = request.getQueryString();
			requestURI = requestURI + (StringUtils.isNotEmpty(queryString) ? ("?" + queryString) : StringUtils.EMPTY);
			
			LOGGER.debug(String.format("[%s] [%s] %s", remoteAddr, method, requestURI)); 
		} catch (Exception e) {
			LOGGER.warn("AccessAPI logger error: " + e.getMessage(), e);
		}
	}

}
