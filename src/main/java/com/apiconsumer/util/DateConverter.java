package com.apiconsumer.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {
public static String convertDate(String dateStr) throws ParseException {
	DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
	Date date = (Date)formatter.parse(dateStr);     
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	return cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DATE);
}
}
