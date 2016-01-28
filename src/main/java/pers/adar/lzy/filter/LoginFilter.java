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
package pers.adar.lzy.filter;

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

import pers.adar.lzy.common.Code;
import pers.adar.lzy.common.Constants;
import pers.adar.lzy.common.FailResult;
import pers.adar.lzy.entity.bo.User;

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
		
		HttpSession session = request.getSession(false);
		if (request.getRequestURI().endsWith(Constants.URL_LOGIN)) {
			if (session != null) {
				session.invalidate();
			}
		} else {
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
