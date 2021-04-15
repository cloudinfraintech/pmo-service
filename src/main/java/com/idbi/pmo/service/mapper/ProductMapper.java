/**
 * 
 */
package com.idbi.pmo.service.mapper;

import java.text.ParseException;
import java.util.stream.Collectors;

import com.idbi.pmo.service.dto.ProductDto;
import com.idbi.pmo.service.model.Product;
import com.idbi.pmo.service.util.DateUtil;

/**
 * @author avinash
 *
 */
public class ProductMapper {
	public static Product toProduct(ProductDto dto) throws ParseException {
		Product product = new Product();
		product.setIsActive(null != dto.getIsActive() ? dto.getIsActive() : null);
		if (null != dto.getClient()) {
			product.setClient(dto.getClient().stream().map(clientDto -> {
				try {
					return ClientMapper.toClient(clientDto);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toSet()));
		}
		product.setCreatedBy(null != dto.getCreatedBy() ? dto.getCreatedBy() : null);
		product.setCreatedDate(null != dto.getCreatedDate() ? DateUtil.ddMMMyyyy(dto.getCreatedDate()) : null);
		product.setId(null != dto.getId() ? dto.getId() : null);
		product.setIsActive(null != dto.getIsActive() ? dto.getIsActive() : null);
		product.setModifiedBy(null != dto.getModifiedBy() ? dto.getModifiedBy() : null);
		product.setModifiedDate(null != dto.getModifiedDate() ? DateUtil.ddMMMyyyy(dto.getModifiedDate()) : null);
		product.setName(null != dto.getName() ? dto.getName() : null);
		return product;
	}

	public static ProductDto toDto(Product product) {
		ProductDto dto = new ProductDto();
		if (null != product.getClient()) {
			dto.setClient(
					product.getClient().stream().map(client -> ClientMapper.toDto(client)).collect(Collectors.toSet()));
		}
		dto.setCreatedBy(null != product.getCreatedBy() ? product.getCreatedBy() : null);
		dto.setCreatedDate(null != product.getCreatedDate() ? DateUtil.ddMMMyyyyStr(product.getCreatedDate()) : null);
		dto.setId(null != product.getId() ? product.getId() : null);
		dto.setIsActive(null != product.getIsActive() ? product.getIsActive() : null);
		dto.setModifiedBy(null != product.getModifiedBy() ? product.getModifiedBy() : null);
		dto.setModifiedDate(
				null != product.getModifiedDate() ? DateUtil.ddMMMyyyyStr(product.getModifiedDate()) : null);
		dto.setName(null != product.getName() ? product.getName() : null);
		return dto;
	}
}
