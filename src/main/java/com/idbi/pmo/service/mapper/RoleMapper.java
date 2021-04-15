/**
 * 
 */
package com.idbi.pmo.service.mapper;

import com.idbi.pmo.service.dto.RoleDto;
import com.idbi.pmo.service.model.Role;
import com.idbi.pmo.service.util.DateUtil;

/**
 * @author avinash
 *
 */
public class RoleMapper {
	public static Role toRole(RoleDto dto) throws Exception {
		Role role = new Role();
		role.setIsActive(null != dto.getIsActive() ? dto.getIsActive() : null);
		role.setCreatedBy(null != dto.getCreatedBy() ? dto.getCreatedBy() : null);
		role.setCreatedDate(null != dto.getCreatedDate() ? DateUtil.ddMMMyyyy(dto.getCreatedDate()) : null);
		role.setId(null != dto.getId() ? dto.getId() : null);
		role.setModifiedBy(null != dto.getModifiedBy() ? dto.getModifiedBy() : null);
		role.setModifiedDate(null != dto.getModifiedDate() ? DateUtil.ddMMMyyyy(dto.getModifiedDate()) : null);
		role.setName(null != dto.getName() ? dto.getName() : null);
		return role;
	}

	public static RoleDto toDto(Role role) {
		RoleDto dto = new RoleDto();
		dto.setCreatedBy(null != role.getCreatedBy() ? role.getCreatedBy() : null);
		dto.setCreatedDate(null != role.getCreatedDate() ? DateUtil.ddMMMyyyyStr(role.getCreatedDate()) : null);
		dto.setId(null != role.getId() ? role.getId() : null);
		dto.setIsActive(null != role.getIsActive() ? role.getIsActive() : null);
		dto.setModifiedBy(null != role.getModifiedBy() ? role.getModifiedBy() : null);
		dto.setModifiedDate(null != role.getModifiedDate() ? DateUtil.ddMMMyyyyStr(role.getModifiedDate()) : null);
		dto.setName(null != role.getName() ? role.getName() : null);
		return dto;
	}
}
