package gov.sanction.request;

import java.sql. Timestamp ;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Table(schema = "SSO",name = "ASSIGNMENT_TYPE")
@Data
public class AssignmentType {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "ASSIGN_TYPE_ID")
	private  int  AssignTypeId;
	@Column(name = "USER_ID")
	private  int  UserId;
	@Column(name = "ROLE_ID")
	private  int  RoleId;
	@Column(name = "ASSIGN_LEVEL_ID")
	private  int  AssignLevelId;
	@Column(name = "ASSIGN_LEVEL_VALUE")
	private  String  AssignLevelValue;
	@Column(name = "INSERTED_BY")
	private String InsertedBy;
	@Column(name = "INSERTED_DT")
	private Timestamp InsertedDt;
	@Column(name = "INSERTED_IP")
	private String InsertedIp;
	@Column(name = "UPDATED_BY")
	private String UpdatedBy;
	@Column(name = "UPDATED_DT")
	private Timestamp UpdatedDt;
	@Column(name = "UPDATED_IP")
	private String UpdatedIp; 
	@Column(name = "OPER_FLAG")
	private char OperFlag;
	@Column(name = "OPER_FROM_DATE")
	private Date OperFromDate;
	@Column(name = "OPER_TO_DATE")
	private Date OperToDate;
	@Column(name = "STATE_CODE")
	private int StateCode;
	
}
