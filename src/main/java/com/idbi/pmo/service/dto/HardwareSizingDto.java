/**
 * 
 */
package com.idbi.pmo.service.dto;

import lombok.Data;

/**
 * @author avinash
 *
 */
@Data
public class HardwareSizingDto {
	private Long id;
	private String server;
	private String configuration;
	private Integer quantity;
}
