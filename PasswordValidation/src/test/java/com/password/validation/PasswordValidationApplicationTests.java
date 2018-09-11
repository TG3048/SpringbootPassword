package com.password.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordValidationApplicationTests {

	@Autowired
	PasswordValidationService passwordValidationService;

	@Test
	public void passAllNumbersPasswordTest() {

		assertTrue("Allowable values failed for the all numeric password not allowed test.",
				passwordValidationService.checkAllNumbersPassword("123abc456"));
	}

	@Test
	public void checkAllNumbersPasswordTest() {

		assertFalse("Test failed for the all numeric password not allowed test.",
				passwordValidationService.checkAllNumbersPassword("123456"));
	}

	@Test
	public void passAllLettersPasswordTest() {

		assertTrue("Aloowable values failed for the all letters password not allowed test.",
				passwordValidationService.checkAllLettersPassword("123abc456"));
	}

	@Test
	public void checkAllLettersPasswordTest() {

		assertFalse("Test failed for the all letters password not allowed test.",
				passwordValidationService.checkAllLettersPassword("abcdefg"));
	}

	@Test
	public void passValidPasswordContentTest() {

		assertTrue("Allowable values failed for the uppercase letters not allowed test.",
				passwordValidationService.checkValidPasswordContent("123abc456"));
	}

	@Test
	public void checkValidPasswordContentTest() {

		assertFalse("Test failed for the uppercase letters not allowed test.",
				passwordValidationService.checkValidPasswordContent("abcAY45defg"));
	}

	@Test
	public void passPasswordLengthTest() {

		assertTrue("Allowable values failed for the password length test.",
				passwordValidationService.validatePasswordLength("123abc456"));
	}

	@Test
	public void validatePasswordLengthTest() {

		assertFalse("Test failed for the password length test.",
				passwordValidationService.validatePasswordLength("abc456def789qrstuv"));
	}

	@Test
	public void passValidateSequenceTest() {

		assertTrue("Allowable values failed for the password character sequencing test.",
				passwordValidationService.validateSequence("adeade456xyz"));
	}

	@Test
	public void validateSequenceTest() {

		assertFalse("Test failed for the password character sequencing test.",
				passwordValidationService.validateSequence("abab456def"));
	}

	@Test
	public void anotherValidateSequenceTest() {

		assertFalse("Test failed for another password character sequencing test.",
				passwordValidationService.validateSequence("ab4ab44efef"));
	}

	@Test
	public void passPasswordMissingTest() {

		assertTrue("Test failed for the missing password test.",
				passwordValidationService.passwordExists("123abc456"));
	}

	@Test
	public void passwordMissingTest() {

		assertFalse("Test failed for the missing password test.",
				passwordValidationService.passwordExists(""));
	}

	@Test
	public void passwordExistsTest() {

		assertTrue("Test failed for the password exists test.",
				passwordValidationService.passwordExists("abc456def"));
	}
}
