/**
 * 
 */
package com.idbi.pmo.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author avinash
 *
 */
public class DateUtil {

	public static Date ddMMMyyyy(String str) throws ParseException {
		SimpleDateFormat ddMMMyyyy = new SimpleDateFormat("dd-MMM-yyyy");
		return ddMMMyyyy.parse(str);
	}

	public static String ddMMMyyyyStr(Date date) {
		return new SimpleDateFormat("dd-MMM-yyyy").format(date);
	}

	public static Date todayDate() throws ParseException {
		String pattern = "dd-MMM-yyyy";
		return ddMMMyyyy(new SimpleDateFormat(pattern).format(new Date()));
	}

	public static void main(String[] args) {
		try {
			DateUtil.todayDate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
