package com.revature.orderys.exceptions;

/**
 * This class defines an exceptional condition where a user attempts
 * to create an account with an email that already exists in the database.
 * 
 * @author Null Terminators
 */
public class EmailNotUniqueException extends Exception {

	private static final long serialVersionUID = -1175387710233961875L;

	public EmailNotUniqueException(String message) {
		super(message);
	}
}
