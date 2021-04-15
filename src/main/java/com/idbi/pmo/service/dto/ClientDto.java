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
public class ClientDto {
	private Long id;
	private String clientName;
	private Boolean isActive;
	private String createdDate;
	private String modifiedDate;
	private Long createdBy;
	private Long modifiedBy;
}
