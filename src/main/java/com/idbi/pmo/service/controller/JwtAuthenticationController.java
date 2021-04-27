/**
 * 
 */
package com.idbi.pmo.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.pmo.service.config.JwtTokenUtil;
import com.idbi.pmo.service.dto.JwtRequest;
import com.idbi.pmo.service.dto.JwtResponse;
import com.idbi.pmo.service.dto.RequestDto;
import com.idbi.pmo.service.dto.UserDto;
import com.idbi.pmo.service.service.UserService;

/**
 * @author avinash
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class JwtAuthenticationController {
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {

			logger.info("Authentication initiated :");
			final Authentication authentication = authenticate(authenticationRequest.getUsername(),
					authenticationRequest.getPassword());

			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

			final String token = jwtTokenUtil.generateToken(authentication);

			return ResponseEntity.ok(new JwtResponse(token));

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserDto dto) throws Exception {
		logger.info("Registration initiated:");
		try {
			return ResponseEntity.ok(userDetailsService.save(dto));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	private Authentication authenticate(String username, String password) throws Exception {
		try {
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@PostMapping("/validateEin")
	public ResponseEntity<?> validateEin(@RequestBody RequestDto dto) {
		logger.info("validate ein initiated.");
		try {
			return new ResponseEntity<String>(userDetailsService.validateEin(dto.getEin()), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}
}