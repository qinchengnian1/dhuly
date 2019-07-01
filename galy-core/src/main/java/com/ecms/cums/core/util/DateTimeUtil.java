package com.ecms.cums.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	/**
	 * 获取当前UTC时间
	 *
	 * @author 宋士恩
	 * @return
	 */
	public static Date createUTCNowDateTime() {
		// 1、取得本地时间：
		final java.util.Calendar cal = java.util.Calendar.getInstance();
		// 2、取得时间偏移量：
		final int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		final int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		return cal.getTime();
	}

	public static Date createUTCNowDateTimeByGiveTime(String nowTime)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 1、取得本地时间：
		final java.util.Calendar cal = java.util.Calendar.getInstance();
		if (nowTime != null && !"".equals(nowTime)) {
			cal.setTime(sdf.parse(nowTime));
		}
		// 2、取得时间偏移量：
		final int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		final int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		return cal.getTime();
	}

	public static Date createUTCNowDateTimeByGiveTime1(String nowTime)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// 1、取得本地时间：
		final java.util.Calendar cal = java.util.Calendar.getInstance();
		if (nowTime != null && !"".equals(nowTime)) {
			cal.setTime(sdf.parse(nowTime));
		}
		// 2、取得时间偏移量：
		final int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		final int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		return cal.getTime();
	}

	private static final long ONE_MINUTE_IN_MILLIS = 60000; // millisecs

	public static Date reduceMinute(Date date, int minute) {
		long t = date.getTime();
		return new Date(t - (minute * ONE_MINUTE_IN_MILLIS));
	}

	public static Date reduceHour(Date date, int hour) {
		long t = date.getTime();
		return new Date(t - (hour * 60 * ONE_MINUTE_IN_MILLIS));
	}

}
