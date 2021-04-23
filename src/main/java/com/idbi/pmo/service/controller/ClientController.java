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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.pmo.service.dto.ClientDto;
import com.idbi.pmo.service.dto.ErrorDto;
import com.idbi.pmo.service.service.ClientService;
import com.idbi.pmo.service.util.PMOEnum;

/**
 * @author avinash
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ClientService clientService;

	@PostMapping
	public ResponseEntity<String> create(@RequestBody ClientDto dto) {
		try {
			clientService.create(dto);
			return new ResponseEntity<String>(PMOEnum.OK.getMessage(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping
	public ResponseEntity<List<ClientDto>> findAll() {
		logger.info("Get all client initiated.");
		try {
			return new ResponseEntity<List<ClientDto>>(clientService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping()
	public ResponseEntity<?> update(@RequestBody ClientDto dto) {
		logger.info("Update client initiated.");
		try {
			return new ResponseEntity<ClientDto>(clientService.updateClient(dto), HttpStatus.OK);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<ErrorDto>(new ErrorDto(e.getMessage(), null), HttpStatus.EXPECTATION_FAILED);
		}
	}
}
