/**
 * 
 */
package com.idbi.pmo.service.service.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.idbi.pmo.service.dto.RequestDto;
import com.idbi.pmo.service.dto.RoleDto;
import com.idbi.pmo.service.exception.PMOException;
import com.idbi.pmo.service.mapper.RoleMapper;
import com.idbi.pmo.service.model.Role;
import com.idbi.pmo.service.repository.RoleRepository;
import com.idbi.pmo.service.repository.UserRepository;
import com.idbi.pmo.service.service.RoleService;
import com.idbi.pmo.service.util.DateUtil;

/**
 * @author avinash
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void create(RoleDto dto) throws Exception {
		Role role = RoleMapper.toRole(dto);
		role.setCreatedDate(DateUtil.todayDate());
		role.setIsActive(true);
		if (null == userRepository.findById(dto.getCreatedBy())) {
			throw new PMOException("Created by does not exist");
		}
		try {
			roleRepository.save(role);
		} catch (DataIntegrityViolationException e) {
			throw new PMOException("Role already exist.");
		}
	}

	@Override
	public List<RoleDto> getAllRole() {
		return roleRepository.findByIsActive(true).stream().map(role -> RoleMapper.toDto(role))
				.collect(Collectors.toList());
	}

	@Override
	public RoleDto delete(RequestDto dto) throws ParseException {
		Role role = roleRepository.findById(dto.getReqId1()).get();
		if (null == role) {
			throw new PMOException("Role does't found.");
		} else {
			role.setIsActive(false);
			role.setModifiedBy(dto.getReqId2());
			role.setModifiedDate(DateUtil.todayDate());
			return RoleMapper.toDto(roleRepository.save(role));
		}
	}

}
