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
public class UserDto {
	private Long id;
	private String username;
	private String password;
	private String mobile;
	private String imei;
	private String appVersion;
	private Integer os;
	private Boolean isActive;
	private String createdDate;
	private String modifiedDate;
	private Long createdBy;
	private Long modifiedBy;
	private Set<RoleDto> role;
	//private Set<ProductDto> product;
	private Long productManager;
	private Long implManager;

}
