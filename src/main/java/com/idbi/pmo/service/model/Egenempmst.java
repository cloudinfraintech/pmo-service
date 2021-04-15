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
public class Egenempmst {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emplyCd;
	private String nm;
	private Date brthDt;
	private Date jnngDt;
	private String sex;
	private Integer PF_INDX_NMBR;
	private String PAN_NMBR;
	private String PHP_IND;
	private String SLRY_STTS;
	private Integer BNK_CD;
	private String BNK_ACCNT_NMBR;
	private String PRFSSN_TAX_IND;
	private String SVNG_IND;
	private String EMAIL_ID;
	private String LOUNGE;
	private String BLOOD_GRP;
	private String FATHER_NM;
	private String SPOUSE_NM;
	private String OFFICIAL_EMAIL;
	private String PERSONAL_EMAIL;
	private String RELIGION;
	private String NATIONALITY;
	private Float HEIGHT;
	private Float WEIGHT;
	private String PASSPORT_NMBR;
	private Date PASSPORT_ISSUED_ON;
	private Date PASSPORT_EXPIRES_ON;
	private String MARITAL_STTS;
	private Date MARITAL_DATE;
	private Date PROBATION_UPTO;
	private Date CONFIRM_DATE;
	private String CONFIRM_STATUS;
	private Integer REPORTING1;
	private Integer REPORTING2;
	private Integer REPORTING3;
	private Integer GROUP_HEAD;
	private Date RESIGN_DATE;
	private String RESIGN_REASON;
	private String BANK_NAME;
	private String COMM_ADDR_DIFF;
	private Date ENTRY_DT;
	private Integer ENTRY_BY;
	private String UPDT_BY;
	private Date UPDT_DT;
	private String TRAN_ID;
	private String CHECKER_FLG;
	private String PAYSLIP_FLAG;
	private String UAN_ACCNT_NMBR;
}
