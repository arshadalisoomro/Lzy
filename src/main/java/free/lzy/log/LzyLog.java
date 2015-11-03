package free.lzy.log;

import org.apache.log4j.Logger;

/**
 * 统一日志工具类
 */
public class LzyLog {

	/*
	 * RestApi日志
	 * 		接口访问日志
	 */
	private static final Logger ACCESS_API = Logger.getLogger("access_api");
	
	/*
	 * RestError日志
	 * 		接口异常日志
	 */
	private static final Logger REST_ERROR = Logger.getLogger("rest_error");
	
	/*
	 * BusinessFail日志
	 * 		业务失败日志
	 */
	private static final Logger BUSINESS_FAIL = Logger.getLogger("business_fail");
	
	/**
	 * Get Logger
	 */
	public static Logger getLogger(Class<?> clazz) {
		return Logger.getLogger(clazz);
	}
	
	/**
	 * 获取RestApi Logger
	 */
	public static Logger getAccessAPILogger() {
		return ACCESS_API;
	}
	
	/**
	 * 获取RestError Logger
	 */
	public static Logger getRestErrorLogger() {
		return REST_ERROR;
	}
	
	/**
	 * 获取BusinessFail Logger
	 */
	public static Logger getBusinessFailLogger() {
		return BUSINESS_FAIL;
	}
}

