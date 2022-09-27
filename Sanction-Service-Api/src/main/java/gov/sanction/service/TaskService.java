package gov.sanction.service;

import java.util.List;

import gov.sanction.responseDto.TaskAssignResponseDto;

public interface TaskService {

	public List<TaskAssignResponseDto> getTask(int id) ;
	
}
