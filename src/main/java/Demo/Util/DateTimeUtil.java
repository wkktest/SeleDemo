package Demo.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateTimeUtil {
	private static Logger logger = Logger.getLogger(DateTimeUtil.class);

	/**
	 * 年月日時分秒
	 * 获取系统当前日期和时间并格式化为yyyyMMddHHmmssSSS即类似20130526002728796格式
	 * 
	 * @param 无
	 * @return 系统当前日期和时间并格式化为yyyyMMddHHmmssSSS即类似20130526002728796格式
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}

	/**
	 * 年月日
	 * 获取系统当前日期并格式化为yyyyMMdd即类似20110810格式
	 * 
	 * @param 无
	 * @return 系统当前日期并格式化为yyyyMMdd即类似20110810格式
	 */
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}

	/**
	 * 時分秒
	 * 获取系统当前时间并格式化为HHmmss即类似155638格式
	 * 
	 * @param 无
	 * @return 系统当前时间并格式化为HHmmss即类似155638格式
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");
		return sdf.format(new Date());
	}

	/**
	 * 从1970年1月1日 00：00：00起，返回毫秒数
	 * 由这个日期对象表示
	 * 
	 * @param 无
	 * @return 从1970年1月1日 00：00：00起，返回毫秒数
	 *         由这个日期对象表示.
	 */
	public static long getLongTime() {
		return new Date().getTime();
	}

	/**
	 * 从1970年1月1日起，返回毫秒数
     *由这个日期对象表示。
	 * 
	 * @param format
	 *            时间格式 eg: yyyy-MM-dd HH:mm:ss
	 * @param datetime
	 *            eg: 2015-01-19 10:35:35
	 * @return 从1970年1月1日起，返回毫秒数
     *由这个日期对象表示。
	 */
	public static long getLongTime(String format, String datetime) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(datetime).getTime();
		} catch (ParseException e) {
			logger.error("DateTimeUtil.getLongTime() error!", e);
		}
		return 0;
	}

	/**
	 * 根据自定义格式获取系统当前时间
	 * 
	 * @param format
	 *            时间格式 eg: yyyy-MM-dd HH:mm:ss:SSS
	 * @return 根据自定义格式返回系统当前时间
	 */
	public static String formatedTime(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	/**
	 * 根据自定义格式指定时间
	 * 
	 * @param format
	 *            时间格式 eg: yyyy-MM-dd HH:mm:ss:SSS
	 * @param datetime
	 *            eg: 2015-02-12 14:00:00
	 * @return
	 */
	public static String formatedTime(String format, String datetime) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(sdf.parse(datetime));
		} catch (ParseException e) {
			logger.error("DateTimeUtil.formatedTime() error!", e);
		}
		return null;
	}

	/**
	 * 按指定日期格式指定时间字符串.
	 * 
	 * @param Minutes
	 *           在当前分钟或之前的几分钟，使用+和- to add，如:+ 5或5。
	 * @param dateFormat
	 *            日期的形式，诸如此类 as:yyyy-MM-dd HH:mm:ss:SSS.
	 */
	public static String addMinutesByFormatter(int Minutes, String dateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, Minutes);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}

	/**
	 * 按指定日期格式指定时间字符串
	 * 
	 * @param hours
	 *            hours after or before current hour, use + and - to add,eg: +5
	 *            or -5.
	 * @param dateFormat
	 *            the formatter of date, such as:yyyy-MM-dd HH:mm:ss:SSS.
	 */
	public static String addHoursByFormatter(int hours, String dateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR, hours);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}

	/**
	 * get specified time string in specified date format.
	 * 
	 * @param days
	 *            days after or before current date, use + and - to add,eg: +5
	 *            or -5.
	 * @param dateFormat
	 *            the formatter of date, such as:yyyy-MM-dd HH:mm:ss:SSS.
	 */
	public static String addDaysByFormatter(int days, String dateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, days);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}

	/**
	 * get specified time string in specified date format.
	 * 
	 * @param months
	 *            months after or before current date, use + and - to add,eg: +5
	 *            or -5.
	 * @param dateFormat
	 *            the formatter of date, such as:yyyy-MM-dd HH:mm:ss:SSS.
	 */
	public static String addMonthsByFormatter(int months, String dateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, months);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}

	/**
	 * get specified time string in specified date format.
	 * 
	 * @param years
	 *            years after or before current date, use + and - to add,eg: +5
	 *            or -5.
	 * @param dateFormat
	 *            the formatter of date, such as:yyyy-MM-dd HH:mm:ss:SSS.
	 */
	public static String addYearsByFormatter(int years, String dateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, years);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}

	/**
	 * 以指定的日期格式进入下个月的第一天.
	 * 
	 * @param dateFormat
	 *            the formatter of date, such as:yyyy-MM-dd HH:mm:ss:SSS.
	 */
	public static String firstDayOfNextMonth(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}

	/**
	 * 指定日期的第一天和指定的年份格式。
	 * 
	 * @param year
	 *            the year of the date.
	 * @param month
	 *            the month of the date.
	 * @param dateFormat
	 *            the formatter of date, such as:yyyy-MM-dd HH:mm:ss:SSS.
	 */
	public static String firstDayOfMonth(int year, int month, String dateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}

	/**
	 * 按指定日期格式，按本年度第一天的规定。
	 * 
	 * @param month
	 *            the month of the date.
	 * @param dateFormat
	 *            the formatter of date, such as:yyyy-MM-dd HH:mm:ss:SSS.
	 */
	public static String firstDayOfMonth(int month, String dateFormat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}

	/**
	 * 获取系统当前毫秒.
	 */
	public static String getMilSecNow() {
		return String.valueOf(System.currentTimeMillis());
	}

	
	
	
	
	
	
//	public static void main(String[] args) {
//		System.out.println(DateTimeUtil.getCurrentDateTime());
//		System.out.println(DateTimeUtil.getCurrentDate());
//		System.out.println(DateTimeUtil.getCurrentTime());
//
//		System.out.println(DateTimeUtil.addDaysByFormatter(+5, "yyyy-MM-dd"));
//		System.out.println(DateTimeUtil.addDaysByFormatter(-5, "yyyy-MM-dd"));
//		System.out.println(DateTimeUtil.addMonthsByFormatter(+4, "yyyy-MM-dd"));
//		System.out.println(DateTimeUtil.addMonthsByFormatter(-4, "yyyy-MM-dd"));
//		System.out.println(DateTimeUtil.addYearsByFormatter(+3, "yyyy-MM-dd"));
//		System.out.println(DateTimeUtil.addYearsByFormatter(-3, "yyyy-MM-dd"));
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println("###" + DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS"));
//		System.out.println("###" + DateTimeUtil.getLongTime());
//		System.out.println("###" + DateTimeUtil.getLongTime("yyyy-MM-dd HH:mm:ss", "2015-01-19 10:35:35"));
//	}
}
