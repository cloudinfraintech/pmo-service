/**
 * 
 */
package com.idbi.pmo.service.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author avinash
 *
 */
@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	@Column
	@JsonIgnore
	private String password;
	@Column(nullable = false)
	private String mobile;
	@Column(nullable = false)
	private String imei;
	private String appVersion;
	private Integer os;
	private Boolean isActive;
	private Date createdDate;
	private Date modifiedDate;
	private Long createdBy;
	private Long modifiedBy;
	private Long productManager;
	private Long implManager;
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "id") })
	private Set<Role> role;
	@ManyToMany
	@JoinTable(name = "user_product", joinColumns = { @JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "id") })
	private Set<Product> product;
}
