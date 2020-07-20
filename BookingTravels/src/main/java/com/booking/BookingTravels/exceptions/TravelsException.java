package com.booking.BookingTravels.exceptions;

public class TravelsException extends Exception {

	private static final long serialVersionUID = 1L;

	public TravelsException() {
		super();
	}

	public TravelsException(String message) {
		super(message);
	}

	public TravelsException(String message, Throwable cause) {
		super(message, cause);
	}
}
