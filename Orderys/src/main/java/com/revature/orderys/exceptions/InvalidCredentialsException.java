package com.revature.orderys.exceptions;

/**
 * This class defines an exceptional condition where a user has tried
 * to log in with an anvalid email or an incorrect password.
 * 
 * @author Null Terminators
 */
public class InvalidCredentialsException extends Exception {
	private static final long serialVersionUID = -6235581037780868030L;

	public InvalidCredentialsException(String message) {
		super(message);
	}
}
