/**
 * 
 */
package com.idbi.pmo.service.service;

import java.util.List;

import com.idbi.pmo.service.dto.ProductDto;

/**
 * @author avinash
 *
 */
public interface ProductService {
	void createProduct(ProductDto dto) throws Exception;

	List<ProductDto> productByCLient(Long clientId);

}
