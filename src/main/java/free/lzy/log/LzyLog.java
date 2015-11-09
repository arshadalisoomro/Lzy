package free.lzy.log;

/**
 * 统一日志工具类
 */
public class LzyLog {

	/*
	 * RestApi日志 接口访问日志
	 */
	private static final Logger ACCESS_API = Logger.newInstance("access_api");

	/*
	 * RestError日志 接口异常日志
	 */
	private static final Logger REST_ERROR = Logger.newInstance("rest_error");

	/*
	 * BusinessFail日志 业务失败日志
	 */
	private static final Logger BUSINESS_FAIL = Logger.newInstance("business_fail");

	/**
	 * Get Logger
	 */
	public static Logger getLogger(Class<?> clazz) {
		return Logger.newInstance(clazz);
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
