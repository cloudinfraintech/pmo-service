/**
 * 
 */
package com.idbi.pmo.service.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

/**
 * @author avinash
 *
 */
@Entity
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	private Boolean isActive;
	private Date createdDate;
	private Date modifiedDate;
	private Long createdBy;
	private Long modifiedBy;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_client", joinColumns = {
			@JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "id") })
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private Set<Client> client;
	@Column(name = "pm")
	private Long productManager;
	@Column(name = "im")
	private Long implManager;
	@Column(name = "rm")
	private Long relManager;

}
