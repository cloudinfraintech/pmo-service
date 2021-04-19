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

import com.idbi.pmo.service.dto.ProductDto;
import com.idbi.pmo.service.exception.PMOException;
import com.idbi.pmo.service.mapper.ClientMapper;
import com.idbi.pmo.service.mapper.ProductMapper;
import com.idbi.pmo.service.model.Client;
import com.idbi.pmo.service.model.Product;
import com.idbi.pmo.service.repository.ClientRepository;
import com.idbi.pmo.service.repository.ProductRepository;
import com.idbi.pmo.service.repository.UserRepository;
import com.idbi.pmo.service.service.ProductService;
import com.idbi.pmo.service.util.DateUtil;

/**
 * @author avinash
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void createProduct(ProductDto dto) throws Exception {
		Product product = ProductMapper.toProduct(dto);
		if (null == userRepository.findByUserIdAndRoleId(dto.getProductManager(), 2L)) {
			throw new PMOException("Product manager does't exist");
		} else if (null == userRepository.findByUserIdAndRoleId(dto.getImplManager(), 3L)) {
			throw new PMOException("Implementation manager does't exist");
		} else if (null == userRepository.findByUserIdAndRoleId(dto.getRelManager(), 4L)) {
			throw new PMOException("Relationship manager does't exist");
		}
		product.setIsActive(true);
		product.setCreatedDate(DateUtil.todayDate());
		if (null != dto.getClient()) {
			dto.getClient().stream().forEach(clientDto -> {
				Optional<Client> client = clientRepository.findById(clientDto.getId());
				if (!client.isPresent()) {
					throw new PMOException("Client does not exist with id :" + clientDto.getId());
				}
			});
			product.setClient(dto.getClient().stream().map(clientDto -> {
				try {
					return ClientMapper.toClient(clientDto);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toSet()));
		}
		try {
			productRepository.save(product);
		} catch (DataIntegrityViolationException e) {
			throw new PMOException("Product already exist.");
		} catch (Exception e) {
			throw new PMOException(e.getMessage());
		}
	}

	@Override
	public List<ProductDto> productByCLient(Long clientId) {
		Optional<Client> client = clientRepository.findById(clientId);
		if (!client.isPresent()) {
			throw new PMOException("Client doest not exist");
		}
		return productRepository.findByClient(client.get().getId()).stream()
				.map(product -> ProductMapper.toDto(product)).collect(Collectors.toList());
	}

}
