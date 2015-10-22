package free.lzy.common;

import com.alibaba.fastjson.JSONObject;

/**
 * 业务失败响应体
 * @ClassName Result
 * @date 2015-10-16
 */
public class FailResult {

	private String code;
	
	private String msg;
	
	private FailResult(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static String toJson(Code code, String msg) {
		return JSONObject.toJSONString(new FailResult(code.getCode(), msg), JSONFilter.NULLFILTER);
	}
}
