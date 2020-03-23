package com.apiconsumer.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {
	private DateConverter() {
		throw new IllegalStateException("Can Not Create Object Of Utility Class");
	}

	public static String convertDate(String dateStr) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date date = (Date) formatter.parse(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		String monthInString = String.valueOf(month);
		if (monthInString.length() == 1) {
			monthInString = 0 + monthInString;
		}
		String dateInString = String.valueOf(cal.get(Calendar.DATE));
		if (dateInString.length() == 1) {
			dateInString = 0 + dateInString;
		}
		return cal.get(Calendar.YEAR) + "-" + monthInString + "-" + dateInString;
	}
}
