/**
 * Copyright (c) 2015, adar.w (adar.w@outlook.com) 
 * 
 * http://www.adar-w.me
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pers.adar.lzy.common;

/**
 * 响应结果状态码
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
	 * 资源不存在
	 */
	NOT_EXSIT("20001"),
	
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
