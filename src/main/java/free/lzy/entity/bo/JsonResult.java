package free.lzy.entity.bo;

import org.apache.commons.lang.StringUtils;

public class JsonResult {
	
	/**
	 * 响应码
	 */
	private Code code;
	
	/**
	 * 响应描述
	 */
	private String msg = "";
	
	/**
	 * 响应时间戳
	 */
	private String timestamp = "";
	
	/**
	 * 响应数据
	 */
	private String data = "[]";
	
	public JsonResult(boolean isArray){
		this.setData(isArray ? "[]" : "{}");
	}
	
	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String toString(){
		StringBuilder buf = new StringBuilder();
		buf.append("{\"flag\":").append(this.code.getCode());
		buf.append(",\"msg\":\"").append(msg);
		buf.append("\",\"timestamp\":\"").append(this.timestamp);
		buf.append("\",\"data\":").append(StringUtils.defaultIfEmpty(this.data.trim(), "\"\""));
		buf.append("}");
		
		return buf.toString();
	}	
}
