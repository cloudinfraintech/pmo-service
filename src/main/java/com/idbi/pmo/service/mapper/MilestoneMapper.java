/**
 * 
 */
package com.idbi.pmo.service.mapper;

import java.text.ParseException;

import com.idbi.pmo.service.dto.MilestoneDto;
import com.idbi.pmo.service.model.Milestone;
import com.idbi.pmo.service.util.DateUtil;

/**
 * @author avinash
 *
 */
public class MilestoneMapper {
	public static Milestone toMilestone(MilestoneDto dto) throws ParseException {
		Milestone milestone = new Milestone();
		milestone.setId(null != dto.getId() ? dto.getId() : null);
		milestone.setMilestoneDetails(null != dto.getMilestoneDetails() ? dto.getMilestoneDetails() : null);
		milestone.setMileStoneDt(null != dto.getMileStoneDt() ? DateUtil.ddMMMyyyy(dto.getMileStoneDt()) : null);
		milestone.setPercentage(null != dto.getPercentage() ? dto.getPercentage() : null);
		return milestone;
	}

	public static MilestoneDto toDto(Milestone m) {
		MilestoneDto dto = new MilestoneDto();
		dto.setId(null != m.getId() ? m.getId() : null);
		dto.setMilestoneDetails(null != m.getMilestoneDetails() ? m.getMilestoneDetails() : null);
		dto.setMileStoneDt(null != m.getMileStoneDt() ? DateUtil.ddMMMyyyyStr(m.getMileStoneDt()) : null);
		dto.setPercentage(null != m.getPercentage() ? m.getPercentage() : null);
		return dto;
	}
}
