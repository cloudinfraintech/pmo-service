/**
 * 
 */
package com.idbi.pmo.service.service;

import java.text.ParseException;
import java.util.List;

import com.idbi.pmo.service.dto.RequestDto;
import com.idbi.pmo.service.dto.RoleDto;

/**
 * @author avinash
 *
 */
public interface RoleService {
	void create(RoleDto dto) throws Exception;

	List<RoleDto> getAllRole();

	RoleDto delete(RequestDto dto) throws ParseException;

}
