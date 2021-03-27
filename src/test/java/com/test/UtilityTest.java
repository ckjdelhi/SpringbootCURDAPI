package com.test;

import org.junit.*;

public class UtilityTest {

	private static Utility util=null;
	@BeforeClass
	public static void setUP() {
		util = new Utility();
	}
	
	/*@AfterClass
	public static void cleanUp() {
		System.out.println("After class");
	}*/
	
	/*@Before
	public void beforeTest() {
		System.out.println("Before each test");
	}*/
	
	@Test
	public void canTestValidEmail() {
		boolean isValid = util.validEmail("chandan.krk@gmail.com");
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void canTestEmailIdWhenAtTheRateIsMissing() {
		boolean isValid = util.validEmail("chandan.krkgmail.com");
		Assert.assertEquals(false, isValid);
	}
	
	@Test
	public void canTestEmailIdWhenDotIsMissing() {
		boolean isValid = util.validEmail("chandan.krk@gmailcom");
		Assert.assertEquals(false, isValid);
	}
	
	@Test
	public void canTestEmailIdWhenDotIsAdedTwoTimeAfterAtTheRate() {
		boolean isValid = util.validEmail("chandan.krk@gma.Cil.co.cmm");
		System.out.println(isValid);
		Assert.assertFalse(isValid);
	}
}
