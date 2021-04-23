/**
 * 
 */
package com.idbi.pmo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author avinash
 *
 */
@Data
@AllArgsConstructor
public class ErrorDto {

	private String message;
	private Object data;

}
