package gov.sanction.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import gov.sanction.entity.ApiResponse;
import gov.sanction.exception.IFMSException;
import gov.sanction.request.SSORequest;
import gov.sanction.response.SSOResponse;
import gov.sanction.service.SSOservice;

@Path("/")
public class SSOController {
	
	@Inject
	private SSOservice service;
	
	@Path("/getemp")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response  getSso(SSORequest request)  throws IFMSException{
		List<SSOResponse> responses = service.getSSO(request);
		 return Response.ok(ApiResponse.success(responses)).build();
	}

}
