package com.password.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PasswordValidationApplication implements CommandLineRunner {

	@Autowired
	PasswordValidationService passwordValidationService;

	public static void main(String[] args) {

		SpringApplication passwordValidationApp = new SpringApplication(
				PasswordValidationApplication.class);

		passwordValidationApp.run(args);
	}

	@Override
	public void run(String[] args) throws Exception {

		if (args.length == 0) {
			System.err.println("Please provide a password for validation.");
			return;
		}

		String password = args[0].toString();
		int numberOfPasswordErrors = 0;

		if (!passwordValidationService.checkAllNumbersPassword(password)) {
			numberOfPasswordErrors++;
		}

		if (!passwordValidationService.checkAllLettersPassword(password)) {
			numberOfPasswordErrors++;
		}

		if (!passwordValidationService.checkValidPasswordContent(password)) {
			numberOfPasswordErrors++;
		}

		if (!passwordValidationService.validateSequence(password)) {
			numberOfPasswordErrors++;
		}

		if (!passwordValidationService.validatePasswordLength(password)) {
			numberOfPasswordErrors++;
		}

		if (numberOfPasswordErrors == 0) {
			System.out.println("Entered password is valid");
		}
	}

}
