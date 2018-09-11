package com.password.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class PasswordValidationService {

	private static final String alphaNumericRegex = "^[a-z0-9]*";
	private static final String allNumbersRegex = "\\d+";
	private static final String allLettersRegex = "[a-zA-Z]+";
	private static final Pattern repeatingValuesPattern = Pattern.compile("(\\w\\w)\\1");

	public boolean checkAllNumbersPassword(String password) {

		boolean validPasswordContent = true;

		if (passwordExists(password)) {
			// // all numbers not allowed
			if (password.matches(allNumbersRegex)) {
				validPasswordContent = false;
				System.err.println("all numbers not allowed.");
			}
		}

		return validPasswordContent;
	}

	public boolean checkAllLettersPassword(String password) {

		boolean validPasswordContent = true;

		if (passwordExists(password)) {
			// all letters not allowed
			if (password.matches(allLettersRegex)) {
				validPasswordContent = false;
				System.err.println("all letters not allowed.");
			}
		}

		return validPasswordContent;
	}

	public boolean checkValidPasswordContent(String password) {

		boolean validPasswordContent = true;

		if (passwordExists(password)) {
			// verify that the password is comprised of only lowercase letters
			// and numbers.
			if (!password.matches(alphaNumericRegex)) {
				validPasswordContent = false;
				System.err.println("The entered password contains invalid values.");
			}
		}

		return validPasswordContent;
	}

	public boolean validatePasswordLength(String password) {

		boolean validPasswordLength = true;

		if (passwordExists(password)) {
			if (password.length() < 5 || password.length() > 12) {
				validPasswordLength = false;
				System.out.println(
						"The password length is invalid as it needs to be between 5 characters and 12 characters in length.");
			}
		}

		return validPasswordLength;
	}

	public boolean validateSequence(String password) {

		boolean validPasswordSequence = true;

		if (passwordExists(password)) {
			Matcher repeatingValuesMatcher = repeatingValuesPattern.matcher(password);
			if (repeatingValuesMatcher.find()) {
				System.err.println("repeating values not allowed.");
				validPasswordSequence = false;
			}
		}

		return validPasswordSequence;
	}

	public boolean passwordExists(String password) {

		boolean passwordValueExists = true;

		if (password == null || password.isEmpty()) {
			System.out.println("Please provide a password value.");
			passwordValueExists = false;
		}

		return passwordValueExists;
	}

}
