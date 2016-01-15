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
package free.lzy.common;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * JSONFilter
 */
public class JSONFilter {
	
	private static final char UNDERLINE = '_';

	/**
	 * 当JSON字段值为null时, 字段值设置为空字符串
	 */
	public static final ValueFilter NULLFILTER = new ValueFilter() {
		@Override
		public Object process(Object obj, String s, Object value) {
			if (value == null) {
				return StringUtils.EMPTY;
			}
			return value;
		}
	};
	
	/**
	 * 当JSON字段Key为驼峰命名法时, 将其修改为下划线连接命名法
	 */
	public static final NameFilter UNDERLINEFILTER = new NameFilter() {

		@Override
		public String process(Object object, String name, Object value) {
			StringBuilder result = new StringBuilder();

			char[] chars = name.toCharArray();
			for (int i = 0; i < chars.length; ++i) {
				
				String c = String.valueOf(chars[i]);
				if (c.equals(c.toUpperCase())) {
					result.append(UNDERLINE);
					result.append(c.toLowerCase());
				} else {
					result.append(c);
				}
			}
			
			return result.toString();
		}
	};
}
