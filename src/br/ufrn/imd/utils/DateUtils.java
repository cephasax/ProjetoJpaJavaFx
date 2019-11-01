package br.ufrn.imd.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

	public static String fromLongToDateAsString(long timeAsLong) {
		Date dt = new Date(timeAsLong);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
		df.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		return df.format(dt).toString();
	}

	public static Date fromLongToDate(long timeAsLong) {
		Date dt = new Date(timeAsLong);
		return dt;
	}
}
