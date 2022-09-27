package gov.sanction.responseDto;

import java.math.BigDecimal;
import java.util.List;

public class TaskAssignResponseDto {

		

		private BigDecimal levelTypeId;
		
		private String levelType;
		
		private String inchargeRoleID;
		
		private List<TaskDetailsDto> taskdetails;

	

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

		public List<TaskDetailsDto> getTaskdetails() {
			return taskdetails;
		}

		public void setTaskdetails(List<TaskDetailsDto> taskdetails) {
			this.taskdetails = taskdetails;
		}

		public TaskAssignResponseDto( BigDecimal levelTypeId, String levelType,
				String inchargeRoleID, List<TaskDetailsDto> taskdetails) {
			super();
			
			this.levelTypeId = levelTypeId;
			this.levelType = levelType;
			this.inchargeRoleID = inchargeRoleID;
			this.taskdetails = taskdetails;
		}

		public TaskAssignResponseDto() {
			super();
		}

		@Override
		public String toString() {
			return "TaskAssignResponseDto [ levelTypeId=" + levelTypeId
					+ ", levelType=" + levelType + ", inchargeRoleID=" + inchargeRoleID + ", taskdetails=" + taskdetails
					+ "]";
		}

	

		
}
