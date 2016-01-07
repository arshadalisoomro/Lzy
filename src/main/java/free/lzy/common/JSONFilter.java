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
