package free.lzy.common;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * JSONFilter
 */
public class JSONFilter {

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
}
