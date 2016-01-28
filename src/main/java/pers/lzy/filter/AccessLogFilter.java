/**
 * Copyright (c) 2015, adar.w (adar.w@outlook.com) 
 * 
 * http://www.adar-w.me
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pers.lzy.filter;

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

import pers.lzy.common.Constants;
import pers.lzy.entity.bo.User;
import pers.lzy.log.Logger;

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
			
			Logger.getAccessAPILogger().info(String.format("[%s] [%s] [%s] %s [%s]", userId, remoteAddr, method, requestURI, userAgent)); 
		} catch (Exception e) {
			Logger.getAccessAPILogger().warn("AccessAPI logger error: " + e.getMessage(), e);
		}
	}
}
