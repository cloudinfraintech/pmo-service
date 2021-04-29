/**
 * 
 */
package com.idbi.pmo.service.mapper;

import java.util.stream.Collectors;

import com.idbi.pmo.service.dto.UserDto;
import com.idbi.pmo.service.model.User;
import com.idbi.pmo.service.util.DateUtil;

/**
 * @author avinash
 *
 */
public class UserMapper {
	public static User toUser(UserDto dto) throws Exception {
		User user = new User();
		user.setIsActive(null != dto.getIsActive() ? dto.getIsActive() : null);
		user.setCreatedBy(null != dto.getCreatedBy() ? dto.getCreatedBy() : null);
		user.setCreatedDate(null != dto.getCreatedDate() ? DateUtil.ddMMMyyyy(dto.getCreatedDate()) : null);
		user.setId(null != dto.getId() ? dto.getId() : null);
		user.setImei(null != dto.getImei() ? dto.getImei() : null);
		user.setAppVersion(null != dto.getAppVersion() ? dto.getAppVersion() : null);
		user.setOs(null != dto.getOs() ? dto.getOs() : null);
		user.setMobile(null != dto.getMobile() ? dto.getMobile() : null);
		user.setModifiedBy(null != dto.getModifiedBy() ? dto.getModifiedBy() : null);
		user.setModifiedDate(null != dto.getModifiedDate() ? DateUtil.ddMMMyyyy(dto.getCreatedDate()) : null);
		user.setPassword(null != dto.getPassword() ? dto.getPassword() : null);
		user.setUsername(null != dto.getUsername() ? dto.getUsername() : null);
		/*if (null != dto.getRole()) {
			user.setRole(dto.getRole().stream().map(roleDto -> {
				try {
					return RoleMapper.toRole(roleDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toSet()));
		}*/
		user.setProductManager(null != dto.getProductManager() ? dto.getProductManager() : null);
		user.setImplManager(null != dto.getImplManager() ? dto.getImplManager() : null);
		return user;
	}

	public static UserDto toDto(User user) {
		UserDto dto = new UserDto();
		dto.setCreatedBy(null != user.getCreatedBy() ? user.getCreatedBy() : null);
		dto.setCreatedDate(null != user.getCreatedDate() ? DateUtil.ddMMMyyyyStr(user.getCreatedDate()) : null);
		dto.setId(null != user.getId() ? user.getId() : null);
		dto.setImei(null != user.getImei() ? user.getImei() : null);
		dto.setAppVersion(null != user.getAppVersion() ? user.getAppVersion() : null);
		dto.setOs(null != user.getOs() ? user.getOs() : null);
		dto.setIsActive(null != user.getIsActive() ? user.getIsActive() : null);
		dto.setMobile(null != user.getMobile() ? user.getMobile() : null);
		dto.setModifiedBy(null != user.getModifiedBy() ? user.getModifiedBy() : null);
		dto.setModifiedDate(null != user.getModifiedDate() ? DateUtil.ddMMMyyyyStr(user.getModifiedDate()) : null);
		dto.setPassword(null != user.getPassword() ? user.getPassword() : null);
		dto.setUsername(null != user.getUsername() ? user.getUsername() : null);
		if (null != user.getRole()) {
			dto.setRole(user.getRole().stream().map(role -> RoleMapper.toDto(role)).collect(Collectors.toSet()));
		}
		//dto.setProductManager(null != user.getProductManager() ? user.getProductManager() : null);
		//dto.setImplManager(null != user.getImplManager() ? user.getImplManager() : null);
		return dto;
	}
}
