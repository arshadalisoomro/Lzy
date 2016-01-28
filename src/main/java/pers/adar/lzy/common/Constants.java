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
 * Constants
 */
public final class Constants {

	/**
	 * 系统运行时路径
	 */
	public static final String WEB_ROOT = System.getProperty("webapp.root");
	
	/**
	 * 系统登录路径
	 */
	public static final String URL_LOGIN = "/services/login";
	
	/**
	 * 当前登录用户SESSION KEY
	 */
	public static final String SESSION_USER = "SESSION_USER";
	
	/**
	 * 系统编码
	 */
	public static final String CHARSET = "UTF-8";
}