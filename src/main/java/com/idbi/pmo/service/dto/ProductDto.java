/**
 * 
 */
package com.idbi.pmo.service.dto;

import java.util.List;
import java.util.Set;

import lombok.Data;

/**
 * @author avinash
 *
 */
@Data
public class ProductDto {
	private Long id;
	private String name;
	private Boolean isActive;
	private String createdDate;
	private String modifiedDate;
	private Long createdBy;
	private Long modifiedBy;
	private Set<ClientDto> client;
	private Long productManager;
	private Long implManager;
	private Long relManager;
	private String kickOff;
	private String startDate;
	private String uatDate;
	private String liveDate;
	private Boolean docStatus;
	private Boolean activityStatus;
	private String comment;
	private List<HardwareSizingDto> hardwareSizing;
	private List<MilestoneDto> mileStone;
}
