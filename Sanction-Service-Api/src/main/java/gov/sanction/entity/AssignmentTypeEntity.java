package gov.sanction.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;
@Data
public class AssignmentTypeEntity {
	
	
	private int	user_id;
	private int introle_id;

	private Timestamp inserted_dt;
	private String inserted_ip;
	private String updated_by;
	private Timestamp updated_dt;
	private Date oper_from_date;
	private Date oper_to_date;
	
	
	
}
