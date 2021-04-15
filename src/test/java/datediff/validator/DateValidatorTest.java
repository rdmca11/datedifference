package datediff.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateValidatorTest {

	@Test
	public void testValidDatePattern() {
		assertTrue(DateValidator.isValidDatePairPattern("20 20 2000, 19 20 2000"));
	}

	@Test
	public void testInvalidDatePattern() {
		assertFalse(DateValidator.isValidDatePairPattern("20 20 20001"));
	}

}
