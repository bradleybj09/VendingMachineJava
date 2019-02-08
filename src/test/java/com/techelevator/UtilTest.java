package com.techelevator;

import org.junit.Test;

import org.junit.Assert;

public class UtilTest {

	@Test
	public void string_convert_to_int_equals_correct() {
		String string = "42.15";
		int cents = Util.convertStringToCents(string);
		Assert.assertEquals(4215, cents);
	}
	
	@Test
	public void string_convert_to_int_equals_correct_round() {
		String string = "42.00";
		int cents = Util.convertStringToCents(string);
		Assert.assertEquals(4200, cents);
	}
	
	@Test
	public void int_convert_to_string_equals_correct() {
		int cents = 4215;
		String string = Util.convertCentsToString(cents);
		Assert.assertEquals("$42.15", string);
	}
	
	@Test
	public void int_convert_to_string_equals_correct_00() {
		int cents = 4200;
		String string = Util.convertCentsToString(cents);
		Assert.assertEquals("$42.00", string);
	}
	
	@Test
	public void int_convert_to_string_equals_correct_01() {
		int cents = 4201;
		String string = Util.convertCentsToString(cents);
		Assert.assertEquals("$42.01", string);
	}
	

}
