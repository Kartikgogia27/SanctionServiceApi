package gov.sanction.responseDto;

import java.math.BigDecimal;

public class TaskDetailsDto {
	private BigDecimal taskId;
	private String taskRoleName;
	private BigDecimal assignedBy;
	
	public BigDecimal getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(BigDecimal assignedBy) {
		this.assignedBy = assignedBy;
	}
	public BigDecimal getTaskId() {
		return taskId;
	}
	public void setTaskId(BigDecimal bigDecimal) {
		this.taskId = bigDecimal;
	}
	public String getTaskRoleName() {
		return taskRoleName;
	}
	public void setTaskRoleName(String taskRoleName) {
		this.taskRoleName = taskRoleName;
	}
	
	@Override
	public String toString() {
		return "TaskDetailDto [taskRoleId=" + taskId + ", taskRoleName=" + taskRoleName + "]";
	}
	
}
