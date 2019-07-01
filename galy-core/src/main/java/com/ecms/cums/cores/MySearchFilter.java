package com.ecms.cums.cores;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;
/**
 * @ClassName: MySearchFilter
 * @Description: 过滤掉map中空值
 * @author: zJin
 * @date: 2018年5月21日 下午3:23:29
 */
public class MySearchFilter {

	public static Map<String, Object> filter(Map<String, Object> searchParams) {

		Map<String, Object> filters = Maps.newHashMap();
		for (Entry<String, Object> entry : searchParams.entrySet()) {
			// 过滤掉空值
			String key = entry.getKey();
			Object value = entry.getValue();
			if (StringUtils.isBlank((String) value)) {
				continue;
			}
			filters.put(key, StringUtils.trim((String) value));
		}
		return filters;
	}
}
