package com.booking.BookingTravels.exceptions;

public class DefaultBookingException extends RuntimeException {

	private final transient EntiyResponseData entiyResponseData;

	public DefaultBookingException(EntiyResponseData entiyresponseData) {
		super();
		this.entiyResponseData = entiyresponseData;
	}

	/**
	 * ErrorResource
	 * 
	 * @return errorResource
	 */
	public EntiyResponseData getErrorResource() {
		return entiyResponseData;
	}
}
