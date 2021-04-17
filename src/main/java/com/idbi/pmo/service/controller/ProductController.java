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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idbi.pmo.service.dto.ProductDto;
import com.idbi.pmo.service.dto.RequestDto;
import com.idbi.pmo.service.service.ProductService;
import com.idbi.pmo.service.util.PMOEnum;

/**
 * @author avinash
 *
 */

@RestController
@RequestMapping("/product")
public class ProductController {
	private static final Logger loggger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody ProductDto dto) {
		loggger.info("Create product initiated: ");
		try {
			productService.createProduct(dto);
			return new ResponseEntity<String>(PMOEnum.OK.getMessage(), HttpStatus.OK);
		} catch (Exception e) {
			loggger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/findbyclient")
	public ResponseEntity<?> productByCLient(@RequestBody RequestDto dto) {
		loggger.info("Get product by client initiated:");
		try {
			return new ResponseEntity<List<ProductDto>>(productService.productByCLient(dto.getId()), HttpStatus.OK);
		} catch (Exception e) {
			loggger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}
}
