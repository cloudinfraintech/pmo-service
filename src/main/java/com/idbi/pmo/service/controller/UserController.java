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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.pmo.service.dto.ErrorDto;
import com.idbi.pmo.service.dto.RequestDto;
import com.idbi.pmo.service.dto.UserDto;
import com.idbi.pmo.service.service.UserService;

/**
 * @author avinash
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/{productId}")
	public ResponseEntity<?> findProdyctMgrByProductId(@PathVariable("productId") Long productId) {
		logger.info("Find product manager by product id initiated.");
		try {

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
		return null;
	}

	@PostMapping("/pmByProduct")
	public ResponseEntity<?> findPMByProduct(@RequestBody RequestDto dto) {
		logger.info("Find Product manager initiated.");
		try {
			return new ResponseEntity<UserDto>(userService.findPMByProductId(dto.getReqId1()), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/imByProduct")
	public ResponseEntity<?> findIMByProduct(@RequestBody RequestDto dto) {
		logger.info("Find implementation manager initiated.");
		try {
			return new ResponseEntity<UserDto>(userService.findIMByProductId(dto.getReqId1(), dto.getReqId2()),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/rmByProduct")
	public ResponseEntity<?> findRMByProduct(@RequestBody RequestDto dto) {
		logger.info("Find relationship manager initiated.");
		try {
			return new ResponseEntity<UserDto>(
					userService.findRMByProductId(dto.getReqId1(), dto.getReqId2(), dto.getReqId3()), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/byRole")
	public ResponseEntity<?> userListByRole(@RequestBody RequestDto dto) {
		logger.info("User by role initiated.");
		try {
			return new ResponseEntity<List<UserDto>>(userService.findUserByRole(dto.getReqId1()), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody RequestDto dto) {
		logger.info("User delte initiated.");
		try {
			return new ResponseEntity<UserDto>(userService.delete(dto), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<ErrorDto>(new ErrorDto(e.getMessage(), null), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/findByUsername")
	public ResponseEntity<?> findUserByUserName(@RequestBody RequestDto dto) {
		logger.info("Find user by user name initiated.");
		try {
			return new ResponseEntity<UserDto>(userService.findUserByUserName(dto.getEin()), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}

	}

}
