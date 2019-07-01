package com.ecms.cums.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtil {

	/**日志对象.*/
    private static final Logger LOGGER = Logger.getLogger(DateUtil.class);

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

	/**
	 * yyyy-MM-dd
	 */
	public static final String DATE = "yyyy-MM-dd";

	/**
	 * HH:mm:ss
	 */
	public static final String TIME = "HH:mm:ss";

	public static final String DATENOXIAN = "yyyyMMddHHmmss";

	/**
	 * 按照yyyy-MM-dd HH:mm:ss创建的format
	 */
	public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME);

	public static final SimpleDateFormat DATENOXIAN_FORMAT = new SimpleDateFormat(DATENOXIAN);

	/**
	 * 按照yyyy-MM-dd创建的format
	 */
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE);

	/**
	 * 按照HH:mm:ss创建的format
	 */
	public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(TIME);

	/**
	 * 获取当前的详细时间，格式为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDetailedTime() {
		return DATE_TIME_FORMAT.format(new Date());
	}

	/**
	 * 格式化当前时间
	 * @param pattern
	 * 指定的格式字符串，如yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDetailedTime(String pattern) {
		if(pattern == null) {
			pattern = DATE_TIME;
		}

		return new SimpleDateFormat(pattern).format(new Date());
	}

	/**
	 * 获取入参date的详细时间，格式为yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String getDetailedTime(Date date) {
		if(date == null) {
			return "";
		}

		return DATE_TIME_FORMAT.format(date);
	}

	/**
	 * 格式化入参date的详细时间
	 * @param date
	 * @param pattern
	 * 指定的格式字符串，如yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDetailedTime(Date date, String pattern) {
		if(date == null) {
			return "";
		}

		if(pattern == null) {
			pattern = DATE_TIME;
		}

		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 将入参dateStr转换成date对象
	 * @param dateStr
	 * 日期字符串，格式要求为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parseStringToDate(String dateStr) {
		try {
			return DATE_TIME_FORMAT.parse(dateStr);
		}
		catch(Exception ex) {
			LOGGER.error("调用DateUtil的parseStringToDate失败，dateStr=" + dateStr, ex);
			return null;
		}
	}

	public static Date parseStringToDateXian(String dateStr) {
		try {
			return DATE_TIME_FORMAT.parse(dateStr);
		}
		catch(Exception ex) {
			LOGGER.error("调用DateUtil的parseStringToDate失败，dateStr=" + dateStr, ex);
			return null;
		}
	}

	/**
	 * 将入参dateStr按照指定格式转换成date对象
	 * @param dateStr
	 * 日期字符串
	 * @param pattern
	 * 与dateStr匹配的格式字符串
	 * @return
	 */
	public static Date parseStringToDate(String dateStr, String pattern) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			return format.parse(dateStr);
		}
		catch(Exception ex) {
			LOGGER.error("调用DateUtil的parseStringToDate失败，dateStr=" + dateStr + ", pattern=" + pattern, ex);
			return null;
		}
	}

	/**
	 * @Title: nowDateSub
	 * @Description: 两个日期相减得到秒数
	 * @param dateStr
	 * @return
	 * @return: long
	 */
	public static long nowDateSub(String dateStr){
		Date a = DateUtil.parseStringToDateXian(dateStr);
		Date b = new Date();
		long interval = (a.getTime() - b.getTime())/1000;
		return interval;
	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -2);
		Date date = cal.getTime();

		System.out.println(getDetailedTime(date));
		System.out.println(getDetailedTime());
	}
}
