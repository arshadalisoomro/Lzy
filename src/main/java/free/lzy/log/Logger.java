package free.lzy.log;

import org.slf4j.LoggerFactory;

public class Logger {
	
	private org.slf4j.Logger logger;
	
	/*
	 * RestApi日志 接口访问日志
	 */
	private static final Logger ACCESS_API = Logger.getLogger("access_api");

	/*
	 * RestError日志 接口异常日志
	 */
	private static final Logger REST_ERROR = Logger.getLogger("rest_error");

	/*
	 * BusinessFail日志 业务失败日志
	 */
	private static final Logger BUSINESS_FAIL = Logger.getLogger("business_fail");
	
	private Logger(org.slf4j.Logger logger) {
		this.logger = logger;
	}

	public static Logger getLogger(String logger) {
		return new Logger(LoggerFactory.getLogger(logger));
	}

	public static Logger getLogger(Class<?> logger) {
		return getLogger(logger.getName());
	}

	public static Logger getAccessAPILogger() {
		return ACCESS_API;
	}

	public static Logger getRestErrorLogger() {
		return REST_ERROR;
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
