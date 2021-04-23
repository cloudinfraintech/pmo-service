/**
 * 
 */
package com.idbi.pmo.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.pmo.service.dto.RoleDto;
import com.idbi.pmo.service.service.RoleService;
import com.idbi.pmo.service.util.PMOEnum;

/**
 * @author avinash
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

	@Autowired
	private RoleService roleService;

	@PostMapping
	public ResponseEntity<String> create(@RequestBody RoleDto dto) {
		logger.info("Role post initiated :");
		try {
			roleService.create(dto);
			return new ResponseEntity<String>(PMOEnum.OK.getMessage(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<RoleDto>> getAllRole() {
		logger.info("Get all role initiated:");
		try {
			return new ResponseEntity<List<RoleDto>>(roleService.getAllRole(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
