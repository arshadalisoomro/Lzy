package free.lzy.common;

/**
 * 响应结果状态码
 * @ClassName Code
 * @date 2015-10-15
 * 
 * 
 * Code 规范：
 * 		1XXXX: 业务处理过程中发生错误
 * 		2XXXX: 调用者方调用方式有误
 * 		3XXXX: 与业务无关的其他错误
 * 		4XXXX: 系统错误
 */
public enum Code {
	
	/**
	 * 业务失败
	 */
	BUSINESS_FAIL("10000"), 
	
	/**
	 * 参数有误
	 */
	PARAM_ERROR("20000"),
	
	/**
	 * 用户未登录
	 */
	UNLOGIN("30000"),
	
	/**
	 * 会话已过期
	 */
	SESSION_TIMEOUT("30001"),

	/**
	 * 系统异常
	 */
	ERROR("40000");
	
	/**
	 * 状态码
	 */
	private String code;
	
	private Code(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
