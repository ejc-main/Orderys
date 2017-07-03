package com.revature.orderys.exceptions;

/**
 * This class defines an exceptional condition where a business is
 * registered with incomplete fields.
 * 
 * @author Null Terminators
 */
public class InvalidBusinessException extends Exception
{
	private static final long serialVersionUID = -433997131603984046L;

	public InvalidBusinessException(String message) {
		super(message);
	}
}
