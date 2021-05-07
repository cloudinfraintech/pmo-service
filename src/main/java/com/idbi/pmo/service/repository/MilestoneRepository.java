/**
 * 
 */
package com.idbi.pmo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idbi.pmo.service.model.Milestone;

/**
 * @author avinash
 *
 */
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

}
