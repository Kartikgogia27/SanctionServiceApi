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
import gov.sanction.request.ProcessAssignRequest;
import gov.sanction.responseDto.ProcessResponseDto;
import gov.sanction.service.ProcessService;
@Path("/")
public class ProcessController {
			
	
	@Inject
	private ProcessService  processService;
	
	
	
	@Path("/getTaskList")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response  getAllTask(@RequestBody ProcessAssignRequest processRequest)  throws IFMSException{
		List<ProcessResponseDto> listofprocess = processService.getProcess(processRequest.getProcessId());
		 return Response.ok(ApiResponse.success(listofprocess)).build();
	}
	
	
}
