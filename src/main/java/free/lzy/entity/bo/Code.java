package free.lzy.entity.bo;

/**
 * 响应结果状态码
 * @ClassName Code
 * @date 2015-10-15
 */
public enum Code {
	
	/**
	 * 业务成功
	 */
	OK("10000"), 
	
	/**
	 * 业务失败
	 */
	FAIL("20000"),
	
	/**
	 * 未登录 或 Session过期
	 */
	UNLOGIN("30000"),

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
