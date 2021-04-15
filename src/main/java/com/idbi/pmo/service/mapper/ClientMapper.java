/**
 * 
 */
package com.idbi.pmo.service.mapper;

import java.text.ParseException;

import com.idbi.pmo.service.dto.ClientDto;
import com.idbi.pmo.service.model.Client;
import com.idbi.pmo.service.util.DateUtil;

/**
 * @author avinash
 *
 */
public class ClientMapper {
	public static Client toClient(ClientDto dto) throws ParseException {
		Client client = new Client();
		client.setClientName(null != dto.getClientName() ? dto.getClientName() : null);
		client.setCreatedBy(null != dto.getCreatedBy() ? dto.getCreatedBy() : null);
		client.setCreatedDate(null != dto.getCreatedDate() ? DateUtil.ddMMMyyyy(dto.getCreatedDate()) : null);
		client.setId(null != dto.getId() ? dto.getId() : null);
		client.setIsActive(null != dto.getIsActive() ? dto.getIsActive() : null);
		client.setModifiedBy(null != dto.getModifiedBy() ? dto.getModifiedBy() : null);
		client.setModifiedDate(null != dto.getModifiedDate() ? DateUtil.ddMMMyyyy(dto.getModifiedDate()) : null);
		return client;
	}

	public static ClientDto toDto(Client client) {
		ClientDto dto = new ClientDto();
		dto.setClientName(null != client.getClientName() ? client.getClientName() : null);
		dto.setCreatedBy(null != client.getCreatedBy() ? client.getCreatedBy() : null);
		dto.setCreatedDate(null != client.getCreatedDate() ? DateUtil.ddMMMyyyyStr(client.getCreatedDate()) : null);
		dto.setId(null != client.getId() ? client.getId() : null);
		dto.setIsActive(null != client.getIsActive() ? client.getIsActive() : null);
		dto.setModifiedBy(null != client.getModifiedBy() ? client.getModifiedBy() : null);
		dto.setModifiedDate(null != client.getModifiedDate() ? DateUtil.ddMMMyyyyStr(client.getModifiedDate()) : null);
		return dto;
	}

}
