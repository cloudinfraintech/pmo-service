/**
 * 
 */
package com.idbi.pmo.service.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbi.pmo.service.repository.EgenempmstRepository;
import com.idbi.pmo.service.service.EgenempmstService;

/**
 * @author avinash
 *
 */
@Service
@Transactional
public class EgenempstServiceImpl implements EgenempmstService {

	@Autowired
	private EgenempmstRepository egenempmstRepository;

	@Override
	public List<String> findLikeName(String name) {
		return egenempmstRepository.findByNm(name);
	}
}
