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
package free.lzy.service.exception;

import free.lzy.common.Code;

/**
 * 业务异常
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private Code code;

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}
	
	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Code code, String message) {
		super(message);
		this.setCode(code);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	public ServiceException(Code code, String message, Throwable cause) {
		super(message, cause);
		this.setCode(code);
	}
	
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
