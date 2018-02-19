package com.jgy.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Parsers {
	
	//private static final String FORMAT = "dd-mm-yyyy";
	//private static final String FORMATDB = "yyyy-mm-dd";
	
	public static LocalDate parserStringtoLocalDate(String date) {	
		LocalDate date1 = null;
		try {
			date1 = LocalDate.parse(date);		
		} catch (DateTimeParseException e) {
			// TODO Manejar excepciones relacionadas con las fechas mal introducidas
			e.printStackTrace();
			date1 = null;
		}		
		return date1;
	}
	
	public static LocalDate parserDatetoLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	//public static String parserLocalDatetoString(LocalDate date) {
		//return parserDate(date,FORMAT);
	//}
	
	//public static String parserLocalDatetoDBField(LocalDate date) {
		//return parserDate(date,FORMATDB);
	//}	
	
//	private static String parserDate(LocalDate date, String format) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
//		// TODO Manejar posibles errores
//		try {
//			return date.format(formatter);
//		}
//		catch(DateTimeException e) {
//			e.printStackTrace();			
//		}
//		return null;
//	}	
}