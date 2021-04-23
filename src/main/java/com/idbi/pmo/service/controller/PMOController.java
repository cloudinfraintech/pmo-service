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
import org.springframework.web.bind.annotation.RestController;

import com.idbi.pmo.service.service.EgenempmstService;

/**
 * @author avinash
 *
 */
@RestController
@CrossOrigin
public class PMOController {
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

	@Autowired
	private EgenempmstService egenempmstService;

	@GetMapping(value = "/search/{name}")
	public ResponseEntity<List<String>> findLikeName(@PathVariable String name) {
		logger.info("Search initiated :" + name);
		try {
			List<String> list = egenempmstService.findLikeName(name);
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		} catch (Exception e) {
			logger.equals(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
