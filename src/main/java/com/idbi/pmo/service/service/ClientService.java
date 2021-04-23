/**
 * 
 */
package com.idbi.pmo.service.service;

import java.util.List;

import com.idbi.pmo.service.dto.ClientDto;

/**
 * @author avinash
 *
 */
public interface ClientService {
	void create(ClientDto dto) throws Exception;

	List<ClientDto> findAll();

	ClientDto updateClient(ClientDto dto) throws Exception;

}
