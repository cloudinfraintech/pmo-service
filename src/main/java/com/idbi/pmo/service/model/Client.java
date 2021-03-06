/**
 * 
 */
package com.idbi.pmo.service.model;

import java.util.Date;

import javax.persistence.Column;
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
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String clientName;
	private Boolean isActive;
	private Date createdDate;
	private Date modifiedDate;
	private Long createdBy;
	private Long modifiedBy;
	//@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client")
	//private Set<Product> product;
}
