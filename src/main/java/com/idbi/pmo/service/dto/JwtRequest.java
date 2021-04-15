/**
 * 
 */
package com.idbi.pmo.service.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author avinash
 *
 */
@Data
public class JwtRequest implements Serializable {
	private String username;
	private String password;
	private String mobile;
	private String imei;
}