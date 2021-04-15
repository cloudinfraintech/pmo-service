/**
 * 
 */
package com.idbi.pmo.service.service;

import java.util.List;

import com.idbi.pmo.service.dto.RoleDto;

/**
 * @author avinash
 *
 */
public interface RoleService {
	void create(RoleDto dto) throws Exception;

	List<RoleDto> getAllRole();

}
