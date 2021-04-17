/**
 * 
 */
package com.idbi.pmo.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.idbi.pmo.service.dto.UserDto;
import com.idbi.pmo.service.exception.PMOException;
import com.idbi.pmo.service.mapper.UserMapper;
import com.idbi.pmo.service.model.Role;
import com.idbi.pmo.service.model.User;
import com.idbi.pmo.service.repository.EgenempmstRepository;
import com.idbi.pmo.service.repository.RoleRepository;
import com.idbi.pmo.service.repository.UserRepository;
import com.idbi.pmo.service.util.DateUtil;

/**
 * @author avina
 *
 */
@Service
public class UserService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private EgenempmstRepository egenempmstRepository;

	private static final String PM = "Product Manager";
	private static final String IM = "Implementation Manager";
	private static final String RM = "Relationship Manager";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public UserDto save(UserDto dto) throws Exception {
		// if (null == egenempmstRepository.findByEmply_Cd(dto.getUsername()))
		// return null;
		User newUser = UserMapper.toUser(dto);
		newUser.setIsActive(true);
		newUser.setCreatedDate(DateUtil.todayDate());
		newUser.setPassword(bcryptEncoder.encode(dto.getPassword()));
		try {
			if (null != dto.getRole()) {
				dto.getRole().stream().forEach(roleDto -> {
					Optional<Role> role = roleRepository.findById(roleDto.getId());
					if (!role.isPresent()) {
						throw new PMOException("Role does not exist. ");
					} else if (role.get().getName().equals(IM) && dto.getProductManager() == null) {
						throw new PMOException("Product Manager is empty.");
					} else if (role.get().getName().equals(IM) && dto.getProductManager() != null) {
						if (null == userRepository.findByUserIdAndRoleId(dto.getProductManager(), 2L)) {
							throw new PMOException("Product Manager does not exist.");
						}
					} else if (role.get().getName().equals(RM) && dto.getImplManager() == null) {
						throw new PMOException("Implementation manager is empty");
					} else if (role.get().getName().equals(RM) && dto.getImplManager() != null) {
						if (null == userRepository.findByUserIdAndRoleId(dto.getImplManager(), 3L)) {
							throw new PMOException("Implementation manager does not exist.");
						} else if (dto.getProductManager() == null) {
							throw new PMOException("Product Manager is empty.");
						} else if (null == userRepository.findByUserIdAndRoleId(dto.getProductManager(), 2L)) {
							throw new PMOException("Product Manager does not exist.");
						}
					}
				});
			}
			User user = userRepository.save(newUser);
			return UserMapper.toDto(user);
		} catch (DataIntegrityViolationException e) {
			logger.error(e.getMessage());
			throw new PMOException("User already exist.");
		}
	}

	public List<UserDto> findUserByProductId(Long productId) {
		return null;
		// return userRepository.findByProductMgrByProductId(productId).stream().map(dto
		// -> UserMapper.toDto(dto))
		// .collect(Collectors.toList());
	}

	public String validateEin(String ein) {
		return (null != egenempmstRepository.findByEmplyCd(Long.valueOf(ein)) ? "success" : "fail");
	}
}
