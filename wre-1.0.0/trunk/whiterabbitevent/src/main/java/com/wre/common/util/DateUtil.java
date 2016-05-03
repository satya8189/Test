package com.wre.common.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Gopi
 * @since 22-05-2015
 * @version 1.0 This class having application related Utility(Date formats and
 *          conversion) methods
 */
public class DateUtil {

	public static String format(String time) throws ParseException {
		String reformattedStr = "";
		if (time != null) {
			SimpleDateFormat fromUser = new SimpleDateFormat(
					"dd-MM-yyyy HH:mm:ss");
			SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			reformattedStr = fromUser.format(myFormat.parse(time));

		}
		return reformattedStr;
	}

	/**
	 * Converts string date to sql date
	 * 
	 * @param String
	 * @version 1.0
	 */

	public static java.sql.Date stringDateToSqlDate(String strDate) {
		java.sql.Date sqlDate = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date;
		try {
			date = sdf1.parse(strDate);
			sqlDate = new Date(date.getTime());
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return sqlDate;
	}

	/**
	 * Converts string date to sql date
	 * 
	 * @param String
	 * @version 1.0
	 */

	public static java.sql.Date stringDateToDate(String strDate) {
		java.sql.Date sqlDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat(
				"EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		String convetStringdate;
		java.util.Date date;
		try {
			java.util.Date parsedDate = sdf.parse(strDate);
			convetStringdate = sdf1.format(parsedDate);
			date = sdf1.parse(convetStringdate);
			sqlDate = new Date(date.getTime());
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return sqlDate;
	}

	/**
	 * Converts string dd-MMM-yyyy HH:MM:SS to yyyy-MM-dd HH:MM:SS
	 * 
	 * @param String
	 * @version 1.0
	 */
	public static Timestamp formatDate(String dateWithTime)
			throws ParseException {
		Timestamp formatedDate = null;
		String time;
		String date;
		if (dateWithTime != null) {
			if (dateWithTime.split("-")[0].length() == 1) {
				time = dateWithTime.substring(11, dateWithTime.length());
				date = dateWithTime.substring(0, 10);
			} else {
				time = dateWithTime.substring(12, dateWithTime.length());
				date = dateWithTime.substring(0, 11);
			}

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			java.util.Date varDate = dateFormat.parse(date);
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String startDate = dateFormat.format(varDate) + " " + time;
			// Timestamp.valueOf(startDate);
			formatedDate = Timestamp.valueOf(startDate);
		}
		return formatedDate;
	}

	/**
	 * Converts string dd-MMM-yyyy HH:MM:SS to yyyy-MM-dd HH:MM:SS
	 * 
	 * @param String
	 * @version 1.0
	 */
	public static String CharcterDateFormat(String dateWithTime)
			throws ParseException {
		String formatedDate = null;

		if (dateWithTime != null) {
			String time = dateWithTime.substring(11, dateWithTime.length());
			String date = dateWithTime.substring(0, 10);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date varDate = dateFormat.parse(date);
			dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			formatedDate = dateFormat.format(varDate) + " " + time;

		}
		return formatedDate;
	}

	/**
	 * Converts string date(2013-12-18) to sql date(18/12/2013)
	 * 
	 * @param String
	 * @version 1.0
	 */

	public static String sqlDateToStringDate(String strDate) {
		String array[] = strDate.split("-");
		return array[1] + "/" + array[2] + "/" + array[0];
	}

	public static Timestamp getTimeInTimeStamp() {
		Timestamp timestamp = null;
		timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;

	}

	public static Date getCurrentDate() {
		java.util.Date utilDate = new java.util.Date();
		return new java.sql.Date(utilDate.getTime());
	}

	public static boolean compareDateWithToday(java.util.Date expiry_date,
			String timeZone) {

		Timestamp currentWorldTime = null;
		java.util.Date todayobject = new java.util.Date();
		// displaying this date on IST timezone
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:SS");
		// dispalying date on PST timezone
		df.setTimeZone(TimeZone.getTimeZone(timeZone));
		String dateAsString = df.format(todayobject);
		try {
			currentWorldTime = DateUtil.formatDate(dateAsString);
		} catch (ParseException PE) {

		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:SS");
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:SS");
		String today = dateFormat.format(currentWorldTime);
		String exp_date = dateFormat.format(expiry_date);

		try {
			if (sdf.parse(exp_date).compareTo(sdf.parse(today)) < 0)
				return true;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean palValidityCheck(java.util.Date expiry_date,
			String timeZone) {

		Timestamp currentWorldTime = null;
		java.util.Date todayobject = new java.util.Date();
		// displaying this date on IST timezone
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:SS");
		// dispalying date on PST timezone
		df.setTimeZone(TimeZone.getTimeZone(timeZone));
		String dateAsString = df.format(todayobject);
		try {
			currentWorldTime = DateUtil.formatDate(dateAsString);
		} catch (ParseException PE) {

		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:SS");
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:SS");
		String today = dateFormat.format(currentWorldTime);
		String exp_date = dateFormat.format(expiry_date);

		try {
			if (sdf.parse(today).compareTo(sdf.parse(exp_date)) < 0)
				return true;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean compareTwoDateWithToday(java.util.Date from_date,
			java.util.Date To_date, String timeZone) {

		Timestamp currentWorldTime = null;
		java.util.Date todayobject = new java.util.Date();
		// displaying this date on IST timezone
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:SS");
		// dispalying date on PST timezone
		df.setTimeZone(TimeZone.getTimeZone(timeZone));
		String dateAsString = df.format(todayobject);
		try {
			currentWorldTime = DateUtil.formatDate(dateAsString);
		} catch (ParseException PE) {
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:SS");
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:SS");
		String today = dateFormat.format(currentWorldTime);
		String form_date = dateFormat.format(from_date);
		String to_date = dateFormat.format(To_date);
		try {
			if (sdf.parse(today).after(sdf.parse(form_date))
					&& sdf.parse(today).before(sdf.parse(to_date))) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static java.sql.Date sqlDateToDate(java.util.Date date2) {
		java.sql.Date sqlDate = null;
		System.out.println("Date is :--" + date2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		String convetStringdate;
		java.util.Date date;
		try {
			String parsedDate = sdf.format(date2);
			convetStringdate = sdf1.format(parsedDate);
			date = sdf1.parse(convetStringdate);
			sqlDate = new Date(date.getTime());
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return sqlDate;
	}

}
