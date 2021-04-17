/**
 * 
 */
package com.idbi.pmo.service.dto;

import java.util.Set;

import lombok.Data;

/**
 * @author avinash
 *
 */
@Data
public class ProductDto {
	private Long id;
	private String name;
	private Boolean isActive;
	private String createdDate;
	private String modifiedDate;
	private Long createdBy;
	private Long modifiedBy;
	private Set<ClientDto> client;
	private Long productManager;
	private Long implManager;
	private Long relManager;
}
