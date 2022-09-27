package gov.sanction.response;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class ProcessResponse {

	private BigDecimal levelTypeId;
	private String levelType;
	private String inchargeRoleID;
	private BigDecimal taskId;
	private String taskRoleName;


}
