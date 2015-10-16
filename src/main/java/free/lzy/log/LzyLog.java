package free.lzy.log;

import org.apache.log4j.Logger;

/**
 * @ClassName LzyLog
 * @Description 统一日志工具类
 * @date 2015-10-15
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
	 * 获取RestApi Logger
	 * @Title: getAccessAPILogger 
	 * @return RestApi Logger
	 * @Date 2015-7-28
	 */
	public static Logger getAccessAPILogger() {
		return ACCESS_API;
	}
	
	/**
	 * 获取RestError Logger
	 * @Title: getRestErrorLogger 
	 * @return RestError Logger
	 * @Date 2015-10-16
	 */
	public static Logger getRestErrorLogger() {
		return REST_ERROR;
	}
	
	/**
	 * 获取BusinessFail Logger
	 * @Title: getBusinessFailLogger 
	 * @return BusinessFail Logger
	 * @Date 2015-10-16
	 */
	public static Logger getBusinessFailLogger() {
		return BUSINESS_FAIL;
	}
}

