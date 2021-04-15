package com.idbi.pmo.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.idbi.pmo.service.dto.ClientDto;
import com.idbi.pmo.service.exception.PMOException;
import com.idbi.pmo.service.mapper.ClientMapper;
import com.idbi.pmo.service.model.Client;
import com.idbi.pmo.service.repository.ClientRepository;
import com.idbi.pmo.service.service.ClientService;
import com.idbi.pmo.service.util.DateUtil;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void create(ClientDto dto) throws Exception {
		try {
			Client client = ClientMapper.toClient(dto);
			client.setCreatedDate(DateUtil.todayDate());
			client.setIsActive(true);
			clientRepository.save(client);
		} catch (DataIntegrityViolationException e) {
			throw new PMOException("Client name already exist.");
		}
	}

	@Override
	public List<ClientDto> findAll() {
		return clientRepository.findAll().stream().map(client -> ClientMapper.toDto(client))
				.collect(Collectors.toList());
	}

}
