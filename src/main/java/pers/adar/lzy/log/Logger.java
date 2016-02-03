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
package pers.adar.lzy.log;

public class Logger {
	
	private org.apache.log4j.Logger logger;
	
	/*
	 * RestAccess日志 接口访问日志
	 */
	private static final Logger REST_ACCESS = Logger.getLogger("rest_access");

	/*
	 * RestFail日志 接口异常日志
	 */
	private static final Logger REST_FAIL = Logger.getLogger("rest_fail");

	/*
	 * BusinessFail日志 业务失败日志
	 */
	private static final Logger BUSINESS_FAIL = Logger.getLogger("business_fail");
	
	private Logger(org.apache.log4j.Logger logger) {
		this.logger = logger;
	}

	public static Logger getLogger(String logger) {
		return new Logger(org.apache.log4j.Logger.getLogger(logger));
	}

	public static Logger getLogger(Class<?> logger) {
		return getLogger(logger.getName());
	}

	public static Logger getRestAccessLogger() {
		return REST_ACCESS;
	}

	public static Logger getRestFailLogger() {
		return REST_FAIL;
	}

	public static Logger getBusinessFailLogger() {
		return BUSINESS_FAIL;
	}
	
	public void info(String message) {
		logger.info(message);
	}

	public void info(String message, Throwable t) {
		logger.info(message, t);
	}

	public void debug(String message) {
		logger.debug(message);
	}
	
	public void debug(String message, Throwable t) {
		logger.debug(message, t);
	}
	
	public void warn(String message) {
		logger.warn(message);
	}
	
	public void warn(String message, Throwable t) {
		logger.warn(message, t);
	}
	
	public void error(String message) {
		logger.error(message);
	}
	
	public void error(String message, Throwable t) {
		logger.error(message, t);
	}
}
