/**
 * 
 */
package com.idbi.pmo.service.mapper;

import java.text.ParseException;
import java.util.stream.Collectors;

import com.idbi.pmo.service.dto.ProductDto;
import com.idbi.pmo.service.exception.PMOException;
import com.idbi.pmo.service.model.Product;
import com.idbi.pmo.service.util.DateUtil;

/**
 * @author avinash
 *
 */
public class ProductMapper {
	public static Product toProduct(ProductDto dto) throws Exception {
		Product product = new Product();
		product.setIsActive(null != dto.getIsActive() ? dto.getIsActive() : null);
		if (null != dto.getClient()) {
			product.setClient(dto.getClient().stream().map(clientDto -> {
				try {
					return ClientMapper.toClient(clientDto);
				} catch (ParseException e) {
					e.printStackTrace();
					throw new PMOException(e.getMessage());
				}
			}).collect(Collectors.toSet()));
		}
		product.setCreatedBy(null != dto.getCreatedBy() ? UserMapper.toUser(dto.getCreatedBy()) : null);
		product.setCreatedDate(null != dto.getCreatedDate() ? DateUtil.ddMMMyyyy(dto.getCreatedDate()) : null);
		product.setId(null != dto.getId() ? dto.getId() : null);
		product.setIsActive(null != dto.getIsActive() ? dto.getIsActive() : null);
		product.setModifiedBy(null != dto.getModifiedBy() ? UserMapper.toUser(dto.getModifiedBy()) : null);
		product.setModifiedDate(null != dto.getModifiedDate() ? DateUtil.ddMMMyyyy(dto.getModifiedDate()) : null);
		product.setName(null != dto.getName() ? dto.getName() : null);
		product.setProductManager(null != dto.getProductManager() ? UserMapper.toUser(dto.getProductManager()) : null);
		product.setImplManager(null != dto.getImplManager() ? UserMapper.toUser(dto.getImplManager()) : null);
		product.setRelManager(null != dto.getRelManager() ? UserMapper.toUser(dto.getRelManager()) : null);
		product.setKickOff(null != dto.getKickOff() ? DateUtil.ddMMMyyyy(dto.getKickOff()) : null);
		product.setStartDate(null != dto.getStartDate() ? DateUtil.ddMMMyyyy(dto.getStartDate()) : null);
		product.setUatDate(null != dto.getUatDate() ? DateUtil.ddMMMyyyy(dto.getUatDate()) : null);
		product.setLiveDate(null != dto.getLiveDate() ? DateUtil.ddMMMyyyy(dto.getLiveDate()) : null);
		product.setDocStatus(null != dto.getDocStatus() ? dto.getDocStatus() : null);
		product.setActivityStatus(null != dto.getActivityStatus() ? dto.getActivityStatus() : null);
		product.setComment(null != dto.getComment() ? dto.getComment() : null);
		if (null != dto.getHardwareSizing()) {
			product.setHardwareSizing(dto.getHardwareSizing().stream()
					.map(HardwareDto -> HardwareSizingMapper.toHardwareSizing(HardwareDto))
					.collect(Collectors.toList()));
		}
		if (null != dto.getMileStone()) {
			product.setMileStone(dto.getMileStone().stream().map(mileStoneDto -> {
				try {
					return MilestoneMapper.toMilestone(mileStoneDto);
				} catch (ParseException e) {
					throw new PMOException(e.getMessage());
				}
			}).collect(Collectors.toList()));
		}
		return product;
	}

	public static ProductDto toDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setCreatedBy(null != product.getCreatedBy() ? UserMapper.toDto(product.getCreatedBy()) : null);
		dto.setCreatedDate(null != product.getCreatedDate() ? DateUtil.ddMMMyyyyStr(product.getCreatedDate()) : null);
		dto.setId(null != product.getId() ? product.getId() : null);
		dto.setIsActive(null != product.getIsActive() ? product.getIsActive() : null);
		dto.setModifiedBy(null != product.getModifiedBy() ? UserMapper.toDto(product.getModifiedBy()) : null);
		dto.setModifiedDate(
				null != product.getModifiedDate() ? DateUtil.ddMMMyyyyStr(product.getModifiedDate()) : null);
		dto.setName(null != product.getName() ? product.getName() : null);
		dto.setProductManager(
				null != product.getProductManager() ? UserMapper.toDto(product.getProductManager()) : null);
		dto.setImplManager(null != product.getImplManager() ? UserMapper.toDto(product.getImplManager()) : null);
		dto.setRelManager(null != product.getRelManager() ? UserMapper.toDto(product.getRelManager()) : null);
		dto.setKickOff(null != product.getKickOff() ? DateUtil.ddMMMyyyyStr(product.getKickOff()) : null);
		dto.setStartDate(null != product.getStartDate() ? DateUtil.ddMMMyyyyStr(product.getStartDate()) : null);
		dto.setUatDate(null != product.getUatDate() ? DateUtil.ddMMMyyyyStr(product.getUatDate()) : null);
		dto.setLiveDate(null != product.getLiveDate() ? DateUtil.ddMMMyyyyStr(product.getLiveDate()) : null);
		dto.setDocStatus(null != product.getDocStatus() ? product.getDocStatus() : null);
		dto.setComment(null != product.getComment() ? product.getComment() : null);
		dto.setActivityStatus(null != product.getActivityStatus() ? product.getActivityStatus() : null);
		if (null != product.getClient()) {
			dto.setClient(
					product.getClient().stream().map(client -> ClientMapper.toDto(client)).collect(Collectors.toSet()));
		}
		if (null != product.getMileStone()) {
			dto.setMileStone(product.getMileStone().stream().map(milestone -> MilestoneMapper.toDto(milestone))
					.collect(Collectors.toList()));
		}
		if (null != product.getHardwareSizing()) {
			dto.setHardwareSizing(product.getHardwareSizing().stream()
					.map(hardwar -> HardwareSizingMapper.toDto(hardwar)).collect(Collectors.toList()));
		}
		return dto;
	}
}
