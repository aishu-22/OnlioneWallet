package com.capgemini.onlineWallet.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/************************************************************************************************************************************************
* author:       Aishwarya Srivastava                                                                                                            *
* Description:  It is a controller class for handling the exceptions which will give appropriate                                                *
*               messages when any error occurs.                                                                                                 *
************************************************************************************************************************************************/
@RestControllerAdvice
public class Exceptioncontroller {

	@ExceptionHandler(value =  InvalidAmountException.class )
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleException(InvalidAmountException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value =UnauthorizedUserException.class )
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleException1(UnauthorizedUserException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}