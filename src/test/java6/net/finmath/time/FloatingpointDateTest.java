/*
 * (c) Copyright Christian P. Fries, Germany. All rights reserved. Contact: email@christianfries.com.
 *
 * Created on 17.05.2017
 */
package net.finmath.time;



import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class FloatingpointDateTest {

	/**
	 * Unit test for a roundtrip that the double representation is 1:1 to a LocalDate representation (up to days).
	 */
	@Test
	public void test() {
		LocalDate referenceDate = new LocalDate(2016, 01, 01);
		for(int i=0; i<1000; i++) {
			LocalDate date = referenceDate.plusDays(i);
			
			double floatingPointDate = FloatingpointDate.getFloatingPointDateFromDate(referenceDate, date);
			LocalDate dateFromFloat	= FloatingpointDate.getDateFromFloatingPointDate(referenceDate, floatingPointDate);
			
			Assert.assertTrue("Roundtrip with date offset of " + i + " days.", dateFromFloat.isEqual(date));
		}
	}

}
