/**
 * 
 */
package com.idbi.pmo.service.model;

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
public class HardwareSizing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String server;
	private String configuration;
	private Integer quantity;
}
