/**
 * 
 */
package com.idbi.pmo.service.dto;

import java.io.Serializable;

/**
 * @author avinash
 *
 */
public class JwtResponse implements Serializable {
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}

}
