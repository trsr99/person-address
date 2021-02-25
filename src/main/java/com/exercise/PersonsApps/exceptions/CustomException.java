package com.exercise.PersonsApps.exceptions;

public class CustomException extends RuntimeException {
	String code;

	public CustomException(String code, String message) {
		super(message);
		this.code = code;
	}
}
