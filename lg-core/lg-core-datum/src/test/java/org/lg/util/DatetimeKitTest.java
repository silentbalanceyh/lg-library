package org.lg.util;

import java.util.Date;

import org.junit.Test;

public class DatetimeKitTest {

	@Test
	public void testDate(){
		Date date = DatetimeKit.toDate("2017-02-03T20:58:00.000Z");
		System.out.println(date);
		date = DatetimeKit.toDate("2017-04-05");
		System.out.println(date);
	}
}
