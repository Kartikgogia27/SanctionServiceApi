package gov.sanction.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import gov.sanction.entity.ApiResponse;
import gov.sanction.exception.IFMSException;
import gov.sanction.request.TaskAssignRequest;
import gov.sanction.responseDto.TaskAssignResponseDto;
import gov.sanction.service.TaskService;

@Path("/")
public class TaskAssignmentController {
	
		
		@Inject
		private TaskService  taskService;
		
		
		@Path("/getTaskDetails")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public Response  getAllTask(@RequestBody TaskAssignRequest assignRequest) throws IFMSException{
			List<TaskAssignResponseDto> listOfTask = taskService.getTask(assignRequest.getProcessId());
			 return Response.ok(ApiResponse.success(listOfTask)).build();
}
		
}
