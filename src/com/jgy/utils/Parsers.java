package com.jgy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parsers {
	
	private static final String FORMAT = "dd/mm/yyyy";
	private static final String FORMATDB = "yyyy-mm-dd";
	
	public static Date parserStringtoDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
		Date date1;
		try {
			date1 = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Manejar excepciones relacionadas con las fechas mal introducidas
			e.printStackTrace();
			date1 = null;
		}		
		return date1;
	}
	
	public static String parserDatetoString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
		// TODO Manejar posibles errores
		return formatter.format(date);		
	}
	
	public static String parserDatetoDBField(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(FORMATDB);
		// TODO Manejar posibles errores
		return formatter.format(date);		
	}
	
}
