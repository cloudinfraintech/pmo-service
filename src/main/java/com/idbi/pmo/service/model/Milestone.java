/**
 * 
 */
package com.idbi.pmo.service.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author avinash
 *
 */
@Entity
@Data
public class Milestone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String milestoneDetails;
	private Date mileStoneDt;
	private String percentage;
}
