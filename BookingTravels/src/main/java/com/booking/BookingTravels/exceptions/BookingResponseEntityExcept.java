package com.booking.BookingTravels.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookingResponseEntityExcept {

//	/**
//	 * handleConflict
//	 * 
//	 * @param ex      exception parameter
//	 * @param request The request
//	 * @return ResponseEntity<ErrorResource>
//	 */
//	@ExceptionHandler(value = { DefaultBookingException.class })
//	protected ResponseEntity<ErrorResource> handleConflict(DefaultBookingException ex, WebRequest request) {
//		return new ResponseEntity<>(ex.getErrorResource(), ex.getErrorResource().getStatus());
//	}

	/**
	 * processValidationError
	 * 
	 * @param ex exception parameter
	 * @return ErrorResource
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResource processValidationError(RuntimeException ex) {
		return new ErrorResource("uncatched exception", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
