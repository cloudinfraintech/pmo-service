/**
 * 
 */
package com.idbi.pmo.service.util;

/**
 * @author avinash
 *
 */
public enum PMOEnum {
	OK("success"), FAILED("fail"), UniqueRole("Role already exist");

	private String message;

	private PMOEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
