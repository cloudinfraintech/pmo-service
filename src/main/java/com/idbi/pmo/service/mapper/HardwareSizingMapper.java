/**
 * 
 */
package com.idbi.pmo.service.mapper;

import com.idbi.pmo.service.dto.HardwareSizingDto;
import com.idbi.pmo.service.model.HardwareSizing;

/**
 * @author avinash
 *
 */
public class HardwareSizingMapper {

	public static HardwareSizing toHardwareSizing(HardwareSizingDto dto) {
		HardwareSizing hardwareSizing = new HardwareSizing();
		hardwareSizing.setId(null != dto.getId() ? dto.getId() : null);
		hardwareSizing.setConfiguration(null != dto.getConfiguration() ? dto.getConfiguration() : null);
		hardwareSizing.setQuantity(null != dto.getQuantity() ? dto.getQuantity() : null);
		hardwareSizing.setServer(null != dto.getServer() ? dto.getServer() : null);
		return hardwareSizing;
	}

	public static HardwareSizingDto toDto(HardwareSizing sizing) {
		HardwareSizingDto dto = new HardwareSizingDto();
		dto.setId(null != sizing.getId() ? sizing.getId() : null);
		dto.setConfiguration(null != sizing.getConfiguration() ? sizing.getConfiguration() : null);
		dto.setQuantity(null != sizing.getQuantity() ? sizing.getQuantity() : null);
		dto.setServer(null != sizing.getServer() ? sizing.getServer() : null);
		return dto;
	}
}
