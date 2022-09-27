package gov.sanction.serviceImpl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import gov.sanction.exception.IFMSException;
import gov.sanction.repo.TaskRepo;
import gov.sanction.responseDto.TaskAssignResponseDto;
import gov.sanction.service.TaskService;

@ApplicationScoped
public class TaskServiceImpl implements TaskService{

	@Inject
	private TaskRepo taskRepo;
	
	@Override
	public List<TaskAssignResponseDto> getTask(int id) {
		try {
			List<TaskAssignResponseDto> data = taskRepo.getAllTask(id);
			return data;
			}catch (IFMSException e) {
				e.getMessage();
				
			}
			return null;
	}

}
