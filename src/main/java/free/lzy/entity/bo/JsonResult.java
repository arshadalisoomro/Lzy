package free.lzy.entity.bo;

import org.apache.commons.lang.StringUtils;

public class JsonResult {
	
	private boolean flag;
	private String msg = "";
	private String data = "[]";
	private String timestamp_str = "";
	private String timestamp = "";
	
	public JsonResult(Boolean resultIsJsonArray){
		if (null == resultIsJsonArray){
			this.setData("");
			return;
		}
		if (resultIsJsonArray){
			this.setData("[]");
		}else{
			this.setData("{}");
		}
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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

	public String getTimestamp_str() {
		return timestamp_str;
	}

	public void setTimestamp_str(String timestamp_str) {
		this.timestamp_str = timestamp_str;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String toString(){
		StringBuilder buf = new StringBuilder();
		buf.append("{\"flag\":").append(this.isFlag());
		buf.append(",\"msg\":\"").append(msg);
		buf.append("\",\"timestamp_str\":\"").append(this.timestamp_str);
		buf.append("\",\"timestamp\":\"").append(this.timestamp);
		buf.append("\",\"data\":").append(StringUtils.defaultIfEmpty(this.data.trim(), "\"\""));
		buf.append("}");
		
		return buf.toString();
	}	
}
