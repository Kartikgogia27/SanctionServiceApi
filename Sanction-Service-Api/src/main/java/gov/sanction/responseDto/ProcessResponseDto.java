package gov.sanction.responseDto;

import java.math.BigDecimal;
import java.util.List;

public class ProcessResponseDto {

	

	private BigDecimal levelTypeId;
	
	private String levelType;
	
	private String inchargeRoleID;
	
	private List<ProcessDetailDto> taskdetails;

	

	public BigDecimal getLevelTypeId() {
		return levelTypeId;
	}

	public void setLevelTypeId(BigDecimal levelTypeId) {
		this.levelTypeId = levelTypeId;
	}


	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public String getInchargeRoleID() {
		return inchargeRoleID;
	}

	public void setInchargeRoleID(String string) {
		this.inchargeRoleID = string;
	}

	public List<ProcessDetailDto> getTaskdetails() {
		return taskdetails;
	}

	public void setTaskdetails(List<ProcessDetailDto> taskdetails) {
		this.taskdetails = taskdetails;
	}

	public ProcessResponseDto( BigDecimal levelTypeId, String levelType,
			String inchargeRoleID, List<ProcessDetailDto> taskdetails) {
		super();
		
		this.levelTypeId = levelTypeId;
		this.levelType = levelType;
		this.inchargeRoleID = inchargeRoleID;
		this.taskdetails = taskdetails;
	}

	public ProcessResponseDto() {
		super();
	}

	

	



	
	
	
}
