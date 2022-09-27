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
import gov.sanction.request.UserDetailRequest;
import gov.sanction.response.UserDetailResponse;
import gov.sanction.service.UserDetailService;


@Path("/")
public class UserDetailcontroller {

	@Inject
	private UserDetailService staffservice;


	@POST
	@Path("/getSSOUserDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getList(@RequestBody UserDetailRequest request) throws IFMSException {
		List<UserDetailResponse> listOfTask = staffservice.getList(request);
		 return Response.ok(ApiResponse.success(listOfTask)).build();
	}

}
