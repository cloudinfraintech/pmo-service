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
public class RoleDto {
	private Long id;
	private String name;
	private Boolean isActive;
	private String createdDate;
	private String modifiedDate;
	private Long createdBy;
	private Long modifiedBy;
}
