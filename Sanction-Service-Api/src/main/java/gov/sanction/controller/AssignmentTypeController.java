package gov.sanction.controller;

import javax.inject.Inject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import gov.sanction.entity.AssignmentTypeEntity;
import gov.sanction.service.UpdateService;



@Path("/")
public class AssignmentTypeController 
{
	@Inject
	private UpdateService updateService;
	
	

			
		@POST
	    @Path("/saveAssignmentType")
	  
		public Response createDetails(@RequestBody AssignmentTypeEntity request) {
		AssignmentTypeEntity rs = updateService.createService(request);
	  	
	  	 return Response.ok(rs).build(); }
}



