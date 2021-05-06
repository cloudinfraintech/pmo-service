/**
 * 
 */
package com.idbi.pmo.service.service.impl;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.idbi.pmo.service.dto.ProductDto;
import com.idbi.pmo.service.exception.PMOException;
import com.idbi.pmo.service.mapper.ClientMapper;
import com.idbi.pmo.service.mapper.HardwareSizingMapper;
import com.idbi.pmo.service.mapper.MilestoneMapper;
import com.idbi.pmo.service.mapper.ProductMapper;
import com.idbi.pmo.service.mapper.UserMapper;
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
		if (null == userRepository.findByUserIdAndRoleId(dto.getProductManager().getId(), 2L)) {
			throw new PMOException("Product manager does't exist");
		} else if (null == userRepository.findByUserIdAndRoleId(dto.getImplManager().getId(), 3L)) {
			throw new PMOException("Implementation manager does't exist");
		} else if (null == userRepository.findByUserIdAndRoleId(dto.getRelManager().getId(), 4L)) {
			throw new PMOException("Relationship manager does't exist");
		}
		product.setIsActive(true);
		product.setCreatedDate(DateUtil.todayDate());
		Set<Client> set = new HashSet<>();
		if (null != dto.getClient()) {
			dto.getClient().stream().forEach(clientDto -> {
				Optional<Client> client = clientRepository.findById(clientDto.getId());
				if (!client.isPresent()) {
					throw new PMOException("Client does not exist with id :" + clientDto.getId());
				} else {
					set.add(client.get());
				}
			});
		}
		product.setClient(set);
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

	@Override
	public ProductDto update(ProductDto dto) throws Exception {
		Optional<Product> product = productRepository.findById(dto.getId());
		Product prod = null;
		if (product.isPresent()) {
			prod = product.get();
			if (null != dto.getClient()) {
				prod.setClient(dto.getClient().stream().map(clientDto -> {
					try {
						return ClientMapper.toClient(clientDto);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return null;
				}).collect(Collectors.toSet()));
			}
			if (null != dto.getMileStone()) {
				prod.setMileStone(dto.getMileStone().stream().map(milestomeDto -> {
					try {
						return MilestoneMapper.toMilestone(milestomeDto);
					} catch (ParseException e) {
						throw new PMOException(e.getMessage());
					}
				}).collect(Collectors.toList()));
			}
			if (null != dto.getHardwareSizing()) {
				prod.setHardwareSizing(dto.getHardwareSizing().stream().map(HardwareDtdo -> {
					try {
						return HardwareSizingMapper.toHardwareSizing(HardwareDtdo);
					} catch (Exception e2) {
						throw new PMOException(e2.getMessage());
					}
				}).collect(Collectors.toList()));
			}
			prod.setName(dto.getName());
			prod.setModifiedBy(UserMapper.toUser(dto.getModifiedBy()));
			prod.setModifiedDate(DateUtil.todayDate());
			prod.setProductManager(UserMapper.toUser(dto.getProductManager()));
			prod.setImplManager(UserMapper.toUser(dto.getImplManager()));
			prod.setRelManager(UserMapper.toUser(dto.getRelManager()));
			prod.setKickOff(DateUtil.ddMMMyyyy(dto.getKickOff()));
			prod.setStartDate(DateUtil.ddMMMyyyy(dto.getStartDate()));
			prod.setUatDate(DateUtil.ddMMMyyyy(dto.getUatDate()));
			prod.setLiveDate(DateUtil.ddMMMyyyy(dto.getLiveDate()));
			prod.setComment(null != dto.getComment() ? dto.getComment() : null);
			prod.setActivityStatus(null != dto.getActivityStatus() ? dto.getActivityStatus() : null);
			prod.setDocStatus(null != dto.getDocStatus() ? dto.getDocStatus() : null);
		} else {
			throw new PMOException("Product not exist.");
		}
		return ProductMapper.toDto(productRepository.save(prod));
	}

	@Override
	public List<ProductDto> findAll() {
		return productRepository.findAll().stream().map(product -> ProductMapper.toDto(product))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto findById(Long id) {
		return ProductMapper.toDto(productRepository.findById(id).get());
	}

}
