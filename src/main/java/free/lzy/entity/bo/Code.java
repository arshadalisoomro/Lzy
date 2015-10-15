package free.lzy.entity.bo;


/**
 * 响应结果状态码
 * @ClassName Code
 * @date 2015-10-15
 */
public enum Code {
	
	OK("10000"), ERROR("20000"), UNLOGIN("30000");
	
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
