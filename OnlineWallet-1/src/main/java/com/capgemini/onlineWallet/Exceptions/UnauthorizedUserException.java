package com.capgemini.onlineWallet.Exceptions;
/* ***********************************************************************************
 *          @author         Aishwarya Srivastava
 *          Description      It is a exception class for user
 *          Version          1.0
 *          Created Date     24-APR-2020
 ************************************************************************************/

public class UnauthorizedUserException extends RuntimeException {

	public UnauthorizedUserException() {
		// TODO Auto-generated constructor stub
	}

	public UnauthorizedUserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}