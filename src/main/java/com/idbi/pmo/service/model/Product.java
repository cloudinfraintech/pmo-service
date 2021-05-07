/**
 * 
 */
package com.idbi.pmo.service.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@ManyToOne
	@JoinColumn(name = "createdBy")
	private User createdBy;
	@ManyToOne
	@JoinColumn(name = "modifiedBy")
	private User modifiedBy;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_client", joinColumns = {
			@JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "id") })
	private Set<Client> client;
	@ManyToOne
	@JoinColumn(name = "pm")
	private User productManager;
	@ManyToOne
	@JoinColumn(name = "im")
	private User implManager;
	@ManyToOne
	@JoinColumn(name = "rm")
	private User relManager;
	private Date kickOff;
	private Date startDate;
	private Date uatDate;
	private Date liveDate;
	private Boolean docStatus;
	private Boolean activityStatus;
	private String comment;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_hardware", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "hardware_id", referencedColumnName = "id") })
	private List<HardwareSizing> hardwareSizing;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_milestone", joinColumns = {
			@JoinColumn(name = "prooduct_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "milestone_id", referencedColumnName = "id") })
	private List<Milestone> mileStone;
}
