package com.booking.BookingTravels.exceptions;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorResource {

	private String label;
	private String detailMessage;
	private HttpStatus status;

	/**
	 * ErrorResource
	 * 
	 * @param label         The label of error
	 * @param detailMessage The detailMessage of error
	 * @param status        status parameter
	 */
	public ErrorResource(String label, String detailMessage, HttpStatus status) {
		super();
		this.label = label;
		this.detailMessage = detailMessage;
		this.status = status;
	}

	/**
	 * @return label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label The label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return detailMessage
	 */
	public String getDetailMessage() {
		return detailMessage;
	}

	/**
	 * @param detailMessage Detail message parameter
	 */
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	/**
	 * @return status
	 */
	@JsonIgnore
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status The status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return int
	 */
	// Getter supplémentaire + JsonIgnore sur le champ original pour récupérer le
	// code en int et pas son alias en String
	public int getStatusCode() {
		return status.value();
	}

}
